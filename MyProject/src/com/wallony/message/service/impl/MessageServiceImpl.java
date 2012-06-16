package com.wallony.message.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.MultiMap;
import com.wallony.maxmind.service.MaxMindService;
import com.wallony.message.dao.MessageDao;
import com.wallony.message.service.MessageService;
import com.wallony.object.IpLocation;
import com.wallony.object.Messages;
import com.wallonymessage.utils.MessagesComparator;

@Service("messageService")
@Scope
public class MessageServiceImpl implements MessageService {

	
	@Autowired
	private HazelcastInstance hazelcast;
	
	@Autowired
	private MaxMindService maxMindService;
	
	@Autowired
	@Qualifier("MessageDao")
	private MessageDao messageDao;

	private Lock syncLock;
	private MultiMap<String, Messages> messageMapGlobal;
	private MultiMap<Long, Messages> commentMap;
	private MultiMap<String, Messages> messageMapPublic;
	private MultiMap<String, Messages> messageMapSpecial;
	
	@PostConstruct
	public void init(){
		
		messageMapGlobal =  hazelcast.getMultiMap("wallony.messageMapGlobal");
		messageMapPublic =  hazelcast.getMultiMap("wallony.messageMapPublic");
		messageMapSpecial = hazelcast.getMultiMap("wallony.messageMapSpecial");
		commentMap = 		hazelcast.getMultiMap("wallony.commentMap");
		
		syncLock = hazelcast.getLock("banner.bannerplan.syncLock");
		if(syncLock.tryLock()) {
			List<Messages> messageList = null;
			if(messageMapGlobal.size()==0||messageMapPublic.size()==0||messageMapSpecial.size()==0){
				Calendar cal = Calendar.getInstance();
				cal.setTimeInMillis((cal.getTimeInMillis()-(1000*60*60*24)));
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				messageList = messageDao.listx(Messages.class, " messageDate> '"+df.format(cal.getTime())+"' ");
			}
			try {
				if(messageMapGlobal.size()==0) {
					for(Messages message : messageList){
						if(message.getMessageLevel()==1){
							if(message.getMessageId()!=0){
								commentMap.put(message.getMessageId(), message);
								continue;
							} 
							IpLocation ip = maxMindService.getLocation(message.getIp());
							messageMapGlobal.put(ip.getCountryCode(), message);
						}
					}
				}
				if(messageMapPublic.size()==0) {
					for(Messages message : messageList){
						if(message.getMessageLevel()==2){
							if(message.getMessageId()!=0){
								commentMap.put(message.getMessageId(), message);
								continue;
							} 
							IpLocation ip = maxMindService.getLocation(message.getIp());
							messageMapPublic.put(ip.getCountryCode()+"_"+ip.getCityName(), message);
						}
					}
				}
				if(messageMapSpecial.size()==0) {
					for(Messages message : messageList){
						if(message.getMessageLevel()==3){
							if(message.getMessageId()!=0){
								commentMap.put(message.getMessageId(), message);
								continue;
							} 
							messageMapSpecial.put(message.getIp(), message);
						}
					}
				}
			} finally {
				syncLock.unlock();
			}
		}
		
	}
	public void sayHello(String s) {
		System.out.println(s);
		
	}

	public void addMessageToGlobalCache(Messages message) {
		
		IpLocation ipLocation = maxMindService.getLocation(message.getIp());
		message.setMessageDate(new Date());
		message.setMessageLevel(1);
		messageDao.save(message);
		if(message.getMessageId()!=0){
//			Collection<Messages> tmpList = messageMapGlobal.get(ipLocation.getCountryCode());
//			for(Messages m : tmpList){
//				if(m.getId()==message.getMessageId()){
//					List<Messages> tmpMessageList = m.getMessagesList();
//					if(tmpMessageList==null){
//						tmpMessageList = new ArrayList<Messages>();
//					}
//					tmpMessageList.add(message);
//					m.setMessagesList(tmpMessageList);
////					messageMapGlobal.put(ipLocation.getCountryCode(), m);
//					break;
//				}
//			}
			commentMap.put(message.getMessageId(), message);
		} else {
			messageMapGlobal.put(ipLocation.getCountryCode(), message);
		}
	}
	
	public void addMessageToPublicCache(Messages message) {
		IpLocation ipLocation = maxMindService.getLocation(message.getIp());
		message.setMessageDate(new Date());
		message.setMessageLevel(2);
		messageDao.save(message);
		if(message.getMessageId()!=0){
			commentMap.put(message.getMessageId(), message);
		} else {
			messageMapPublic.put(ipLocation.getCountryCode()+"_"+ipLocation.getCityName(), message);
		}
	}
	
	public void addMessageToSpecialCache(Messages message) {

		message.setMessageDate(new Date());
		message.setMessageLevel(3);
		messageDao.save(message);
		if(message.getMessageId()!=0){
			commentMap.put(message.getMessageId(), message);
		} else {
			messageMapSpecial.put(message.getIp(), message);
		}
	}
	public List<Messages> getMessageToGlobalCache(String ip) {
		IpLocation ipLocation = maxMindService.getLocation(ip);
		Collection<Messages> tmpList = messageMapGlobal.get(ipLocation.getCountryCode());
		List<Messages> messageList = new ArrayList<Messages>();
		if(tmpList!=null){
			messageList = new ArrayList<Messages>(tmpList);
			Collections.sort(messageList, new MessagesComparator());
			for(Messages m : messageList){
				Collection<Messages> tl = commentMap.get(m.getId());
				if(tl!=null){
					m.setMessagesList(new ArrayList<Messages>(tl));
					Collections.sort(m.getMessagesList(), new MessagesComparator());
				}
			}
			return messageList;
		} else {
			return messageList;
		}
	}
	public List<Messages> getMessageToPublicCache(String ip) {
		IpLocation ipLocation = maxMindService.getLocation(ip);
		Collection<Messages> tmpList = messageMapPublic.get(ipLocation.getCountryCode()+"_"+ipLocation.getCityName());
		List<Messages> messageList = new ArrayList<Messages>();
		if(tmpList!=null){
			messageList = new ArrayList<Messages>(tmpList);
			Collections.sort(messageList, new MessagesComparator());
			for(Messages m : messageList){
				Collection<Messages> tl = commentMap.get(m.getId());
				if(tl!=null){
					m.setMessagesList(new ArrayList<Messages>(tl));
					Collections.sort(m.getMessagesList(), new MessagesComparator());
				}
			}			
			return messageList;
		} else {
			return messageList;
		}
	}
	public List<Messages> getMessageToSpecialCache(String ip) {
//		IpLocation ipLocation = maxMindService.getLocation(ip);
		Collection<Messages> tmpList = messageMapSpecial.get(ip);
		List<Messages> messageList = new ArrayList<Messages>();
		if(tmpList!=null){
			messageList = new ArrayList<Messages>(tmpList);
			Collections.sort(messageList, new MessagesComparator());
			for(Messages m : messageList){
				Collection<Messages> tl = commentMap.get(m.getId());
				if(tl!=null){
					m.setMessagesList(new ArrayList<Messages>(tl));
					Collections.sort(m.getMessagesList(), new MessagesComparator());
				}
			}			
			return messageList;
		} else {
			return messageList;
		}
	}
	public static void main(String[] args) {
		List<Messages> messageList = new ArrayList<Messages>();
		Calendar cal = Calendar.getInstance();
		Messages m = new Messages();
		m.setMessageDate(cal.getTime());
		messageList.add(m);
		m = new Messages();
		cal.setTimeInMillis(cal.getTimeInMillis()-312534674);
		m.setMessageDate(cal.getTime());
		messageList.add(m);
		m = new Messages();
		cal.setTimeInMillis(cal.getTimeInMillis()+412854674);
		m.setMessageDate(cal.getTime());
		messageList.add(m);
		Collections.sort(messageList, new MessagesComparator());
		for(Messages mm : messageList){
			System.out.println(mm.getMessageDate());
		}
	}
}

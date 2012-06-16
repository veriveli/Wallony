package com.wallony.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.wallony.maxmind.service.MaxMindService;
import com.wallony.message.service.MessageService;
import com.wallony.object.IpLocation;
import com.wallony.object.Messages;

public class HelloWorldAction extends ActionSupport{
	
	@Autowired
	public MessageService messageService;
	@Autowired
	public MaxMindService maxMindService;
	
	private int messageType;
	private Messages generalMessage;
	
	private Messages globalMessage;
	private Messages publicMessage;
	private Messages specialMessage;

	private List<Messages> globalMessageList;
	private List<Messages> publicMessageList;
	private List<Messages> specialMessageList;
	private IpLocation ipLocation;

	public String execute() throws Exception {
		String ip = "95.6.77.85";
//		String ip = "188.95.146.10";
		ipLocation = maxMindService.getLocation(ip);
		if(generalMessage!=null){
			generalMessage.setIp(ip);
			if(messageType==1){
				messageService.addMessageToGlobalCache(generalMessage);
			} else if(messageType==2){
				messageService.addMessageToPublicCache(generalMessage);
			} else if(messageType==3){
				messageService.addMessageToSpecialCache(generalMessage);
			}
		}
		if(globalMessage!=null){
			globalMessage.setIp(ip);
			messageService.addMessageToGlobalCache(globalMessage);
		} else if(publicMessage!=null){
			publicMessage.setIp(ip);
			messageService.addMessageToPublicCache(publicMessage);
		} else if(specialMessage!=null){
			specialMessage.setIp(ip);
			messageService.addMessageToSpecialCache(specialMessage);
		}
		
		globalMessageList = messageService.getMessageToGlobalCache(ip);
		publicMessageList = messageService.getMessageToPublicCache(ip);
		specialMessageList = messageService.getMessageToSpecialCache(ip);
		
		return "success";
	}

	public Messages getGlobalMessage() {
		return globalMessage;
	}

	public void setGlobalMessage(Messages globalMessage) {
		this.globalMessage = globalMessage;
	}

	public Messages getPublicMessage() {
		return publicMessage;
	}

	public void setPublicMessage(Messages publicMessage) {
		this.publicMessage = publicMessage;
	}

	public Messages getSpecialMessage() {
		return specialMessage;
	}

	public void setSpecialMessage(Messages specialMessage) {
		this.specialMessage = specialMessage;
	}

	public List<Messages> getGlobalMessageList() {
		return globalMessageList;
	}

	public void setGlobalMessageList(List<Messages> globalMessageList) {
		this.globalMessageList = globalMessageList;
	}

	public List<Messages> getPublicMessageList() {
		return publicMessageList;
	}

	public void setPublicMessageList(List<Messages> publicMessageList) {
		this.publicMessageList = publicMessageList;
	}

	public List<Messages> getSpecialMessageList() {
		return specialMessageList;
	}

	public void setSpecialMessageList(List<Messages> specialMessageList) {
		this.specialMessageList = specialMessageList;
	}

	public IpLocation getIpLocation() {
		return ipLocation;
	}

	public void setIpLocation(IpLocation ipLocation) {
		this.ipLocation = ipLocation;
	}

	public int getMessageType() {
		return messageType;
	}

	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public Messages getGeneralMessage() {
		return generalMessage;
	}

	public void setGeneralMessage(Messages generalMessage) {
		this.generalMessage = generalMessage;
	}

}
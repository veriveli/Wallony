package com.wallony.maxmind.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hazelcast.core.HazelcastInstance;
import com.wallony.maxmind.service.MaxMindService;
import com.wallony.message.dao.IpLocationDao;
import com.wallony.object.IpLocation;

@Service("ipService")
@Scope
public class MaxMindserviceImpl implements MaxMindService {

	
	@Autowired
	private HazelcastInstance hazelcast;
	
	@Autowired
	@Qualifier("IpLocationDao")
	private IpLocationDao ipLocationDao;
	
	
	private Lock syncLock;
	private Map<String,IpLocation> ipMap;
	
	@PostConstruct
	public void init(){
		ipMap = hazelcast.getMap("wallony.messageMap");
		syncLock = hazelcast.getLock("banner.bannerplan.syncLock");
		if(syncLock.tryLock()) {
			if(ipMap.isEmpty()) {
				try {
					List<IpLocation> ipList = ipLocationDao.listx(IpLocation.class, "1=1");
					for(IpLocation ip : ipList){
						ipMap.put(ip.getIp(), ip);
					}
				} finally {
					syncLock.unlock();
				}
			}
		}
		
		System.out.println("Map initialized");
	}
	public IpLocation getLocation(String ip) {
		IpLocation ipLocation = ipMap.get(ip);
		if(ipLocation==null){
			ipLocation = makeNewQuery(ip);
			ipLocationDao.save(ipLocation);
			ipMap.put(ip, ipLocation);
		}
		if(ipLocation==null){
			return new IpLocation();
		}
		return ipLocation;
	}
	
	private IpLocation makeNewQuery(String ip){
		IpLocation ipl = new IpLocation();
		
		String license_key = "m7kFlbpWp2im";
		String url_str = "http://geoip.maxmind.com/f?l=" + license_key + "&i=" + ip;
		URL url = null;
		BufferedReader in = null;
		try {
			url = new URL(url_str);
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			String inLine = "";
			while ((inLine = in.readLine()) != null) {
				String[] i = inLine.split(",");
				ipl = new IpLocation(ip, i[0], i[1], i[2], i[4]+","+i[5], i[8], i[9], new Date());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return ipl;
	}
}

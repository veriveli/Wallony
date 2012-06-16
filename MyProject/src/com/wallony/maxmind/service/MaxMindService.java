package com.wallony.maxmind.service;

import com.wallony.object.IpLocation;



public interface MaxMindService {
	
	public IpLocation getLocation(String ip);
}

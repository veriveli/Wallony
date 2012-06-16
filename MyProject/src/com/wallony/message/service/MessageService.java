package com.wallony.message.service;

import java.util.List;

import com.wallony.object.Messages;



public interface MessageService {
	
	public void sayHello(String s);
	
	public void addMessageToGlobalCache(Messages message);
	
	public void addMessageToPublicCache(Messages message);
	
	public void addMessageToSpecialCache(Messages message);
	
	public List<Messages> getMessageToGlobalCache(String ip);
	                    
	public List<Messages> getMessageToPublicCache(String ip);
	                    
	public List<Messages> getMessageToSpecialCache(String ip);

}

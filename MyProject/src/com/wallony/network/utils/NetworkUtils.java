package com.wallony.network.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/**
 * @author mm
 */

public abstract class NetworkUtils {
	
	/**
	 * Returns default local address. (either loopback or non-loopback)
	 * @return InetAddress
	 * @throws UnknownHostException
	 */
	public static InetAddress getLocalAddress() throws UnknownHostException {
		return InetAddress.getLocalHost();
	}
	
	/**
	 * Returns local host name.
	 * @return Hostname
	 * @throws UnknownHostException
	 */
	public static String getLocalHostName() throws UnknownHostException {
		return getLocalAddress().getHostName(); 
	}
	
	/**
	 * Returns a non-loopback local ip address. (which is not 127.0.0.1)
	 * @return local non-loopback ip
	 * @throws SocketException
	 * @throws UnknownHostException
	 */
	public static String getLocalIP() throws SocketException, UnknownHostException {
		return pickNonLoopbackLocalAddress().getHostAddress();
	}

	/**
	 * Returns a non-loopback local address.
	 * @return InetAddress
	 * @throws SocketException
	 * @throws UnknownHostException
	 */
	public static InetAddress pickNonLoopbackLocalAddress() throws SocketException, UnknownHostException  {
		InetAddress a = getLocalAddress();
		if(!a.isLoopbackAddress()) return a;
		
		InetAddress[] all = getNonLoopbackLocalAddresses();
		if(all.length == 0) throw new SocketException("No address found!");
		
		return all[0];
	}
	
	/**
	 * Returns all non-loopback local addresses.
	 * @return InetAddress[]
	 * @throws SocketException
	 */
	public static InetAddress[] getNonLoopbackLocalAddresses() throws SocketException  {
		Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
		Set<InetAddress> s = new HashSet<InetAddress>();
		while(nis.hasMoreElements()) {
			NetworkInterface n = nis.nextElement();
			if(n.isLoopback()) continue;
			
			Enumeration<InetAddress> addresses = n.getInetAddresses();
			while(addresses.hasMoreElements()) {
				InetAddress addr = addresses.nextElement();
				if(addr.isLoopbackAddress()) continue;
				
				s.add(addr);
			}
		}
		return s.toArray(new InetAddress[s.size()]);
	}
	
	/**
	 * Returns all local addresses.
	 * @return InetAddress[]
	 * @throws SocketException
	 */
	public static InetAddress[] getAllLocalAddresses() throws SocketException  {
		Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
		Set<InetAddress> s = new HashSet<InetAddress>();
		while(nis.hasMoreElements()) {
			NetworkInterface n = nis.nextElement();
			Enumeration<InetAddress> addresses = n.getInetAddresses();
			while(addresses.hasMoreElements()) {
				s.add(addresses.nextElement());
			}
		}
		return s.toArray(new InetAddress[s.size()]);
	}
}

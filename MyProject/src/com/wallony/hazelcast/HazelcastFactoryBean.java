package com.wallony.hazelcast;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;

import com.hazelcast.config.Config;
import com.hazelcast.config.UrlXmlConfig;
import com.hazelcast.config.XmlConfigBuilder;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.wallony.network.utils.NetworkUtils;

public class HazelcastFactoryBean extends DevelopmentAwareFactoryBean implements InitializingBean, DisposableBean, 
	BeanNameAware {
	
	private static final Log log = LogFactory.getLog(HazelcastFactoryBean.class);
	
	private String name;
	private HazelcastInstance hazelcast;
	private Config config;
	private Resource configLocation;

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("Initializing " + name);
		System.setProperty("hazelcast.logging.type", "log4j");
		
		if(configLocation == null) {
			config = new XmlConfigBuilder().build();
		}
		else {
			config = new UrlXmlConfig(configLocation.getURL());
		}
//		
		if(developmentMode()) {
			config.getGroupConfig().setName(config.getGroupConfig().getName() + ".dev");
			String local = NetworkUtils.getLocalIP();
			List<String> m = new ArrayList<String>(1);
			m.add(local);
			config.getNetworkConfig().getJoin().getTcpIpConfig().setMembers(m);
		}
		hazelcast = Hazelcast.init(config);
	}

	@Override
	public Object getObject() throws Exception {
		return hazelcast;
	}

	@Override
	public Class getObjectType() {
		return HazelcastInstance.class;
	}
	
	@Override
	public void destroy() throws Exception {
		if(hazelcast != null) {
			hazelcast.shutdown();
			hazelcast = null;
		}
		else {
			log.warn("Instance is null!");
		}
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
	
	@Override
	public void setBeanName(String name) {
		this.name = name;
	}

	public Resource getConfigLocation() {
		return configLocation;
	}

	public void setConfigLocation(Resource config) {
		this.configLocation = config;
	}

}

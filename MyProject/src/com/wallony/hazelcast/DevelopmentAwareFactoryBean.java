package com.wallony.hazelcast;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.FactoryBean;

public abstract class DevelopmentAwareFactoryBean implements FactoryBean, BeanFactoryAware {

	protected BeanFactory factory;
	
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.factory = beanFactory; 
	}

	protected boolean developmentMode() {
//		AppConfig appConfig = (AppConfig) factory.getBean("AppConfig");
//		return appConfig.isDevModeOn();
		return false;
	}

}

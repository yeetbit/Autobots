package dev.obit.tools.watchdog.model;

import dev.obit.tools.watchdog.enums.Profile;
import javafx.util.Duration;

public class ServiceConfig {
	
	private Profile profile;
	private String serviceName;
	private String targetProduct;
	private int connectionDelay;
	private int timeOutPeriod;
	private float pricethreshold;
	
	private String userName;
	private String passWord;
	
	public ServiceConfig(Profile profile, String serviceName, String targetProduct, int connectionDelay,
			int timeOutInterval, float pricethreshold, String userName, String passWord) {
		super();
		this.profile = profile;
		this.serviceName = serviceName;
		this.targetProduct = targetProduct;
		this.connectionDelay = connectionDelay;
		this.timeOutPeriod = timeOutInterval;
		this.pricethreshold = pricethreshold;
		this.userName = userName;
		this.passWord = passWord;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getTargetProduct() {
		return targetProduct;
	}

	public void setTargetProduct(String targetProduct) {
		this.targetProduct = targetProduct;
	}

	public int getConnectionDelay() {
		return connectionDelay;
	}

	public void setConnectionDelay(int connectionDelay) {
		this.connectionDelay = connectionDelay;
	}

	public int getTimeOutInterval() {
		return timeOutPeriod;
	}

	public void setTimeOutInterval(int timeOutInterval) {
		this.timeOutPeriod = timeOutInterval;
	}

	public float getPricethreshold() {
		return pricethreshold;
	}

	public void setPricethreshold(float pricethreshold) {
		this.pricethreshold = pricethreshold;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
	

}

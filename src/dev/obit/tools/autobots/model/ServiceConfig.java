package dev.obit.tools.autobots.model;

public class ServiceConfig {
	
	private Profile profile;
	private String serviceName;
	private String targetProduct;
	private long connectionDelay;
	private int timeOutInterval;
	private float pricethreshold;
	
	private String userName;
	private String passWord;
	
	public ServiceConfig(Profile profile, String serviceName, String targetProduct, long connectionDelay,
			int timeOutInterval, float pricethreshold, String userName, String passWord) {
		super();
		this.profile = profile;
		this.serviceName = serviceName;
		this.targetProduct = targetProduct;
		this.connectionDelay = connectionDelay;
		this.timeOutInterval = timeOutInterval;
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

	public long getConnectionDelay() {
		return connectionDelay;
	}

	public void setConnectionDelay(long connectionDelay) {
		this.connectionDelay = connectionDelay;
	}

	public int getTimeOutInterval() {
		return timeOutInterval;
	}

	public void setTimeOutInterval(int timeOutInterval) {
		this.timeOutInterval = timeOutInterval;
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

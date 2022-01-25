package dev.obit.tools.autobots.model;

import dev.obit.tools.autobots.ServiceManager;
import dev.obit.tools.autobots.controller.services.RESTServiceClient;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

public abstract class Data extends TreeItem<String>  {
	private ServiceManager serviceManager;

	private String status;
	private String condition;
	private String latency;
	private String delay;
	private String other;
	protected RESTServiceClient restClient;
	
	public Data(ServiceConfig config, ServiceManager serviceManager) {
		super(config.getServiceName());
		this.serviceManager = serviceManager;
		restClient = new RESTServiceClient(config, this);
		dataExtraction(config);
		buildService();
		serviceManager.addService(this);
	}

	private void buildService(){
		this.getChildren().add(new TreeItem<String>(status));
		this.getChildren().add(new TreeItem<String>(condition));
		this.getChildren().add(new TreeItem<String>(latency));
		this.getChildren().add(new TreeItem<String>(delay));
		this.getChildren().add(new TreeItem<String>(other));	
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public void setLatency(String latency) {
		this.latency = latency;
	}

	public void setDelay(String delay) {
		this.delay = delay;
	}

	public void setOther(String other) {
		this.other = other;
	}
	
	public abstract void dataExtraction(ServiceConfig config);
	
	
	
	
	
	



}

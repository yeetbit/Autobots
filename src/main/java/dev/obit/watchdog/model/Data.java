package dev.obit.watchdog.model;

import org.jsoup.nodes.Document;

import dev.obit.watchdog.ServiceManager;
import dev.obit.watchdog.controller.services.RESTServiceClient;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Data {
	protected ServiceConfig config;
	@SuppressWarnings("unused")
	private ServiceManager serviceManager;
	protected RESTServiceClient restClient;

	// data
	private StringProperty serviceName = new SimpleStringProperty();
	private StringProperty condition = new SimpleStringProperty();
	private IntegerProperty status = new SimpleIntegerProperty();
	private LongProperty latency = new SimpleLongProperty();
	private IntegerProperty delay = new SimpleIntegerProperty();
	private StringProperty other = new SimpleStringProperty();

	@SuppressWarnings("unused")
	private Data() {
	};

	public Data(ServiceConfig config, ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
		this.config = config;
		this.serviceName = new SimpleStringProperty(config.getServiceName());
		this.condition = new SimpleStringProperty();
		this.status = new SimpleIntegerProperty();
		this.latency = new SimpleLongProperty();
		this.delay = new SimpleIntegerProperty(config.getConnectionDelay());
		this.other = new SimpleStringProperty();
		restClient = new RESTServiceClient(config, this);
		serviceManager.addService(this.serviceName.toString(), this);
	}

	public void setStatus(Integer status) {
		this.status.set(status);
	}

	public void setCondition(String condition) {
		this.condition.set(condition);
	}

	public void setLatency(Long latency) {
		this.latency.set(latency);
	}

	public void setDelay(Integer delay) {
		this.delay.set(delay);
	}

	public void setOther(String other) {
		this.other.set(other);
	}

	public StringProperty serviceNameProperty() {
		return serviceName;
	}

	public StringProperty conditionProperty() {
		return condition;
	}

	public IntegerProperty statusProperty() {
		return status;
	}

	public LongProperty latencyProperty() {
		return latency;
	}

	public IntegerProperty delayProperty() {
		return delay;
	}

	public StringProperty otherProperty() {
		return other;
	}

	public abstract void handleData(Document result);

}

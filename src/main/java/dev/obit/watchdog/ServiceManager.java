package dev.obit.watchdog;

import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

import dev.obit.watchdog.model.Data;

public class ServiceManager {

	private Logger logger = LoggerFactory.getLogger(ServiceManager.class);
	// changed to hashmap to remove redundant references to stored Data objects @
	// DataTargetFactory
	private ObservableMap<String, Data> services = FXCollections.observableHashMap();
	// private ObservableList<Data> services = FXCollections.observableArrayList();;

	public void addService(String serviceName, Data service) {
		services.put(serviceName, service);
		logger.debug("added service " + serviceName);
	}

	public ObservableMap<String, Data> getServices() {
		return services;
	}

	public Data getService(String serviceName) {
		return services.get(serviceName);
	}

	public ObservableList<Data> getObservableList() {
		ObservableList<Data> list = FXCollections.emptyObservableList();
		for (Entry<String, Data> entry : services.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}
}

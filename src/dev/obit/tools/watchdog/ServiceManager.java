package dev.obit.tools.watchdog;

import dev.obit.tools.watchdog.model.Data;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

public class ServiceManager {
	
	// changed to hashmap to remove redundant references to stored Data objects @ DataTargetFactory
	private ObservableMap<String, Data> services = FXCollections.observableHashMap();
//	private ObservableList<Data> services = FXCollections.observableArrayList();;

	public void addService(String serviceName, Data service) {
		services.put(serviceName, service);

	}

	public ObservableMap<String, Data> getServices() {
		return services;
	}

	public Data getService(String serviceName) {
		return services.get(serviceName);
	}

}

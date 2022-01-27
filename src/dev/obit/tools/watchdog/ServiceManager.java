package dev.obit.tools.watchdog;

import dev.obit.tools.watchdog.model.Data;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ServiceManager {
	
	private ObservableList<Data> services = FXCollections.observableArrayList();;
	
	
	public void addService(Data service) {
		services.add(service);
				
	}

	public ObservableList<Data> getServices() {
		// TODO Auto-generated method stub
		return null;
	}

}

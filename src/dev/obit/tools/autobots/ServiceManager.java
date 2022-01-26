package dev.obit.tools.autobots;

import dev.obit.tools.autobots.model.Data;
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

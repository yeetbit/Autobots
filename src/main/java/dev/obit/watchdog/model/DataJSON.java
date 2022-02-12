package dev.obit.watchdog.model;

import org.jsoup.nodes.Document;

import dev.obit.watchdog.ServiceManager;

public class DataJSON extends Data {

	public DataJSON(ServiceConfig config, ServiceManager serviceManager) {
		super(config, serviceManager);
	}

	@Override
	public void handleData(Document result) {
		// TODO Implement JSON dataExtraction
		
	}

	

}

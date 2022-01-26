package dev.obit.tools.autobots.model;

import org.jsoup.nodes.Document;

import dev.obit.tools.autobots.ServiceManager;

public class DataJSON extends Data {

	public DataJSON(ServiceConfig config, ServiceManager serviceManager) {
		super(config, serviceManager);
	}

	@Override
	public void handleData(Document result) {
		// TODO Implement JSON dataExtraction
		
	}

	

}

package dev.obit.tools.watchdog.model;

import org.jsoup.nodes.Document;

import dev.obit.tools.watchdog.ServiceManager;
import dev.obit.tools.watchdog.controller.services.RESTServiceClient;

public class DataXML extends Data{

	public DataXML(ServiceConfig config, ServiceManager serviceManager) {
		super(config, serviceManager);
	}
	
	/**
	 * @apiNote MUST use this for data handling and viewing
	 */
	@Override
	public void handleData(Document result) {
		// TODO: implement XML dataExtraction
		
	}

	
}

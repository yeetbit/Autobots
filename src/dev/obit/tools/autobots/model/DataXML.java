package dev.obit.tools.autobots.model;

import dev.obit.tools.autobots.ServiceManager;
import dev.obit.tools.autobots.controller.services.RESTServiceClient;

public class DataXML extends Data{

	public DataXML(ServiceConfig config, ServiceManager serviceManager) {
		super(config, serviceManager);
	}
	
	/**
	 * @apiNote MUST use this for data handling and viewing
	 */
	@Override
	public void dataExtraction(ServiceConfig config) {
		// TODO: implement XML dataExtraction
		
	}

	
}

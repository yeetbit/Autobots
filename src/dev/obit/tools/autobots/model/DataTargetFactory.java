package dev.obit.tools.autobots.model;

import java.util.HashMap;
import java.util.Map;

import dev.obit.tools.autobots.ServiceManager;
import dev.obit.tools.autobots.controller.services.RESTServiceClient;

public class DataTargetFactory {
	ServiceManager serviceManager;
	
	public DataTargetFactory(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}
	
	public void createNewService(ServiceConfig config) {
		Profile profile = config.getProfile();
		if(Profile.getDocType(profile).equalsIgnoreCase("HTML")) {
			setupHTMLService(config);
		}else if(Profile.getDocType(profile).equalsIgnoreCase("XML")) {
			setupXMLService(config);			
		}else if(Profile.getDocType(profile).equalsIgnoreCase("JSON")) {
			setupJSONService(config);
		}
	}
	
	private Map<String, Data> activeServices = new HashMap<>();

	private void setupJSONService(ServiceConfig config) {
		// TODO: Implement JSONService
		System.out.println("JSONService not implemented yet");
	}

	private void setupXMLService(ServiceConfig config) {
		// TODO: Implement XMLService
		System.out.println("XMLService not implemented yet");
	}

	private void setupHTMLService(ServiceConfig config) {
		activeServices.put(config.getServiceName(), new DataHTML(config, serviceManager));
		
	}

}

package dev.obit.tools.autobots.model;

import java.util.HashMap;
import java.util.Map;

import dev.obit.tools.autobots.ServiceManager;
import dev.obit.tools.autobots.enums.Profile;

/**
 * 
 * @author obi
 * <p>
 * DataTargetFactory launches a {@code Data}(collecting-service) accordingly to the given Profile.
 * {@code ServiceManager} is passed to the {@code Data}object. After creation of a {@code Data} instance,
 * it will be referenced to {@code ServiceManager.ObservableList<Data, String>} by calling {@code addService(Data service)} method.
 * </p>
 *	
 *	 
 *
 */

public class DataTargetFactory {
	ServiceManager serviceManager;
	
	public DataTargetFactory(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}
	
	public void createNewService(ServiceConfig config) {
		System.out.println("createNewService(), selected profile: "+config.getProfile());
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
		System.out.println("setting up HTMLService");
		activeServices.put(config.getServiceName(), new DataHTML(config, serviceManager));
		System.out.println("HTMLService "+config.getServiceName()+" with config profile "+config.getProfile()+" stored in ActiveServices");
		
	}

}

package dev.obit.watchdog.model;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.obit.watchdog.ServiceManager;
import dev.obit.watchdog.enums.Profile;

/**
 * 
 * @author obi
 *         <p>
 *         DataTargetFactory launches a {@code Data}(collecting-service)
 *         accordingly to the given Profile. {@code ServiceManager} is passed to
 *         the {@code Data}object. After creation of a {@code Data} instance, it
 *         will be referenced to
 *         {@code ServiceManager.ObservableList<Data, String>} by calling
 *         {@code addService(Data service)} method.
 *         </p>
 */

public class DataTargetFactory {
	ServiceManager serviceManager;
	private Logger logger = LoggerFactory.getLogger(DataTargetFactory.class);

	public DataTargetFactory(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	public void createNewService(ServiceConfig config) {
		logger.debug("createNewService(), selected profile: " + config.getProfile());
		Profile profile = config.getProfile();
		if (Profile.getDocType(profile).equalsIgnoreCase("HTML")) {
			setupHTMLService(config);
		} else if (Profile.getDocType(profile).equalsIgnoreCase("XML")) {
			setupXMLService(config);
		} else if (Profile.getDocType(profile).equalsIgnoreCase("JSON")) {
			setupJSONService(config);
		}
	}

	private Map<String, Data> activeServices = new HashMap<>();

	private void setupJSONService(ServiceConfig config) {
		// TODO: Implement JSONService
		logger.debug("JSONService not implemented yet");
	}

	private void setupXMLService(ServiceConfig config) {
		// TODO: Implement XMLService
		logger.debug("XMLService not implemented yet");
	}

	private void setupHTMLService(ServiceConfig config) {
		logger.debug("setting up HTMLService");
		serviceManager.addService(config.getServiceName(), new DataHTML(config, serviceManager));
		logger.debug("HTMLService " + config.getServiceName() + " with config profile " + config.getProfile()
				+ " stored in ActiveServices");

	}

}

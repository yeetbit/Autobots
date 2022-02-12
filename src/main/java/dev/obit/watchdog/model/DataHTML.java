package dev.obit.watchdog.model;

import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.obit.watchdog.ServiceManager;
import dev.obit.watchdog.enums.NetStatus;
import dev.obit.watchdog.enums.Profile;
import javafx.util.Duration;

public class DataHTML extends Data {

	private Logger logger = LoggerFactory.getLogger(DataHTML.class);

	public DataHTML(ServiceConfig config, ServiceManager serviceManager) {
		super(config, serviceManager);
		System.out.println("Done constructing HTML Service\n");
		runService();

	}

//	private void runService() {
//		restClient.fetchData();
//	}

	private void runService() {
		restClient.setPeriod(Duration.seconds(config.getConnectionDelay()));
		restClient.start();

		restClient.setOnSucceeded(event -> {
			// TODO: implement onSucceeded
			logger.debug("succeeded fetch job for service " + config.getServiceName());
		});
		restClient.setOnFailed(event -> {
			// TODO: implement onFailed
			logger.debug("failed fetch job for service " + config.getServiceName());
		});
		restClient.setOnCancelled(event -> {
			// TODO: implement onCancelled
			logger.debug("cancelled service " + config.getServiceName());
		});
	}

	public void stopService() {
		restClient.cancel();
		logger.info("stopping service " + config.getServiceName());
	}

	/**
	 * <p>
	 * handleData filters and selects the specific Element, by using the
	 * Profile.getScrapMap() LinkedHashMap. The Map contains all the configuration
	 * needed to scrape the data of the given domain.
	 * </p>
	 * 
	 * @param result result of the restClient
	 */

	@Override
	public void handleData(Document result) {
		// TODO: implement filtering based on given profile
		setCondition("-not implemented-");
		setOther("-not implemented-");

		logger.debug("Service result of: " + serviceNameProperty().get() + "\n\tURL: "
				+ Profile.getTargetDomain(config.getProfile()) + config.getTargetProduct() + "\n\tLatency: "
				+ latencyProperty().get() + "\n\tStatus: " + statusProperty().get() + " "
				+ NetStatus.getHttpStatus(statusProperty().get()) + "\n\tResponse: " + result.toString());

//		Element filter = result.getElementById("add-to-cart-form");
//		Elements target = filter.getElementsByAttributeValue("input type", "hidden");
//		System.out.println(target.toString()); 
//		Elements targetEnclosing = result.getElementsByClass("availability_widget");
//		Elements targetChildren = targetEnclosing.ch
//		targetEnclosing.forEach(el -> System.out.println(el));

	}

}

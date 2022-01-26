package dev.obit.tools.autobots.model;

import java.util.Timer;
import java.util.TimerTask;

import org.jsoup.nodes.Document;

import dev.obit.tools.autobots.ServiceManager;
import dev.obit.tools.autobots.controller.NetStatus;
import javafx.application.Platform;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class DataHTML extends Data {
	private Timer timer;

	public DataHTML(ServiceConfig config, ServiceManager serviceManager) {
		super(config, serviceManager);
		System.out.println("Done constructing HTML Service\n");
		runService();
		
	}
	
	private void runService() {
		System.out.println("starting service "+config.getServiceName());
		restClient.setPeriod(Duration.seconds(config.getConnectionDelay())  );
		restClient.start();
		restClient.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			@Override
			public void handle(WorkerStateEvent e) {
			}
			
		});
	}
	private void stopService() {
		
		
	}

	@Override
	public void handleData(Document result) {
		
	
	}

	

	
	
	
	

}

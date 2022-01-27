package dev.obit.tools.autobots.model;

import java.util.Timer;
import java.util.TimerTask;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import dev.obit.tools.autobots.ServiceManager;
import dev.obit.tools.autobots.enums.NetStatus;
import dev.obit.tools.autobots.enums.Profile;
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
		restClient.fetchData();
	}
	
	
//	private void runService() {
//		restClient.setPeriod(Duration.seconds(config.getConnectionDelay()));
//		System.out.println("starting service "+config.getServiceName());
//		restClient.start();
//		restClient.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//			@Override
//			public void handle(WorkerStateEvent e) {
//			}
//		});
//	}
	
	private void stopService() {
		restClient.cancel();
	}

	@Override
	public void handleData(Document result) {
		
		System.out.println("Service result of: "+serviceNameProperty().get()
				+"\n\tURL: "+Profile.getTargetDomain(config.getProfile())+config.getTargetProduct()
				+"\n\tLatency: "+latencyProperty().get()
				+"\n\tStatus: "+statusProperty().get()+" "+NetStatus.getHttpStatus(statusProperty().get()));
		
		
//		Element filter = result.getElementById("add-to-cart-form");
//		Elements target = filter.getElementsByAttributeValue("input type", "hidden");
//		System.out.println(target.toString()); 
//		Elements targetEnclosing = result.getElementsByClass("availability_widget");
//		Elements targetChildren = targetEnclosing.ch
//		targetEnclosing.forEach(el -> System.out.println(el));
		
		
	
	}

	

	
	
	
	

}

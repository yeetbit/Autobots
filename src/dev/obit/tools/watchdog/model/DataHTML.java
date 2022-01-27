package dev.obit.tools.watchdog.model;

import java.util.Timer;

import org.jsoup.nodes.Document;

import dev.obit.tools.watchdog.ServiceManager;
import dev.obit.tools.watchdog.enums.NetStatus;
import dev.obit.tools.watchdog.enums.Profile;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class DataHTML extends Data {

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
		System.out.println("starting service "+config.getServiceName());
		restClient.start();
                
		restClient.setOnSucceeded(event -> {
                    // TODO: implement onSucceeded 
                });
                restClient.setOnFailed(event -> {
                    // TODO: implement onFailed
                });
                restClient.setOnCancelled(event -> {
                    // TODO: implement onCancelled
                });
	}
	
	private void stopService() {
		restClient.cancel();
	}
        
        /**
         * <p>
         * handleData filters and selects the specific Element, by using the Profile.getScrapMap() LinkedHashMap.
         * The Map contains all the configuration needed to scrape the data of the given domain.
         * </p>
         * @param result result of the restClient
         */

	@Override
	public void handleData(Document result) {
            // TODO: implement filtering based on given profile
		setCondition("-not implemented-");
                setOther("-not implemented-");
                
            System.out.println("Service result of: "+serviceNameProperty().get()
                +"\n\tURL: "+Profile.getTargetDomain(config.getProfile())+config.getTargetProduct()
                +"\n\tLatency: "+latencyProperty().get()
                +"\n\tStatus: "+statusProperty().get()+" "+NetStatus.getHttpStatus(statusProperty().get())
                +"\n\tResponse: "+ result.toString());
                

		
//		Element filter = result.getElementById("add-to-cart-form");
//		Elements target = filter.getElementsByAttributeValue("input type", "hidden");
//		System.out.println(target.toString()); 
//		Elements targetEnclosing = result.getElementsByClass("availability_widget");
//		Elements targetChildren = targetEnclosing.ch
//		targetEnclosing.forEach(el -> System.out.println(el));
		
		
	
	}

	

	
	
	
	

}

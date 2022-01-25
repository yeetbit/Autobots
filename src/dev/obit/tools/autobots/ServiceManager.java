package dev.obit.tools.autobots;

import dev.obit.tools.autobots.model.Data;
import javafx.scene.control.TreeItem;

public class ServiceManager {
	
	private final TreeItem<String> root = new TreeItem<>("root");
	
	
	public TreeItem<String> getRoot(){
		return this.root;
	}
	
	public void addService(Data service) {
		this.root.getChildren().add(service);
		
		
	}

}

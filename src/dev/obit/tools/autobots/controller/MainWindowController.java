/*
 * Copyright (C) 2022 obi
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package dev.obit.tools.autobots.controller;

import dev.obit.tools.autobots.Environment;
import dev.obit.tools.autobots.ServiceManager;
import dev.obit.tools.autobots.controller.services.RESTServiceClient;
import dev.obit.tools.autobots.model.DataTargetFactory;
import dev.obit.tools.autobots.model.Profile;
import dev.obit.tools.autobots.model.ServiceConfig;
import dev.obit.tools.autobots.view.ViewFactory;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author obi
 */
public class MainWindowController extends BaseController implements Initializable  {

   
    @FXML
    private AnchorPane RootPane;

    @FXML
    private MenuItem aboutMenuButton;

    @FXML
    private MenuItem closeMenuButton;

    @FXML
    private MenuItem exitMenuButton;

    @FXML
    private MenuItem newJobMenuButton1;

    @FXML
    private TreeView<String> treeView;
    
    private ServiceManager serviceManager;
    private DataTargetFactory dataTargetFactory;
    
    public MainWindowController(ServiceManager serviceManager, ViewFactory viewFactory, DataTargetFactory dataTargetFactory, String FXMLName) {
    	super(serviceManager, viewFactory, dataTargetFactory, FXMLName);
    	this.serviceManager = serviceManager;
    	this.dataTargetFactory = dataTargetFactory;
    }
    private Stage stage;
    private boolean hasSystemExit = true;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	setupTreeView(serviceManager.getRoot());
    }    

        
    private void start(){
    	// Test config
    	dataTargetFactory.createNewService(new ServiceConfig(
    			Profile.NOTEBOOKBILLIGER, 	// target profile
    			"TestService",				// service name
    			"",							// target product (after domain)
    			1200L, 						// request interval
    			5000, 						// connection timout
    			0, 							// price threshold
    			"username", 				// account username
    			"password"));				// account password
    }
    
    @FXML
    void aboutButton(ActionEvent event) {
    	

    }

    @FXML
    void closeWindowAndExit(ActionEvent event) {
    	hasSystemExit = true;
    	viewFactory.closeStage(stageKey);
    	System.exit(0);

    }

    @FXML
    void closeWindowRunBackground(ActionEvent event) {
    	hasSystemExit = false;
    	viewFactory.closeStage(stageKey);

    }

    @FXML
    
    void newJob(ActionEvent event) {
//		viewFactory.showSetupWindow();
    	start();

    }
    

    @FXML
    void selectItemContext(ContextMenuEvent event) {

    }

    @FXML
    void selectItemFocus(MouseEvent event) {

    }
    
    private void setupTreeView(TreeItem<String> root) {
    	treeView.setRoot(root);
    	treeView.setShowRoot(false);
    	
    	
    }
    
    private void createNewService() {
    	
    }
    
}

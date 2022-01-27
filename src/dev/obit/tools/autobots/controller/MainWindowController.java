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
import dev.obit.tools.autobots.enums.Profile;
import dev.obit.tools.autobots.model.DataTargetFactory;
import dev.obit.tools.autobots.model.ServiceConfig;
import dev.obit.tools.autobots.view.ViewFactory;
import dev.obit.tools.autobots.model.Data;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private MenuItem aboutMenuButton;

    @FXML
    private MenuItem closewindow;

    @FXML
    private Menu edit;

    @FXML
    private MenuItem exitMenuButton;

    @FXML
    private MenuItem newJobMenuButton;
    
    @FXML
    private TableColumn<Data, String> serviceCol;
    
    @FXML
    private TableColumn<Data, String> conditionCol;
    
    @FXML
    private TableColumn<Data, Integer> statusCol;

    @FXML
    private TableColumn<Data, Long> latencyCol;
    
    @FXML
    private TableColumn<Data, Integer> delayCol;
    
    @FXML
    private TableColumn<Data, String> otherCol;

    @FXML
    private TableView<Data> tableView;
    
    private ServiceManager serviceManager;
    private DataTargetFactory dataTargetFactory;
    
    public MainWindowController(ServiceManager serviceManager, ViewFactory viewFactory, DataTargetFactory dataTargetFactory, String FXMLName) {
    	super(serviceManager, viewFactory, dataTargetFactory, FXMLName);
    	this.serviceManager = serviceManager;
    	this.dataTargetFactory = dataTargetFactory;
    }
    private Stage stage;
    private boolean hasSystemExit = true;
    private String nbbTestProdect = "nvidia+geforce+rtx+3080+founders+edition";
    private String alternateTestProduct = "ASUS/TUF-Gaming-GeForce-RTX-3080-V2-LHR-grafische-kaart/html/product/1773498";
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	serviceCol.setCellValueFactory(new PropertyValueFactory<Data, String>("serviceName"));
    	conditionCol.setCellValueFactory(new PropertyValueFactory<Data, String>("condition"));
    	statusCol.setCellValueFactory(new PropertyValueFactory<Data, Integer>("status"));
    	latencyCol.setCellValueFactory(new PropertyValueFactory<Data, Long>("latency"));
    	delayCol.setCellValueFactory(new PropertyValueFactory<Data, Integer>("delay"));
    	otherCol.setCellValueFactory(new PropertyValueFactory<Data, String>("other"));
    	tableView.setItems(serviceManager.getServices());
    	
    	
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
    	// Test config
    	dataTargetFactory.createNewService(new ServiceConfig(
    			Profile.JSONPLACEHOLDER,		 	// target profile
    			"TestService",				// service name
    			"",		// target product (after domain)
    			6, 							// request interval in seconds
    			4000, 						// connection timeout
    			0, 							// price threshold
    			"username", 				// account username
    			"password"));				// account password

    }
    

    @FXML
    void selectItemContext(ContextMenuEvent event) {

    }

    @FXML
    void selectItemFocus(MouseEvent event) {

    }
}    

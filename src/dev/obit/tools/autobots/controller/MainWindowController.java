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

import dev.obit.tools.autobots.controller.services.WatchDog;
import dev.obit.tools.autobots.view.ViewFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
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
    private TreeView<?> treeView;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public MainWindowController(ViewFactory viewFactory, String FXMLName) {
        super(viewFactory, FXMLName);
    }
    
    private void test(){
        
        WatchDog watchdog = new WatchDog();
        watchdog.setPeriod(Duration.seconds(5L));
        watchdog.start();
        watchdog.setOnSucceeded(event -> {
            WatchDogResult result = watchdog.getValue();
            
        });
    }
    
}

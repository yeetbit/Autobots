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
package dev.obit.tools.autobots.view;

import dev.obit.tools.autobots.Environment;
import dev.obit.tools.autobots.controller.BaseController;
import dev.obit.tools.autobots.controller.WatchdogSetupWindowController;
import dev.obit.tools.autobots.controller.MainWindowController;
import dev.obit.tools.autobots.controller.OSChooserController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author obi
 */
public class ViewFactory {
    
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[1m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    private Map<String, Stage> activeStages = new HashMap<>();
    private boolean mainWindowInitialized = false;

  
  
    
    public void showMainWindow(){
        BaseController controller = new MainWindowController(this, "MainWindow.fxml");
        initStage(controller,"MAINWINDOW", true);
        mainWindowInitialized = true;
    }

    public void showOSWindow() {
        BaseController controller = new OSChooserController(this, "OSChooser.fxml");
        initStage(controller,"OSWINDOW", true);
    	
    }
    
    public void showSetupWindow(){
    	if(!activeStages.containsKey("SETUPWINDOW")) {
    		BaseController controller = new WatchdogSetupWindowController(this, "EntryWindow.fxml");
    		initStage(controller,"SETUPWINDOW", false);
    	}else {
    		System.out.println("setup window is already open");
    	}
    }

    public boolean isMainWindowInitialized() {
        return mainWindowInitialized;
    }

      
    private void initStage(BaseController controller,String stageKey, Boolean hasSystemExit){
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource(controller.getFXMLName()));
        fxmlloader.setController(controller);
        
        try{
            Scene scene = new Scene(fxmlloader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            
        	stage.setTitle("Autobots on "+Environment.getEnvironment().toString().toLowerCase());
        	if(hasSystemExit){
        		stage.setOnCloseRequest((e) -> {
        			Platform.exit();
        			System.exit(0);
    			});
        	}
            controller.setStageKey(stageKey);
            activeStages.put(stageKey, stage);
        }catch(IOException ioe){
            System.out.println("Something went wrong during init: "+ANSI_GREEN+controller.getClass().toString()+ANSI_RESET);
            ioe.printStackTrace();
            return;
        }
    }
    
    public void closeStage(String stageKey){
        activeStages.get(stageKey).close();
        activeStages.remove(stageKey);
        System.out.println(stageKey+" succesfully closed");
    }
    
    public Stage getStage(String stageKey) {
    	return activeStages.get(stageKey);
    }
    
 

    
    
}


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

package dev.obit.tools.autobots;

import javafx.application.Application;
import javafx.stage.Stage;

import dev.obit.tools.autobots.view.ViewFactory;


/**
 *
 * @author obi
 */
public class Main extends Application {

    public static void main(String[] args) {
    	launch(args);
    }


	@Override
    public void start(Stage stage) throws Exception {
		ViewFactory viewFactory = new ViewFactory(new ServiceManager());
		
		Environment.setEnvironment(System.getProperty("os.name"));
		if(Environment.getEnvironment()!=null) {
			viewFactory.showMainWindow();
			
		}else {
			// TODO: Create ChoiseDialogue te pick the correct OS
			
		}
        
        
    }
    

}

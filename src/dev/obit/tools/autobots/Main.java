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
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


/**
 *
 * @author obi
 */
public class Main extends Application {

    static final Map<String, String> env = System.getenv();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        for(Map.Entry<String, String> el:env.entrySet()){
            System.out.println("Key: "+el.getKey()+"\tValue: "+el.getValue());
            
        }
  
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        
    }
    
}

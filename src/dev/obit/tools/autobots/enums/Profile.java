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
package dev.obit.tools.autobots.enums;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;;

/**
 *
 * @author obi
 */
public enum Profile {
    
    /**
     * UrlProfile's are PRE-configured API/Scrape profiles for different website's
     */
    JSONPLACEHOLDER, NOTEBOOKBILLIGER, AZERTY, ALTERNATE;
    
	public static String getDocType(Profile profile) {
		switch(profile){
		case NOTEBOOKBILLIGER : 
			return "HTML";
		default : return "HTML";
		} 
	}
	
    public static String getTargetDomain(Profile profile){
        
        switch(profile){
	        case JSONPLACEHOLDER :
	        	return "https://jsonplaceholder.typicode.com/";
            case NOTEBOOKBILLIGER : 
                return "https://www.notebooksbilliger.de/";
            case AZERTY :
            	return "";
            case ALTERNATE :
            	return "https://www.alternate.nl/";
            default : return "https://jsonplaceholder.typicode.com/";
        } 
    }
    
    public static Map<String, String> getScrapeMap(Profile profile) {
    	if(profile == JSONPLACEHOLDER) {
    		
    		LinkedHashMap<String, String> map = new LinkedHashMap<>();
    		map.put(null, null);
            return map;
            
    	}else if(profile == NOTEBOOKBILLIGER) {
    		
    		LinkedHashMap<String, String> map = new LinkedHashMap<>();
    		map.put(null, null);
    		return map;
    		
    	}else if(profile == AZERTY) {
    		
    		LinkedHashMap<String, String> map = new LinkedHashMap<>();
    		map.put(null, null);
    		return map;
    		
    	}else if(profile == ALTERNATE) {
    		
    		LinkedHashMap<String, String> map = new LinkedHashMap<>();
    		map.put(null, null);
    		return map;
    		
    	}else {
    		
    		LinkedHashMap<String, String> map = new LinkedHashMap<>();
    		map.put(null, null);
    		return map;
    	}
    } 
}
    


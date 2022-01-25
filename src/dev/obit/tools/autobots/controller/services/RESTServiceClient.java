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
package dev.obit.tools.autobots.controller.services;

import dev.obit.tools.autobots.controller.NetStatus;
import dev.obit.tools.autobots.model.Data;
import dev.obit.tools.autobots.model.Profile;
import dev.obit.tools.autobots.model.ServiceConfig;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;


/**
 *
 * @author obi
 */
public class RESTServiceClient extends ScheduledService<NetStatus>{

	private String Earl;
	private Profile profile;
	private String targetProduct;
	private long connectionDelay;
	private int timeOutInterval;
	Data data;
	
	public RESTServiceClient(ServiceConfig config, Data data) {
		this.profile = config.getProfile();
		this.Earl = Profile.getURL(this.profile);
		this.targetProduct = config.getTargetProduct();
		this.connectionDelay = config.getConnectionDelay();
		this.timeOutInterval = config.getTimeOutInterval();
		
		
	}
    
    
    
    @Override
    protected Task<NetStatus> createTask() {
        return new Task<NetStatus>() {
            protected NetStatus call() {

                return fetchData();
            }
        };
    }
    
  
    
    public NetStatus fetchData(){
    	
    	HttpURLConnection connection;
    	BufferedReader reader;
    	String line;
    	int status;
    	// StringBuffer responseContent = new StringBuffer();
    	StringBuilder responseContent = new StringBuilder();
    	try {
    		URL url = new URL(Earl);
    		connection =(HttpURLConnection) url.openConnection();

    		// setup connection
    		
    		connection.setRequestMethod("GET");
    		connection.setConnectTimeout(5000);
    		connection.setReadTimeout(5000);
    		status = connection.getResponseCode();
    		
    		if(status > 299) {
    			reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
    			reader.close();
    			return NetStatus.getHttpStatus(status);
    		}else {
    			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    			while((line = reader.readLine()) != null ) {
    				responseContent.append(line);
    			}
    			reader.close();
    			System.out.println(responseContent.toString());
    			return NetStatus.getHttpStatus(status);
    		}
    		
    	}catch(MalformedURLException urle) {
    		System.out.println(urle.getMessage());
    		return NetStatus.MALFORMED_URL;
    	}catch(SocketTimeoutException ste) {
    		System.out.println(ste.getMessage());
    		return NetStatus.TIMEOUT;
    	}catch(IOException ioe) {
    		System.out.println(ioe.getMessage());
    		return NetStatus.CONNECTION_ERROR;    
    	}
    }

   

 
    
}

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
package dev.obit.tools.controller.services;

import dev.obit.tools.model.Product;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

/**
 *
 * @author obi
 */
public class WatchDog extends Service{
    
    
    private ArrayList<Product> products;
    private Timer timer;
    
    private boolean noRobot;
    private int noRobotFactor;
    private long delay;
    private boolean cancel;
    private ScheduledFuture<?> taskHandle;
    
   
    public void activateWatchDog(Long delay){
        timer.schedule(newTimerTask(), delay);
    }
   
    public void cancelWatchDog(){
        timer.cancel();
    }
    
    private void setNoRobotFactor(int noRobotFactor) {
        
    }
    
    
    private TimerTask newTimerTask(){
        return new TimerTask(){
            @Override
            public void run(){
                Platform.runLater(()->{
                    if(noRobot){
                        try {
                            Thread.sleep(noRobotFactor);
                            setNoRobotFactor(noRobotFactor);
                        } catch (InterruptedException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                    /**
                     * 
                     * TODO: actual fetching of online content
                     * 
                     */
                });
            }
        };
    }
    
    public void init(){
        
        // specify interval (scheduled time - current time)        
        LocalDateTime current = LocalDateTime.now();    
        LocalDateTime schedule = current.plusSeconds(delay());
           
        // calculate duration
        Duration duration = Duration.between(current, schedule);
        long delay = Math.abs(duration.toMillis()); //or some other TimeUnit

        // reserve thread and schedule runnable task
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        taskHandle = executor.schedule(() -> {
            
             // run your code here

            if(cancel){
                init(); // reinitialize for next schedule
                
            }
        }, delay, TimeUnit.SECONDS);
    }
    
    private long delay(){
        if(noRobot){
            /**
             * implement noRobot factor to humanize the delay
             */
            return 0L;
        }else{
            return delay;
        }
        
    }

    @Override
    protected Task createTask(){
        
        
    }
    
}

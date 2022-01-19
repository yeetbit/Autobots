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

import dev.obit.tools.autobots.controller.WatchDogResult;
import dev.obit.tools.autobots.model.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledFuture;
import javafx.application.Platform;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.util.Duration;
import org.w3c.dom.Document;

/**
 *
 * @author obi
 */
public class WatchDog extends ScheduledService<WatchDogResult>{
    
    
    private ArrayList<Product> products;
    
    @Override
    protected Task<WatchDogResult> createTask() {
        return new Task<WatchDogResult>() {
            protected WatchDogResult call() {
                 
                return null;
            }
        };
    }

   

 
    
}

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
package dev.obit.tools.autobots.model;

/**
 *
 * @author obi
 */
public enum UrlProfile {
    
    /**
     * UrlProfile's are PRE-configured API/Scrape profiles for different website's
     */
    NOTEBOOKBILLIGER;
    
    public String getURL(UrlProfile url){
        
        switch(url){
            case NOTEBOOKBILLIGER : 
                return "https://www.notebooksbilliger.de/nvidia+geforce+rtx+3080+founders+edition";
            default : return "https://www.notebooksbilliger.de/nvidia+geforce+rtx+3080+founders+edition";
        } 
        
    }
    
    
}

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
package dev.obit.watchdog.controller;

import dev.obit.watchdog.ServiceManager;
import dev.obit.watchdog.model.DataTargetFactory;
import dev.obit.watchdog.view.ViewFactory;

/**
 *
 * @author obi
 */
public abstract class BaseController {
    
    protected ViewFactory viewFactory;
    protected DataTargetFactory dataTargetFactory;
    protected ServiceManager serviceManager;
    protected String FXMLName;
    protected String stageKey;

    public BaseController(ServiceManager serviceManager, ViewFactory viewFactory, DataTargetFactory dataTargetFactory, String FXMLName) {
        this.viewFactory = viewFactory;
        this.FXMLName = FXMLName;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    public String getFXMLName() {
        return FXMLName;
    }

	public String getStageKey() {
		return stageKey;
	}

	public void setStageKey(String stageKey) {
		this.stageKey = stageKey;
	}
    
    
    
    
}

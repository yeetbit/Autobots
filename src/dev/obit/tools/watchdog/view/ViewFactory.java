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
package dev.obit.tools.watchdog.view;

import dev.obit.tools.watchdog.Environment;
import dev.obit.tools.watchdog.ServiceManager;
import dev.obit.tools.watchdog.controller.BaseController;
import dev.obit.tools.watchdog.controller.SetupWindowController;
import dev.obit.tools.watchdog.model.DataTargetFactory;
import dev.obit.tools.watchdog.controller.MainWindowController;

import java.io.IOException;
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
	private static final String ANSI_GREEN = "\u001B[32m";

	private Map<String, Stage> activeStages = new HashMap<>();
	private boolean mainWindowInitialized = false;
	private ServiceManager serviceManager;
	private DataTargetFactory dataTargetFactory;

	public ViewFactory(ServiceManager serviceManager) {
		// TODO Auto-generated constructor stub
		this.serviceManager = serviceManager;
		this.dataTargetFactory = new DataTargetFactory(serviceManager);
	}

	public void showMainWindow() {
		BaseController controller = new MainWindowController(serviceManager, this, dataTargetFactory,
				"MainWindow.fxml");
		initStage(controller, "MAINWINDOW", true);
		mainWindowInitialized = true;
	}

	public void showSetupWindow() {
		if (!activeStages.containsKey("SETUPWINDOW")) {
			BaseController controller = new SetupWindowController(serviceManager, this, dataTargetFactory,
					"EntryWindow.fxml");
			initStage(controller, "SETUPWINDOW", false);
		} else {
			System.out.println("setup window is already open");
		}
	}

	public boolean isMainWindowInitialized() {
		return mainWindowInitialized;
	}

	private void initStage(BaseController controller, String stageKey, Boolean hasSystemExit) {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource(controller.getFXMLName()));
		fxmlloader.setController(controller);

		try {
			Scene scene = new Scene(fxmlloader.load());
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();

			stage.setTitle("Autobots on " + Environment.getEnvironment().toString().toLowerCase());
			if (hasSystemExit) {
				stage.setOnCloseRequest((e) -> {
					Platform.exit();
					System.exit(0);
				});
			}
			controller.setStageKey(stageKey);
			activeStages.put(stageKey, stage);
		} catch (IOException ioe) {
			System.out.println(
					"Something went wrong during init: " + ANSI_GREEN + controller.getClass().toString() + ANSI_RESET);
			ioe.printStackTrace();
			return;
		}
	}

	public void closeStage(String stageKey) {
		activeStages.get(stageKey).close();
		activeStages.remove(stageKey);
		System.out.println(stageKey + " succesfully closed");
	}

	public Stage getStage(String stageKey) {
		return activeStages.get(stageKey);
	}

}

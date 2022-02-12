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
import dev.obit.watchdog.enums.Profile;
import dev.obit.watchdog.model.DataTargetFactory;
import dev.obit.watchdog.model.ServiceConfig;
import dev.obit.watchdog.view.ViewFactory;
import dev.obit.watchdog.model.Data;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author obi
 */
public class MainWindowController extends BaseController implements Initializable {

	@FXML
	private MenuItem aboutMenuButton;

	@FXML
	private MenuItem closewindow;

	@FXML
	private Menu edit;

	@FXML
	private MenuItem exitMenuButton;

	@FXML
	private MenuItem newJobMenuButton;

	@FXML
	private TableColumn<Data, String> serviceCol;

	@FXML
	private TableColumn<Data, String> conditionCol;

	@FXML
	private TableColumn<Data, Integer> statusCol;

	@FXML
	private TableColumn<Data, Long> latencyCol;

	@FXML
	private TableColumn<Data, Integer> delayCol;

	@FXML
	private TableColumn<Data, String> otherCol;

	@FXML
	private TableView<Data> tableView;

	private ServiceManager serviceManager;
	private boolean hasSystemExit;

	public MainWindowController(ServiceManager serviceManager, ViewFactory viewFactory,
			DataTargetFactory dataTargetFactory, String FXMLName) {
		super(serviceManager, viewFactory, dataTargetFactory, FXMLName);
		this.serviceManager = serviceManager;
		this.dataTargetFactory = dataTargetFactory;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		hasSystemExit = true;
		serviceCol.setCellValueFactory(new PropertyValueFactory<>("serviceName"));
		conditionCol.setCellValueFactory(new PropertyValueFactory<>("condition"));
		statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
		latencyCol.setCellValueFactory(new PropertyValueFactory<>("latency"));
		delayCol.setCellValueFactory(new PropertyValueFactory<>("delay"));
		otherCol.setCellValueFactory(new PropertyValueFactory<>("other"));
		tableView.setItems(serviceManager.getObservableList());

	}

	void toggleSystemExit() {
		hasSystemExit = !hasSystemExit;
	}

	public boolean getHasSystemExit() {
		return hasSystemExit;
	}

	@FXML
	void aboutButton(ActionEvent event) {

	}

	@FXML
	void closeWindowAndExit(ActionEvent event) {
		hasSystemExit = true;
		viewFactory.closeStage(stageKey);
		System.exit(0);

	}

	@FXML
	void closeWindowRunBackground(ActionEvent event) {
		hasSystemExit = false;
		viewFactory.closeStage(stageKey);
	}

	@FXML
	void newJob(ActionEvent event) {
		viewFactory.showSetupWindow();
	}

	@FXML
	void selectItemContext(ContextMenuEvent event) {

	}

	@FXML
	void selectItemFocus(MouseEvent event) {

	}
}

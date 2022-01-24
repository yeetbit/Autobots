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
package dev.obit.tools.autobots.controller;

import dev.obit.tools.autobots.view.ViewFactory;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author obi
 */
public class WatchdogSetupWindowController extends BaseController implements Initializable{
	@FXML
	private AnchorPane rootPane;

    @FXML
    private TextField cardHolderField;

    @FXML
    private TextField countryField;

    @FXML
    private TextField creditcardNumberField;

    @FXML
    private TextField csvField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField housNumField;

    @FXML
    private ChoiceBox<?> knownAccountsChoiceBox;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField profileNameField;

    @FXML
    private ChoiceBox<?> shopApiChoiceBox;

    @FXML
    private TextField streetField;

    @FXML
    private TextField suiteField;

    @FXML
    private TextField userNameField;

    @FXML
    private TextField zipcodeField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	
    }    

    public WatchdogSetupWindowController(ViewFactory viewFactory, String FXMLName) {
        super(viewFactory, FXMLName);
    }
    
    
    
}

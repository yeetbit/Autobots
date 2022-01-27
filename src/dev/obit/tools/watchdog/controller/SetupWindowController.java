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
package dev.obit.tools.watchdog.controller;

import dev.obit.tools.watchdog.ServiceManager;
import dev.obit.tools.watchdog.enums.Profile;
import dev.obit.tools.watchdog.model.DataTargetFactory;
import dev.obit.tools.watchdog.model.ServiceConfig;
import dev.obit.tools.watchdog.view.ViewFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author obi
 */
public class SetupWindowController extends BaseController implements Initializable{

 @FXML
    private TextField countryField;

    @FXML
    private TextField countryField2;

    @FXML
    private TextField emailField;

    @FXML
    private TextField emailField2;

    @FXML
    private Label emailFieldErrorLabel;

    @FXML
    private TextField housNumField2;

    @FXML
    private TextField houseNumField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField lastNameField2;

    @FXML
    private TextField nameField;

    @FXML
    private TextField nameField2;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label phoneNumberErrorLabel;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField phoneNumberField2;

    @FXML
    private TextField serviceNameField;

    @FXML
    private Label streetErrorLabel;

    @FXML
    private TextField streetField;

    @FXML
    private TextField streetField2;

    @FXML
    private TextField suiteField;

    @FXML
    private TextField suiteField2;

    @FXML
    private ChoiceBox<Profile> targetDomainChoiceBox;

    @FXML
    private TextField targetProductField;

    @FXML
    private TextField userNameTextField;

    @FXML
    private TextField zipcodeField;

    @FXML
    private TextField zipcodeField2;

    @FXML
    private Spinner<Integer> delaySpinner;

    @FXML
    private Spinner<Float> priceThresholdSpinner;
    
    @FXML
    private Spinner<Integer> timeoutSpinner;

    private DataTargetFactory dataTargetFactory;
    private ServiceManager serviceManager;
    private ViewFactory viewfactory;

    public SetupWindowController(ServiceManager serviceManager, ViewFactory viewFactory, DataTargetFactory dataTargetFactory, String FXMLName) {
        super(serviceManager, viewFactory, dataTargetFactory, FXMLName);
        this.dataTargetFactory = dataTargetFactory;
        this.serviceManager = serviceManager;
        this.viewFactory = viewFactory;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupTimeoutSpinner();
        setupPriceThresholdSpinner();
        setupDelaySpinner();
        setuptargetDomainChoiceBox();
        targetProductField.setText("ASUS/TUF-Gaming-GeForce-RTX-3080-V2-LHR-grafische-kaart/html/product/1773498");
    	
    }    
    
        @FXML
    void cancelEntry(ActionEvent event) {

    }

    @FXML
    void saveEntry(ActionEvent event) {
        dataTargetFactory.createNewService(new ServiceConfig(
                targetDomainChoiceBox.getValue(),
                serviceNameField.getText(),
                targetProductField.getText(),
                delaySpinner.getValue(),
                timeoutSpinner.getValue(),
                0,
                userNameTextField.getText(),
                passwordField.getText()
        ));
        viewFactory.closeStage(stageKey);
    }

    private void setupTimeoutSpinner() {
        timeoutSpinner.setEditable(true);
        timeoutSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1000, 10000));
    }

    private void setupPriceThresholdSpinner() {
    }

    private void setupDelaySpinner() {
        delaySpinner.setEditable(true);
        delaySpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 600));
    }

    private void setuptargetDomainChoiceBox() {
        targetDomainChoiceBox.setItems(FXCollections.observableArrayList(Profile.values()));
        
    }
    
    
}

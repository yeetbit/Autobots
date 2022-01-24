package dev.obit.tools.autobots.controller;

import java.net.URL;
import java.util.ResourceBundle;

import dev.obit.tools.autobots.view.ViewFactory;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceDialog;
import dev.obit.tools.autobots.Environment;

public class OSChooserController extends BaseController implements Initializable {

	ChoiceDialog<Environment> osNotRec;
	public OSChooserController(ViewFactory viewFactory, String FXMLName) {
		super(viewFactory, FXMLName);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		osNotRec = new ChoiceDialog<Environment>(Environment.NULL, Environment.getAll());
		osNotRec.setHeaderText("Autobots could not recognize the underlying system");
		osNotRec.setTitle("Choose operating system");
		
	}

}

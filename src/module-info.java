module Autobots {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens dev.obit.tools.autobots to javafx.graphics, javafx.fxml;
}

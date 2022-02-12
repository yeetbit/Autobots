package dev.obit.watchdog;

import javafx.application.Application;
import javafx.stage.Stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.obit.watchdog.view.ViewFactory;

/**
 *
 * @author obi
 */
public class App extends Application {
	
	private Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		ViewFactory viewFactory = new ViewFactory(new ServiceManager());

		Environment.setEnvironment(System.getProperty("os.name"));
		if (Environment.getEnvironment() != null) {
			viewFactory.showMainWindow();

		} else {
			logger.info("environment not found");
			// TODO: Create ChoiseDialogue te pick the correct OS
			// for linking the correct libraries to the application

		}

	}

}
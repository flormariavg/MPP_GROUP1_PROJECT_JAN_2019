package ui;

import application.Main;
import javafx.fxml.FXML;

public class AddBookController {
	
	// Reference to the main application.
			private Main mainApp;
		/**
		 * Is called by the main application to give a reference back to itself.
		 *
		 * @param mainApp
		 */
		public void setMainApp(Main mainApp) {
			this.mainApp = mainApp;
		}
		
		/**
		 * Initializes the controller class. This method is automatically called
		 * after the fxml file has been loaded.
		 */
		@FXML
		private void initialize() {
			preJava8();
			

		}
		private void preJava8() {
			
		}

}

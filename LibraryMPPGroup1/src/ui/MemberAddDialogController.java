package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Address;
import model.Member;


public class MemberAddDialogController {
	@FXML
	private TextField memberIdField;
	@FXML
	private TextField firstNameField;
	@FXML
	private TextField lastNameField;
	@FXML
	private TextField streetField;
	@FXML
	private TextField postalCodeField;
	@FXML
	private TextField cityField;
	@FXML
	private TextField stateField;
	@FXML
	private TextField phoneNumberField;

	private Stage dialogStage;
	private Member person;
	private boolean okClicked = false;

	@FXML
	private void handleOk() {
		if (isInputValid()) {
			person.setId(memberIdField.getText());
			person.setFirstName(firstNameField.getText());
			person.setLastName(lastNameField.getText());
	        Address address= new Address(streetField.getText(), cityField.getText(),stateField.getText(),postalCodeField.getText());
			person.setAddress(address);
			person.setPhoneNumber(phoneNumberField.getText());
			okClicked = true;
			dialogStage.close();
		}
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}
	private boolean isInputValid() {
		String errorMessage = "";

		if (memberIdField.getText() == null || memberIdField.getText().length() == 0) {
			errorMessage += "No valid memvber ID!\n";
		}
		if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
			errorMessage += "No valid first name!\n";
		}
		if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
			errorMessage += "No valid last name!\n";
		}
		if (streetField.getText() == null || streetField.getText().length() == 0) {
			errorMessage += "No valid street!\n";
		}

		if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
			errorMessage += "No valid postal code!\n";
		}

		if (cityField.getText() == null || cityField.getText().length() == 0) {
			errorMessage += "No valid city!\n";
		}

		if (stateField.getText() == null || stateField.getText().length() == 0) {
			errorMessage += "No valid State!\n";
		}

		if (phoneNumberField.getText() == null || phoneNumberField.getText().length() == 0) {
			errorMessage += "No valid PhoneNumber!\n";
		}
		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}
	@FXML
	private void initialize() {
	}

	/**
	 * Sets the stage of this dialog.
	 *
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	/**
	 * Sets the person to be edited in the dialog.
	 *
	 * @param person
	 */
	public void setPerson(Member person) {
		this.person = person;
	}

	/**
	 * Returns true if the user clicked OK, false otherwise.
	 *
	 * @return
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

}


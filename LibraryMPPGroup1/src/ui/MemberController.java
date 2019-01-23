package ui;

import java.util.List;

import application.Main;
import business.MemberService;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;
import model.Book;
import model.Member;
import model.PersonGiveProfessor;

public class MemberController {

	@FXML
	private TableView<Member> memberTable;
	@FXML
	private TableColumn<Member, String> firstNameColumn;
	@FXML
	private TableColumn<Member, String> lastNameColumn;
	@FXML
	private Label MemberIdLabel;
	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label streetLabel;
	@FXML
	private Label postalCodeLabel;
	@FXML
	private Label cityLabel;
	@FXML
	private Label stateLabel;
	@FXML
	private Label phoneNumberLabel;

	private Main mainApp;

	private ObservableList<Member>  memberList = FXCollections.observableArrayList();

	public void addNewMember(Member member) {

		if (member != null)
			memberList.add(member);

	}

	public void handleCreateNewMember() {

		Member tempPerson = new Member();
		boolean okClicked = mainApp.showAddMemberDialog(tempPerson);
		if (okClicked) {


			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Add book");
			alert.setHeaderText("Add book");

			MemberService memberServ= new MemberService();
			if (memberServ.addNewMember(tempPerson)) {
				addNewMember(tempPerson);
				alert.setContentText("Add new member successfully!");

			} else {
				alert.setContentText("Member is added before!");
			}
			alert.showAndWait();
		}

	}
	@FXML
	private void initialize() {


		preJava8();
		// Clear person details.
		showMemberData(null);

		getMemberListFromDataBbase();

		// Listen for selection changes and show the person details when
		// changed.
		memberTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showMemberData(newValue));
		// Add observable list data to the table
		memberTable.setItems(memberList);

		if (memberList.size() > 0) {
			memberTable.getSelectionModel().selectFirst();
		}

	}

	public void setMainApp(Main main) {
		mainApp = main;

	}

	private void preJava8() {
		firstNameColumn.setCellValueFactory(new Callback<CellDataFeatures<Member, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<Member, String> param) {
				return param.getValue().firstNameProperty();
			}
		});

		lastNameColumn.setCellValueFactory(new Callback<CellDataFeatures<Member,String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<Member, String> param) {
				return param.getValue().lastNameProperty();
			}
		});
	}

	public void showMemberData(Member member) {
		if (member != null) {
			MemberIdLabel.setText(member.getMemberNumber());
			firstNameLabel.setText(member.getFirstName());
			lastNameLabel.setText(member.getLastName());
			streetLabel.setText(member.getAddress().getStreet());
			cityLabel.setText(member.getAddress().getCity());
			stateLabel.setText(member.getAddress().getState());
			postalCodeLabel.setText(member.getAddress().getPostalCode());
			phoneNumberLabel.setText(member.getPhoneNumber());
		} else {
			MemberIdLabel.setText("");
			firstNameLabel.setText("");
			lastNameLabel.setText("");
			streetLabel.setText("");
			cityLabel.setText("");
			stateLabel.setText("");
			postalCodeLabel.setText("");;
			phoneNumberLabel.setText("");
		}
	}


	public void getMemberListFromDataBbase() {
		MemberService memberService = new MemberService();
		List<Member> list = memberService.getMemberListFromDB();
		memberList.addAll(list);

	}


}

package ui;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import application.Main;
import business.OverdueData;
import business.OverdueService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import util.Util;

public class OverdueController {

	@FXML
	private TextField isbn;
	@FXML
	private TextField copyNumber;
	@FXML
	private Label lblBookAvailable;
	@FXML
	private Button btnAddCopy;
	@FXML
	private TableView<OverdueData> bookCopyTable;
	@FXML
	private TableColumn<OverdueData, String> isbnColumn;
	@FXML
	private TableColumn<OverdueData, String> bookTitleColumn;
	@FXML
	private TableColumn<OverdueData, String> copyNumberColumn;
	@FXML
	private TableColumn<OverdueData, String> memberColumn;
	@FXML
	private TableColumn<OverdueData, String> duedateColumn;
	
	OverdueService service;

	public OverdueController() {
		service = new OverdueService();
	}
	@FXML
	public void btnSearch(ActionEvent event) throws IOException {
		//Uncomment this for validate duedate
		//List<OverdueData> data = service.searchBookOverdue(isbn.getText());
		
		//Comment this for validate duedate
		List<OverdueData> dataAux = service.searchBookOverdue(isbn.getText());
		List<OverdueData> data = new ArrayList<>();
		for (OverdueData overdueData : dataAux) {
			if(overdueData.getDuedateDate().compareTo(LocalDate.now())>0)
				data.add(overdueData);
		}
		
		System.out.println(data);
		if(data!=null && !data.isEmpty()) {
		//	if(data.get)
			isbnColumn.setCellValueFactory(new PropertyValueFactory<OverdueData, String>("isbn"));
			bookTitleColumn.setCellValueFactory(new PropertyValueFactory<OverdueData, String>("bookTitle"));
			copyNumberColumn.setCellValueFactory(new PropertyValueFactory<OverdueData, String>("copyNumber"));
			memberColumn.setCellValueFactory(new PropertyValueFactory<OverdueData, String>("member"));
			duedateColumn.setCellValueFactory(new PropertyValueFactory<OverdueData, String>("duedate"));
			bookCopyTable.getItems().setAll(data);
		}
		else
			Util.showAlert(AlertType.INFORMATION, "INFO", "Copies not available", "There aren't copies for the book ");
	}

	private Main mainApp;

	public void setMainApp(Main main) {
		this.mainApp = main;
	}

}

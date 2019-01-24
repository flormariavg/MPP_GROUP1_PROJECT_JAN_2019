package application;

import java.io.IOException;

import dataaccess.LoginDAO;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Author;
import model.Member;
import model.PersonGiveProfessor;
import ui.AuthorController;
import ui.BookController;
import ui.BookCopyController;
import ui.ChechoutBookOverviewController;
import ui.LoginController;
import ui.MemberAddDialogController;
import ui.MemberController;
import ui.MenuController;
import ui.PersonEditDialogController;
import ui.PersonOverviewController;
import ui.RootLayoutController;
import util.StringUtil;

/**
 * You can find the code online.
 *
 * @author rXing
 *
 */
public class Main extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	private ObservableList<PersonGiveProfessor> personData = FXCollections.observableArrayList();

	public Main() {
		// Add some sample data
		personData.add(new PersonGiveProfessor("Hans", "Muster"));
		personData.add(new PersonGiveProfessor("Ruth", "Mueller"));
		personData.add(new PersonGiveProfessor("Heinz", "Kurz"));
		personData.add(new PersonGiveProfessor("Cornelia", "Meier"));
		personData.add(new PersonGiveProfessor("Werner", "Meyer"));
		personData.add(new PersonGiveProfessor("Lydia", "Kunz"));
		personData.add(new PersonGiveProfessor("Anna", "Best"));
		personData.add(new PersonGiveProfessor("Stefan", "Meier"));
		personData.add(new PersonGiveProfessor("Martin", "Mueller"));
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public ObservableList<PersonGiveProfessor> getPersonData() {
		return personData;
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("AddressApp");
		this.primaryStage.getIcons().add(new Image("file:resources/images/Address_Book.png"));

		initRootLayout();
		//showLoginScreen();
		showMenu();

	}

	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();

			// loader.setLocation(Main.class.getResource("../ui/Login.fxml"));
			// AnchorPane anchorPane = (AnchorPane)loader.load();

			loader.setLocation(Main.class.getResource("../ui/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			RootLayoutController controller = loader.getController();
			controller.setMainApp(this);
			// Show the scene containing the root layout.
			// Scene scene = new Scene(anchorPane);
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showPersonOverview() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../ui/PersonOverview.fxml"));
			AnchorPane personOverview = (AnchorPane) loader.load();

			// Set person overview into the center of root layout.
			rootLayout.setCenter(personOverview);

			PersonOverviewController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Opens a dialog to edit details for the specified person. If the user clicks
	 * OK, the changes are saved into the provided person object and true is
	 * returned.
	 *
	 * @param person the person object to be edited
	 * @return true if the user clicked OK, false otherwise.
	 */
	public boolean showPersonEditDialog(PersonGiveProfessor person) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../ui/PersonEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Person");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			PersonEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setPerson(person);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Huong - Add methods of Login Screen

	public static void main(String[] args) {
		createData();
		launch(args);
	}

	public static void createData() {

		LoginDAO.createLoginAccountData();
	}

	public void showLoginScreen() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../ui/Login.fxml"));
			AnchorPane loginScreen = (AnchorPane) loader.load();
			rootLayout.setCenter(loginScreen);
			primaryStage.setTitle(StringUtil.TITLE_LOGIN);
			// primaryStage.show();
			LoginController loginControl = loader.getController();
			loginControl.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showMenu() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../ui/Menu.fxml"));
			AnchorPane menu = (AnchorPane) loader.load();
			// Set person overview into the center of root layout.
			rootLayout.setCenter(menu);
			primaryStage.setTitle(StringUtil.TITLE_MENU);
			// primaryStage.show();
			MenuController menuController = loader.getController();
			menuController.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showCheckoutBook() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../ui/CheckoutBookOverview.fxml"));
			AnchorPane menu = (AnchorPane) loader.load();
			// Set person overview into the center of root layout.
			rootLayout.setCenter(menu);
			primaryStage.setTitle(StringUtil.TITLE_CHECKOUTBOOK);
			// primaryStage.show();
			ChechoutBookOverviewController chechoutBookOverviewController = loader.getController();
			chechoutBookOverviewController.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void showBookCopy() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../ui/BookCopy.fxml"));
			AnchorPane bookOverview = (AnchorPane) loader.load();
			// Set person overview into the center of root layout.
			rootLayout.setCenter(bookOverview);
			primaryStage.setTitle(StringUtil.TITLE_BOOK_COPY);
			// primaryStage.show();
			BookCopyController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showAddNewBook() {
		try {
			// Load person overview.
						FXMLLoader loader = new FXMLLoader();
						loader.setLocation(Main.class.getResource("../ui/BookOverview.fxml"));
						AnchorPane bookOverview = (AnchorPane) loader.load();
						// Set person overview into the center of root layout.
						rootLayout.setCenter(bookOverview);
						primaryStage.setTitle(StringUtil.TITLE_ADD_NEW_BOOK);
						//primaryStage.show();
						BookController controller = loader.getController();
						controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Opens a dialog to edit details for the specified person. If the user
	 * clicks OK, the changes are saved into the provided person object and true
	 * is returned.
	 *
	 * @param person
	 *            the person object to be edited
	 * @return true if the user clicked OK, false otherwise.
	 */
	public boolean showAuthorDialog(Author author) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../ui/AuthorDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle(StringUtil.TITLE_ADD_AUTHOR);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			AuthorController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setAuthor(author);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showAddMemberDialog(Member person) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../ui/MemberAddDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Add Member");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			MemberAddDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setPerson(person);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void showMemberOverview() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../ui/Member.fxml"));
			AnchorPane personOverview = (AnchorPane) loader.load();

			// Set person overview into the center of root layout.
			rootLayout.setCenter(personOverview);
			primaryStage.setTitle(StringUtil.TITLE_ADD_MEMBER);

			MemberController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

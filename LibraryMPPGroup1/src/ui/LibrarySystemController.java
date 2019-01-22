/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
 */
package ui;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class LibrarySystemController {

    @FXML //  fx:id="deleteIssue"
    private Button deleteIssue; // Value injected by FXMLLoader

    @FXML //  fx:id="messageBar"
    private Label messageBar; // Value injected by FXMLLoader

    @FXML //  fx:id="newIssue"
    private Button newIssue; // Value injected by FXMLLoader

    @FXML //  fx:id="saveIssue"
    private Button saveIssue; // Value injected by FXMLLoader

    @FXML //  fx:id="titleLine"
    private AnchorPane titleLine; // Value injected by FXMLLoader
    
    @FXML //  fx:id="titleLine"
    private AnchorPane contentPanel; // Value injected by FXMLLoader

    /**
     * Initializes the controller class.
     */
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        
    }

    /**
     * Called when the NewIssue button is fired.
     *
     * @param event the action event.
     */
    @FXML
    void newIssueFired(ActionEvent event) {
    	
    		try {
    			AnchorPane page = (AnchorPane) FXMLLoader.load(Main.class.getResource("Test.fxml"));
    			this.contentPanel.getChildren().clear();
				this.contentPanel.getChildren().add(page);
				System.out.println("Agregado el panel");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	
        
    }

    /**
     * Called when the DeleteIssue button is fired.
     *
     * @param event the action event.
     */
    @FXML
    void deleteIssueFired(ActionEvent event) {
       
    }

    /**
     * Called when the SaveIssue button is fired.
     *
     * @param event the action event.
     */
    @FXML
    void saveIssueFired(ActionEvent event) {
    		this.contentPanel.getChildren().clear();
    }
    
    FadeTransition messageTransition = null;

    public void displayMessage(String message) {
        
    }

}

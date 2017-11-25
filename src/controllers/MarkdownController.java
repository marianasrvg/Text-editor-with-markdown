package controllers;

import interfaces.WindowState;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MarkdownController{

	@FXML private AnchorPane anchorPane;
	@FXML private TextArea textArea;

	private KeyCombination ctrlE = new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN);


	@FXML public void keyPressed(KeyEvent event){
		if(ctrlE.match(event)){
			Stage stage = (Stage) anchorPane.getScene().getWindow();
			stage.close();
		}
	}
}

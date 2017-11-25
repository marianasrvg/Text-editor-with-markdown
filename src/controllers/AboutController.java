package controllers;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AboutController {

	@FXML private AnchorPane anchorPane;
	private KeyCombination ctrlE = new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN);


	@FXML public void onKeyPressed(KeyEvent event){
		if(ctrlE.match(event)){
			Stage stage = (Stage) anchorPane.getScene().getWindow();
			stage.close();
		}
	}
}

package controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import utils.Utils;

public class TextEditorController {
	@FXML TextArea body;
	@FXML MenuItem showPreview;
	
	@FXML public void onCreate(ActionEvent event) {
		System.out.println("djihejkrhr");
		Utils.createWindow(null, TextEditorController.this, "fxml/Preview.fxml", "Preview", null, null);
	}
	
}

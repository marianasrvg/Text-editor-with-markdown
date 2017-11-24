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
		sendToAutomaton();
		Utils.createWindow(null, TextEditorController.this, "fxml/Preview.fxml", "Preview", null, null);
	}

	private void sendToAutomaton() {
		String text = "";
		text = body.getText().replaceAll("\n", System.getProperty("line.separator"));
		//System.out.println(text);
		/*for(String line : text.split("\n")) {
			System.out.println("Line "+ line);
		}*/
	}
}

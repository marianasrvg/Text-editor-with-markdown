package controllers;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import utils.Utils;

public class TextEditorController {
	@FXML TextArea body;
	@FXML MenuItem showPreview;
	@FXML MenuItem saveItem;
	@FXML MenuItem closeItem;

	@FXML public void onCreate(ActionEvent event) {
		sendToAutomaton();
		Utils.createWindow(null, TextEditorController.this, "fxml/Preview.fxml", "Preview", null, null);
	}

	@FXML public void showMark(ActionEvent event){
		Utils.createWindow(null, TextEditorController.this, "fxml/Markdown.fxml", "Markdown Use Example", null, null);
	}
	@FXML public void save(ActionEvent event){
		System.out.println("shortcut");
	}

	@FXML public void close(ActionEvent event){
		System.out.println("shortcut");
		Platform.exit();
		System.exit(0);
	}

	@FXML public void showAbout(ActionEvent event){
		Utils.createWindow(null, TextEditorController.this, "fxml/About.fxml", "About", null, null);
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

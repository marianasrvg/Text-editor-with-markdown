package controllers;


import java.util.ArrayList;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import utils.Utils;

public class TextEditorController {
	@FXML TextArea body;
	@FXML MenuItem showPreview;
	@FXML MenuItem saveItem;
	@FXML MenuItem closeItem;

	@FXML public void onCreate(ActionEvent event) {
		sendToAutomaton();
		ArrayList<Text> content = new ArrayList<>();
		Text t1 = new Text("Hola ");
		Text t2 = new Text("Carmen");
		t2.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
		content.add(t1);
		content.add(t2);
		Utils.createWindow(null, TextEditorController.this, "fxml/Preview.fxml", "Preview", null, null, content);
	}

	@FXML public void showMark(ActionEvent event){
		Utils.createWindow(null, TextEditorController.this, "fxml/Markdown.fxml", "Markdown Use Example", null, null, null);
	}
	@FXML public void save(ActionEvent event){
		System.out.println("shortcut");
	}

	@FXML public void close(ActionEvent event){
		Platform.exit();
		System.exit(0);
	}

	@FXML public void showAbout(ActionEvent event){
		Utils.createWindow(null, TextEditorController.this, "fxml/About.fxml", "About", null, null, null);
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

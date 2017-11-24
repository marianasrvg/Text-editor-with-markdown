package controllers;

import backend.*;
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
	private 	ArrayList<Text> content = new ArrayList<>();


	@FXML public void onCreate(ActionEvent event) {
		sendToAutomaton();
		Utils.createWindow(null, TextEditorController.this, "fxml/Preview.fxml", "Preview", null, "css/Markdown.css", content);
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
		AFD mainmarkdown = new AFD('a');
		MarkdownAFD.mainAFD(mainmarkdown);
		content.clear();
		for(String line : text.split("\n")) {
			String result = mainmarkdown.process(line);
			Text output[] = Markdown.processMarkdown(result);
			for(int i = 0; i < output.length; i++){
				System.out.println("id: " + output[i].getId());
				content.add(output[i]);
			}

		}
	}
}

package controllers;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import utils.Utils;

public class TextEditorController {
	@FXML TextArea body;
	@FXML MenuItem showPreview;
	@FXML MenuItem saveItem;
	@FXML MenuItem closeItem;
	@FXML AnchorPane anchorPane;

	@FXML public void onCreate(ActionEvent event) {
		sendToAutomaton();
		ArrayList<Text> content = new ArrayList<>();
		Text t1 = new Text("Hola");
		Text t2 = new Text("Carmen");
		Text t3 = new Text("uwu");
		//t2.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		content.add(t1);
		content.add(t2);
		content.add(t3);
		Utils.createWindow(null, TextEditorController.this, "fxml/Preview.fxml", "Preview", null, null, content);
	}

	@FXML public void showMark(ActionEvent event){
		Utils.createWindow(null, TextEditorController.this, "fxml/Markdown.fxml", "Markdown Use Example", null, null, null);
	}
	@FXML public void save(ActionEvent event){

		FileChooser fileChooser = new FileChooser();

		fileChooser.setTitle("Save Markdown");

		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("MD files (*.md)", "*.md");
        fileChooser.getExtensionFilters().add(extFilter);

        File file1 = fileChooser.showSaveDialog(new Stage());

        saveFile(body.getText().replaceAll("\n", System.getProperty("line.separator")), file1);

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

	private void saveFile(String content, File file){
		try {
            FileWriter fileWriter = null;

            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            //ogger.getLogger(JavaFX_Text.class.getName()).log(Level.SEVERE, null, ex);
        	ex.printStackTrace();
        }
	}
}

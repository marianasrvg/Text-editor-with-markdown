package controllers;


import java.util.ArrayList;

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

	@FXML public void onCreate(ActionEvent event) {
		ArrayList<Text> arrayText = sendToAutomaton();
		Utils.createWindow(null, TextEditorController.this, "fxml/Preview.fxml", "Preview", null, null, arrayText);
	}

	private ArrayList<Text> sendToAutomaton() {
		String automaton = "";
		String text = "";
		String[] results;
		ArrayList<Text> arrayText = new ArrayList<>();
		text = body.getText().replaceAll("\n", System.getProperty("line.separator"));

		//System.out.println(text);
		for(String line : text.split("\n")) {
			automaton = processLine(line);
			results = automaton.split("|");
			//0 -> Word
			//1 -> indexs
			//2 -> Type
			String[] index = results[1].split(",");
			int begin = Integer.parseInt(index[0]);
			int end = Integer.parseInt(index[1]);
			Text sBegin = null;
			Text sEnd = null;
			Text css = new Text(results[0].substring(begin,end));
			if(begin > 0){
				 sBegin = new Text(results[0].substring(0, begin-1));

			}
			if(end < results[0].length()){
				 sEnd = new Text(results[0].substring(end+1, results[0].length()));
			}

			css.setFont(Font.font("Verdana", FontWeight.BOLD, end));
			
			arrayText.add(sBegin);
			arrayText.add(css);
			arrayText.add(sEnd);

		}
		return arrayText;
	}

	public String processLine(String line){

		return "Hola Carmen|5,10|Bold";
	}
}

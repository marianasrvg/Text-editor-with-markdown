package controllers;

import java.util.ArrayList;

import interfaces.WindowState;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class PreviewController implements WindowState {

	private ArrayList<Text> content;
	@FXML private TextFlow textFlow;
	@FXML private AnchorPane anchorPane;

	@SuppressWarnings("unchecked")
	@Override
	public void onReady() {
		// TODO Auto-generated method stub
		content = (ArrayList<Text>) anchorPane.getScene().getWindow().getUserData();
		System.out.println(content.get(1).getText());
		for(int i = 0; i < content.size(); i += 3){
			textFlow.getChildren().addAll(content.get(i), content.get(i+1), content.get(i+2));
		}
	}

}

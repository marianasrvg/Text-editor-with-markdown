package controllers;

import java.util.ArrayList;

import interfaces.WindowState;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class PreviewController implements WindowState {

	private ArrayList<Text> content;
	@FXML private TextFlow textFlow;
	@FXML private AnchorPane anchorPane;
	@FXML private MenuItem closeItem;

	@SuppressWarnings("unchecked")
	@Override
	public void onReady() {
		textFlow.getChildren().clear();
		content = (ArrayList<Text>) anchorPane.getScene().getWindow().getUserData();
		for(int i = 0; i < content.size(); i += 3){
			if(!content.get(i).getText().isEmpty()){
				textFlow.getChildren().add(content.get(i));
			}
			if(!content.get(i+1).getText().isEmpty()){
				textFlow.getChildren().add(content.get(i+1));
			}
			if(!content.get(i+2).getText().isEmpty()){
				textFlow.getChildren().add(content.get(i+2));
			}
			textFlow.getChildren().add(new Text("\n"));
		}
	}

	@FXML public void close(ActionEvent event){
		Stage stage = (Stage) anchorPane.getScene().getWindow();
		stage.close();
	}

}

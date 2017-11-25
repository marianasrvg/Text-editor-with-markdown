package controllers;

import java.util.ArrayList;

import interfaces.WindowState;
import javafx.fxml.FXML;
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
		textFlow.getChildren().clear();
		// TODO Auto-generated method stub
		content = (ArrayList<Text>) anchorPane.getScene().getWindow().getUserData();
		//System.out.println(content.get(1).getText());
		for(int i = 0; i < content.size(); i += 3){
			//textFlow.getChildren().addAll(content.get(i) != null ? content.get(i) : new Text(""), content.get(i+1) != null ? content.get(i+1) : new Text(""), content.get(i+2) != null ? content.get(i+2) : new Text(""));
			//System.out.println(content.get(i).toString());
			if(!content.get(i).getText().isEmpty()){
				textFlow.getChildren().add(content.get(i));
			}
			//System.out.println(content.get(i+1).toString());
			if(!content.get(i+1).getText().isEmpty()){
				textFlow.getChildren().add(content.get(i+1));
			}
			//System.out.println(content.get(i+2).toString());
			if(!content.get(i+2).getText().isEmpty()){
				textFlow.getChildren().add(content.get(i+2));
			}
			textFlow.getChildren().add(new Text("\n"));
		}
	}

}

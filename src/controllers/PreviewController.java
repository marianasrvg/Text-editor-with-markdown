package controllers;

import java.util.ArrayList;

import interfaces.WindowState;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class PreviewController implements WindowState {

	private ArrayList<Text> content;
	@FXML private AnchorPane anchorPane;
	@FXML private TextArea previewTextArea;

	@SuppressWarnings("unchecked")
	@Override
	public void onReady() {
		// TODO Auto-generated method stub
		content = (ArrayList<Text>) anchorPane.getScene().getWindow().getUserData();
		System.out.println(content.get(1).getText());

	}

}

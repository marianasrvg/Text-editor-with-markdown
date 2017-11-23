package utils;

import java.net.URL;

import interfaces.WindowState;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Utils {

	public static void createWindow(Stage stage, Object parent, String fxmlLocation, String sceneTitle, Object userData, String cssLocation) {
        try {
        	URL fxmlUrl = parent.getClass().getClassLoader().getResource(fxmlLocation);
        	FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
        	Pane root = (Pane) fxmlLoader.load();
            Stage targetStage = (stage != null) ? stage : new Stage();
            targetStage.setTitle(sceneTitle);
            Scene scene =  new Scene(root);

            if (cssLocation != null) {
            		scene.getStylesheets().add(parent.getClass().getClassLoader().getResource(cssLocation).toExternalForm());
            }
        
            if (stage == null) {
	            	targetStage.initModality(Modality.APPLICATION_MODAL);
	            	targetStage.setUserData(userData);
	            	targetStage.addEventHandler(WindowEvent.WINDOW_SHOWN, new EventHandler<WindowEvent>() {
	
						@Override
						public void handle(WindowEvent event) {
							if (fxmlLoader.getController() instanceof WindowState) {
								((WindowState) fxmlLoader.getController()).onReady();
							}
						}
	
	            	});
            }
            targetStage.setScene(scene);
            targetStage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}


	public static void closeWindow(ActionEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();
	}

	public static void showError(String message) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText(message);
		alert.show();
	}


}


import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import utils.Utils;



public class Main extends Application{
	
	public static void main(String[] args){
		launch(args); //to start the application
	}
	
	public void stop() throws Exception {
	    Platform.exit();
	    System.exit(0);
	}
	
	public void start(Stage primaryStage) throws Exception{
		Utils.createWindow(primaryStage, Main.this, "fxml/TextEditor.fxml", "Markdown text editor", null, null, null);
	}

}
	



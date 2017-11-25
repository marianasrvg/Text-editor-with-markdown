import javafx.scene.text.Text;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import utils.Utils;



public class Main extends Application{
	
	public static void main(String[] args){
		launch(args); //to start the application
		/*
		//Create the AFD with default transition with 'a'
		AFD mainmarkdown = new AFD('a');
		//Add transitions
		mainAFD(mainmarkdown);
		//Array list with all the text to show
		ArrayList<Text> text = new ArrayList<Text>();
		

				//and show their options
				String input = mainmarkdown.process(string);
				System.out.println(input);
				Text output[] = Markdown.processMarkdown(input);
				for(int i = 0; i < output.length; i++){
					//System.out.println(output[i].toString());
					text.add(output[i]);
				}
		*/
				
	}
	public void stop() throws Exception {
	    Platform.exit();
	    System.exit(0);
	    //System.out.println("logout");
	}
	public void start(Stage primaryStage) throws Exception{
		Utils.createWindow(primaryStage, Main.this, "fxml/TextEditor.fxml", "Markdown text editor", null, null, null);
	}

	/*@Override
	public void handle(ActionEvent event){ //for every event
		if(event.getSource() == button){
			System.out.println("type #HEADER1");
		}
	}*/
}
	



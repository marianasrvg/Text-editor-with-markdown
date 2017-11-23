import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
	//implements EventHandler<ActionEvent>
	Button button;
	
	private static void mainAFD(AFD markdown){
		markdown.createAFD(22, 6);
		char[] symbols = {'a','#','*','1','.','`'};
		markdown.setSymbols(symbols);
		State auxiliar_state;
		for(int i = 0; i < 9;i++){
			auxiliar_state = new State(Integer.toString(i), false, false, i);
			markdown.addState(auxiliar_state);
		}
		
		markdown.states[0].initial_state = true;
		markdown.states[8].final_state = true;
		
		markdown.states[0].addTransition('a', 0);
		markdown.states[0].addTransition('#', 1);
		markdown.states[0].setCSSName("No header");
		
		markdown.states[1].addTransition('a', 7);
		markdown.states[1].addTransition('#', 2);
		markdown.states[1].setCSSName("H1");
		
		markdown.states[2].addTransition('a', 7);
		markdown.states[2].addTransition('#', 3);
		markdown.states[2].setCSSName("H2");
		
		markdown.states[3].addTransition('a', 7);
		markdown.states[3].addTransition('#', 4);
		markdown.states[3].setCSSName("H3");
		
		markdown.states[4].addTransition('a', 7);
		markdown.states[4].addTransition('#', 5);
		markdown.states[4].setCSSName("H4");
		
		markdown.states[5].addTransition('a', 7);
		markdown.states[5].addTransition('#', 6);
		markdown.states[5].setCSSName("H5");
		
		markdown.states[6].addTransition('a', 7);
		markdown.states[6].addTransition('#', 7);
		markdown.states[6].setCSSName("H6");
		
		markdown.states[7].addTransition('\n', 8);
		markdown.states[7].addTransition('a', 7);
	}
	
	private static void headerAFD(AFD markdown){
		markdown.createAFD(9, 3);
		char[] symbols = {'a','#','\n'};
		markdown.setSymbols(symbols);
		State auxiliar_state;
		for(int i = 0; i < 9;i++){
			auxiliar_state = new State(Integer.toString(i), false, false, i);
			markdown.addState(auxiliar_state);
		}
		
		markdown.states[0].initial_state = true;
		markdown.states[8].final_state = true;
		
		markdown.states[0].addTransition('a', 0);
		markdown.states[0].addTransition('#', 1);
		markdown.states[0].setCSSName("No header");
		
		markdown.states[1].addTransition('a', 7);
		markdown.states[1].addTransition('#', 2);
		markdown.states[1].setCSSName("H1");
		
		markdown.states[2].addTransition('a', 7);
		markdown.states[2].addTransition('#', 3);
		markdown.states[2].setCSSName("H2");
		
		markdown.states[3].addTransition('a', 7);
		markdown.states[3].addTransition('#', 4);
		markdown.states[3].setCSSName("H3");
		
		markdown.states[4].addTransition('a', 7);
		markdown.states[4].addTransition('#', 5);
		markdown.states[4].setCSSName("H4");
		
		markdown.states[5].addTransition('a', 7);
		markdown.states[5].addTransition('#', 6);
		markdown.states[5].setCSSName("H5");
		
		markdown.states[6].addTransition('a', 7);
		markdown.states[6].addTransition('#', 7);
		markdown.states[6].setCSSName("H6");
		
		markdown.states[7].addTransition('\n', 8);
		markdown.states[7].addTransition('a', 7);
	}
	private static void boldAFD(AFD markdown){
		markdown.createAFD(8, 3);
		char[] symbols = {'a','*','\n'};
		markdown.setSymbols(symbols);
		State auxiliar_state;
		for(int i = 0; i < 8;i++){
			auxiliar_state = new State(Integer.toString(i), false, false, i);
			markdown.addState(auxiliar_state);
		}
		
		markdown.states[0].initial_state = true;
		markdown.states[5].final_state = true;
		markdown.states[6].final_state = true;
		markdown.states[7].final_state = true;
		
		markdown.states[0].addTransition('a', 0);
		markdown.states[0].addTransition('*', 1);
		markdown.states[0].setCSSName("No bold/italic");
		
		markdown.states[1].addTransition('a', 3);
		markdown.states[1].addTransition('*', 2);
		markdown.states[1].setCSSName("No bold/italic");
		
		markdown.states[2].addTransition('a', 4);
		markdown.states[2].setCSSName("No bold/italic");
		
		markdown.states[3].addTransition('a', 3);
		markdown.states[3].addTransition('*', 5);
		markdown.states[3].setCSSName("No bold/italic");
		
		markdown.states[4].addTransition('a', 4);
		markdown.states[4].addTransition('*', 5);
		markdown.states[4].setCSSName("No bold/italic");
		
		markdown.states[5].addTransition('a', 7);
		markdown.states[5].addTransition('*', 6);
		markdown.states[5].setCSSName("Italic");
		
		markdown.states[6].addTransition('a', 7);
		markdown.states[6].setCSSName("Bold");
		
		markdown.states[7].addTransition('a', 7);
	}
	private static void bulletAFD(AFD markdown){
		markdown.createAFD(6, 5);
		char[] symbols = {'*','#','-','a','.'};
		markdown.setSymbols(symbols);
		State auxiliar_state;
		for(int i = 0; i < 6;i++){
			auxiliar_state = new State(Integer.toString(i), false, false, i);
			markdown.addState(auxiliar_state); 
		}
		
		markdown.states[0].initial_state = true;
		markdown.states[1].final_state = true;
		markdown.states[3].final_state = true;
		markdown.states[4].final_state = true;
		markdown.states[5].final_state = true;
		
		markdown.states[0].addTransition('a', 5);
		markdown.states[0].addTransition('*', 1);
		markdown.states[0].addTransition('-', 4);
		markdown.states[0].addTransition('#', 2);
		markdown.states[0].setCSSName("No bullet");
		
		markdown.states[1].addTransition('a', 1);
		markdown.states[1].setCSSName("Bullet");
		
		markdown.states[2].addTransition('.', 3);
		markdown.states[2].addTransition('a', 5);
		markdown.states[2].setCSSName("No bullet");
		
		markdown.states[3].addTransition('a', 3);
		markdown.states[3].setCSSName("Numeration");
		
		markdown.states[4].addTransition('a', 4);
		markdown.states[4].setCSSName("Guión");
				
		markdown.states[5].addTransition('a', 5);
		markdown.states[5].setCSSName("No bullet");		
	}
	
	public static void createAFDMarkdown(AFD headermarkdown, AFD boldmarkdown, AFD bulletmarkdown){
		headerAFD(headermarkdown);
		boldAFD(boldmarkdown);
		bulletAFD(bulletmarkdown);
	}

	public static void main(String[] args){
		AFD headermarkdown = new AFD('a');
		AFD boldmarkdown = new AFD('a');
		AFD bulletmarkdown = new AFD('a');
		createAFDMarkdown(headermarkdown, boldmarkdown, bulletmarkdown);
		

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String string;
		while(true){
			try {
				string = reader.readLine(); 
				System.out.println(headermarkdown.getCSS(string));
				System.out.println(boldmarkdown.getCSS(string));
				System.out.println(bulletmarkdown.getCSS(string));
				//System.out.println(bulletmarkdown.getCurrentState(string));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//launch(args); //to start the application
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setTitle("Markdown text editor");
		button = new Button();
		button.setText("Markdown tips!");
		//button.setOnAction(this);
		/*button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				System.out.println("type #HEADER1");
			}
		});*/
		
		button.setOnAction(e->System.out.println("type #HEADER1"));
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		
		Scene scene = new Scene(layout, 300, 250);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/*@Override
	public void handle(ActionEvent event){ //for every event
		if(event.getSource() == button){ 
			System.out.println("type #HEADER1");
		}
	}*/
}

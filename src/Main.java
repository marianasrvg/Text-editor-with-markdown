import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{
	
	private static void mainAFD(AFD markdown){
		markdown.createAFD(23, 7);
		char[] symbols = {'a','#','*','/','+','1','.'};
		markdown.setSymbols(symbols);
		State auxiliar_state;
		for(int i = 0; i < 23;i++){
			auxiliar_state = new State(Integer.toString(i), false, false, i);
			markdown.addState(auxiliar_state);
		}
		
		markdown.states[0].initial_state = true;
		
		markdown.states[1].final_state = true;
		markdown.states[2].final_state = true;
		markdown.states[3].final_state = true;
		markdown.states[4].final_state = true;
		markdown.states[5].final_state = true;
		markdown.states[6].final_state = true;
		markdown.states[7].final_state = true;
		markdown.states[11].final_state = true;
		markdown.states[12].final_state = true;
		markdown.states[15].final_state = true;
		markdown.states[16].final_state = true;
		markdown.states[18].final_state = true;
		
		markdown.states[0].addTransition('#', 1);
		markdown.states[0].addTransition('a', 8);
		markdown.states[0].addTransition('+', 17);
		markdown.states[0].addTransition('1', 19);
		markdown.states[0].addTransition('*', 9);
		markdown.states[0].addTransition('/', 13);
		markdown.states[0].check_num = true;
		
		//HEADERS
		markdown.states[1].addTransition('a', 7);
		markdown.states[1].addTransition('#', 2);
		markdown.states[1].setCSSName("H1");
		markdown.states[1].signed = true;
		
		markdown.states[2].addTransition('a', 7);
		markdown.states[2].addTransition('#', 3);
		markdown.states[2].setCSSName("H2");
		markdown.states[2].signed = true;
		
		markdown.states[3].addTransition('a', 7);
		markdown.states[3].addTransition('#', 4);
		markdown.states[3].setCSSName("H3");
		markdown.states[3].signed = true;
		
		markdown.states[4].addTransition('a', 7);
		markdown.states[4].addTransition('#', 5);
		markdown.states[4].setCSSName("H4");
		markdown.states[4].signed = true;
		
		markdown.states[5].addTransition('a', 7);
		markdown.states[5].addTransition('#', 6);
		markdown.states[5].setCSSName("H5");
		markdown.states[5].signed = true;
		
		markdown.states[6].addTransition('a', 7);
		markdown.states[6].addTransition('#', 7);
		markdown.states[6].setCSSName("H6");
		markdown.states[6].signed = true;
		
		markdown.states[7].addTransition('a', 7);
		
		//No CSS
		markdown.states[8].addTransition('a', 8);
		markdown.states[8].addTransition('*', 9);
		markdown.states[8].addTransition('/', 13);
		
		//BOLD
		markdown.states[9].addTransition('a', 10);
		markdown.states[9].signed = true;
		
		markdown.states[10].addTransition('a', 10);
		markdown.states[10].addTransition('*', 11);
		
		markdown.states[11].addTransition('a', 12);
		markdown.states[11].setCSSName("Bold");
		markdown.states[11].signed = true;
		
		markdown.states[12].addTransition('a', 12);
		markdown.states[12].setCSSName("Bold");
		
		//ITALIC
		markdown.states[13].addTransition('a', 14);
		markdown.states[13].signed = true;
		
		markdown.states[14].addTransition('a', 14);
		markdown.states[14].addTransition('/', 15);
		
		markdown.states[15].addTransition('a', 16);
		markdown.states[15].setCSSName("Italic");
		markdown.states[15].signed = true;
		
		markdown.states[16].addTransition('a', 16);
		markdown.states[16].setCSSName("Italic");
		
		//BULLET
		markdown.states[17].addTransition('a', 18);
		markdown.states[17].signed = true;

		markdown.states[18].addTransition('a', 18);
		markdown.states[18].setCSSName("Bullet");
		
		//NUMERATION
		
		markdown.states[19].addTransition('1', 19);
		markdown.states[19].addTransition('.', 20);
		markdown.states[19].addTransition('a', 22);
		markdown.states[19].check_num = true;
		
		
		markdown.states[20].addTransition('a', 21);
		
		markdown.states[21].addTransition('a', 21);
		markdown.states[21].setCSSName("Numeration");
		
		markdown.states[22].addTransition('a', 22);		
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
		//Create the AFD with default transition with 'a'
		AFD mainmarkdown = new AFD('a');
		//Add transitions
		mainAFD(mainmarkdown);
		
		//meanwhile .. read strings forever
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String string;
		while(true){
			try {
				string = reader.readLine(); 
				//and show their options
				String input = mainmarkdown.process(string);
				System.out.println(input);
				String output[] = Markdown.processMarkdown(input);
				for(int i = 0; i < output.length; i++){
					System.out.println(output[i]);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	

}

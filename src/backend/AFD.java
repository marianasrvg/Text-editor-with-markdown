package backend;


public class AFD {
	int total_states;
	State states[];
	int total_symbols;
	char symbols[];
	char default_key;
	private int count_states;
	
	public AFD(){}
	
	public AFD(char default_key){
		this.default_key = default_key;
	}
	
	public AFD(int number_states, int number_symbols){
		total_states = number_states;
		this.states[number_states] = new State();
		total_symbols = number_symbols;
		this.symbols = new char[number_symbols];
		count_states = 0;
	}
	
	public void createAFD(int number_states, int number_symbols){
		total_states = number_states;
		this.states = new State[number_states];
		total_symbols = number_symbols;
		this.symbols = new char[number_symbols];
		count_states = 0;
		return;
	}
	
	public int setSymbols(char symbols[]){
		if(symbols.length != total_symbols) return -1;
		this.symbols = symbols.clone();
		return 0;
	}

	public void addState(State state){
		states[count_states] = state;
		count_states++;
		return;
	}
	
	public int initialState(){
		for(int i = 0; i < total_states; i++){
			if(states[i].initial_state == true) return i;
		}
		return -1;
	}
	
	public int finalState(){
		for(int i = 0; i < total_states; i++){
			if(states[i].initial_state == true) return i;
		}
		return -1;
	}
	
	public boolean analyze(String string){
		char test[] = string.toCharArray();
		int current_state = initialState();
		for(int i = 0; i < test.length; i++){
			current_state = states[current_state].getTransition(test[i], default_key);
		}
		if(current_state == finalState()) return true;
		return true;
	}
	
	public String getCSS(String string){
		String last_css = null;
		char test[] = string.toCharArray();
		int current_state = initialState();
		for(int i = 0; i < test.length; i++){
			if(states[current_state].check_num){
				if(Character.isDigit(test[i])){
					current_state = states[current_state].getTransition('1', default_key);
				}else{
					current_state = states[current_state].getTransition(test[i], default_key);
				}
			}else{
				current_state = states[current_state].getTransition(test[i], default_key);
			}
			if(current_state == -1) return "No style";
			if(states[current_state].css != null){
				last_css = states[current_state].css;
			}
		}
		return last_css;
	}
	
	public String getCurrentState(String string){
		char test[] = string.toCharArray();
		int current_state = initialState();
		for(int i = 0; i < test.length; i++){
			if(states[current_state].check_num){
				if(Character.isDigit(test[i])){
					current_state = states[current_state].getTransition('1', default_key);
				}else{
					current_state = states[current_state].getTransition(test[i], default_key);
				}
			}else{
				current_state = states[current_state].getTransition(test[i], default_key);
			}
			if(current_state == -1) return "Something went wrong";
		}
		return states[current_state].name;
	}
	
	public int getFinalStatePosition(String string){
		char test[] = string.toCharArray();
		int current_state = initialState();
		for(int i = 0; i < test.length; i++){
			if(states[current_state].check_num){
				if(Character.isDigit(test[i])){
					current_state = states[current_state].getTransition('1', default_key);
				}else{
					current_state = states[current_state].getTransition(test[i], default_key);
				}
			}else{
				current_state = states[current_state].getTransition(test[i], default_key);
			}
			if(current_state == -1) return -1;
		}
		return current_state;
	}
	
	public int[] IntProcess(String string){
		int index[] = new int[2];
		char test[] = string.toCharArray();
		int current_state = initialState();
		boolean firstIndex = false;
		
		if(!states[getFinalStatePosition(string)].final_state){
			index[0] = 0;
			index[1] = test.length-1;
			return index;
		}
		
		for(int i = 0; i < test.length; i++){ 
			if(states[current_state].check_num){
				if(Character.isDigit(test[i])){
					current_state = states[current_state].getTransition('1', default_key);
				}else{
					current_state = states[current_state].getTransition(test[i], default_key);
				}
			}else{
				current_state = states[current_state].getTransition(test[i], default_key);
			}
			
			if(states[current_state].signed){
				if(!firstIndex) {
					index[0] = i;
					firstIndex = true;
				}
				else{
					index[1] = i-2;
				}
			}
		}
		return index;
	} 
	
	public String StringProcess(String string){
		char test[] = string.toCharArray();
		String finalString = "";
		int current_state = initialState();
		
		if(!states[getFinalStatePosition(string)].final_state){
			return string;
		}
		
		for(int i = 0; i < test.length; i++){ 
			if(states[current_state].check_num){
				if(Character.isDigit(test[i])){
					current_state = states[current_state].getTransition('1', default_key);
				}else{
					current_state = states[current_state].getTransition(test[i], default_key);
				}
			}else{
				current_state = states[current_state].getTransition(test[i], default_key);
			}
			if(!states[current_state].signed){
				finalString += test[i];
			}	
		}
		return finalString;
	}
	
	public String process(String string){
		String output = "";
		int index[] = IntProcess(string);
		output = this.StringProcess(string) +"|"+index[0]+","+index[1]+"|"+this.getCSS(string);
		return output;
	}
}

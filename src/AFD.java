

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
			current_state = states[current_state].getTransition(test[i], default_key);
			if(current_state == -1) return "Something went wrong";
			if(states[current_state].css != null){
				last_css = states[current_state].css;
			}
		}
		return last_css;
	}
}

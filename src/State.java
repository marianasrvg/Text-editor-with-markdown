import java.util.*;

public class State {
	String name;
	int position;
	boolean final_state;
	boolean initial_state;
	HashMap <Character, Integer> transition;
	
	
	public State(){}
	
	public State(String name){
		this.name = name;
		position = 0;
		final_state = false;
		initial_state = false;
		transition = new HashMap<Character, Integer>();
	}
	
	public State(String name, boolean final_state, boolean initial_state, int position){
		this.name = name;
		this.position = position;
		this.final_state = final_state;
		this.initial_state = initial_state;
		transition = new HashMap<Character, Integer>();
	}
	
	public void addTransition(char symbol, int state_position){
		transition.put(symbol, state_position);
	}
	
	
}

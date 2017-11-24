package backend;
import java.util.*;

public class State {
	String name;
	int position;
	boolean final_state;
	boolean initial_state;
	boolean check_num;
	boolean signed;
	HashMap <Character, Integer> transition;
	String css = null;
	
	
	
	public State(){
		transition = new HashMap<Character, Integer>();
	}
	
	public State(String name){
		this.name = name;
		position = 0;
		final_state = false;
		initial_state = false;
		transition = new HashMap<Character, Integer>();
		this.check_num = false;
		this.signed = false;
	}
	
	public State(String name, boolean final_state, boolean initial_state, int position){
		this.name = name;
		this.position = position;
		this.final_state = final_state;
		this.initial_state = initial_state;
		transition = new HashMap<Character, Integer>();
		this.check_num = false;
		this.signed = false;
	}

	public void addTransition(char symbol, int state_position){
		transition.put(symbol, state_position);
	}
	
	public void setState(String name, boolean final_state, boolean initial_state, int position){
		this.name = name;
		this.position = position;
		this.final_state = final_state;
		this.initial_state = initial_state;
	}
	
	public int getTransition(char x, char default_key){
		if(transition.containsKey(x)){
			return transition.get(x);
		}
		if(transition.containsKey(default_key)){
			return transition.get(default_key);
		}
		return -1;
	}
	
	public void setCSSName(String css){
		this.css = css;
	}
	
}

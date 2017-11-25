package backend;
import java.util.regex.Pattern;
import javafx.scene.text.Text;
import css.*;

public class Markdown {
	
	public static Text[] processMarkdown(String string){
		//Process input variables
		String css = null;
		String text = null;
		int index[] = new int[2];
		//Output variables
		String output[] = new String[3];
		Text text_output0 = null;
		Text text_output1 = null;
		Text text_output2 = null;
		
		//Process input 		text | index | CSS
		String input[] = string.split(Pattern.quote("|"));
		text = input[0];
		css = input[2];
		String temp_index[] = input[1].split(",");
		index[0] = Integer.parseInt(temp_index[0]);
		index[1] = Integer.parseInt(temp_index[1]);
		
		System.out.println(css +" "+text+" "+index[0]+" "+index[1]);
		//Check what type of CSS is
			
			if(css.equals(null)){
				output[0] = text;
				output[1] = null;
				output[2] = null;
			}else if(css.equalsIgnoreCase("Bold") || css.equalsIgnoreCase("Italic")){
				output = processBoldItalic(text, index[0], index[1]);
			}else{
				//H#, numeration or bullet
				//null | text with css | null
				output = processHeaderNumerationBullet(text);
			}
		text_output0 = new Text(output[0]);
		text_output1 = new Text(output[1]);
		text_output2 = new Text(output[2]);
		
		/*if(text_output0.equals(null)){
			text_output0 = assignedCSS(text_output0, "Normal");
		}else{
			text_output0 = assignedCSS(text_output0, css);
		}*/
		
		if(text_output1.equals(null)){
			text_output1 = assignedCSS(text_output1, "Normal");
		}else{
			text_output1 = assignedCSS(text_output1, css);
		}
		/*
		if(text_output2.equals(null)){
			text_output2 = assignedCSS(text_output2, "Normal");
		}else{
			text_output2 = assignedCSS(text_output2, css);
		}*/
		System.out.println(text_output1);
		Text text_output[] = {text_output0, text_output1, text_output2};
		return text_output;
	}
	
	public static Text assignedCSS(Text text, String string){
		text.setId(string);
		return text;
	}
	
	public static String[] processBoldItalic(String string, int indexL, int indexH){
		char[] arraystring = string.toCharArray();
		String output[] = {"","",""};
		for(int i = 0; i < indexL; i++){
			output[0] += arraystring[i];
		}
		//if(indexL == 0) output[0] = null;
		for(int i = indexL; i <= indexH; i++){
			//apply CSS
			output[1] += arraystring[i];
		}
		for(int i = indexH+1; i < arraystring.length; i++){
			output[2] += arraystring[i];
		}
		//if(indexH == arraystring.length-1) output[2] = null;
		return output;
	}

	public static String[] processHeaderNumerationBullet(String string){
		String output[] = new String[3];
		output[0] = null;
		output[1] = string;
		output[2] = null;
		return output;
	}
}

import java.util.regex.Pattern;

public class Markdown {
	public static String[] processMarkdown(String string){
		//Process input variables
		String css = null;
		String text = null;
		int index[] = new int[2];
		//Output variables
		String output[] = new String[3];
		
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
				return output;
			}else if(css.equalsIgnoreCase("Bold") || css.equalsIgnoreCase("Italic")){
				return processBoldItalic(text, index[0], index[1]);
			}else{
				//H#, numeration or bullet
				//null | text with css | null
				return processHeaderNumerationBullet(text);
			}		
	}
	
	public static String[] processBoldItalic(String string, int indexL, int indexH){
		char[] arraystring = string.toCharArray();
		String output[] = {"","",""};
		for(int i = 0; i < indexL; i++){
			output[0] += arraystring[i];
		}
		if(indexL == 0) output[0] = null;
		for(int i = indexL; i <= indexH; i++){
			//apply CSS
			output[1] += arraystring[i];
		}
		for(int i = indexH+1; i < arraystring.length; i++){
			output[2] += arraystring[i];
		}
		if(indexH == arraystring.length-1) output[2] = null;
		return output;
	}

	public static String[] processHeaderNumerationBullet(String string){
		String output[] = new String[3];
		output[1] = string;
		return output;
	}
}

package ex1;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Input {

	Scanner scan = new Scanner(System.in);
	//Pattern p = Pattern.compile("^[0-9]*$");

	public boolean isNum(int[] value){
		//scan.useDelimiter(" ");
		String[] input = new String[value.length];
		if(input.length == value.length) {
			for(int i = 0;i < value.length;i++) {
				input[i] = scan.next();
				//Matcher m = p.matcher(input[i]);
				if(Pattern.matches("^[0-9]*$", input[i])) {
				//	System.out.println(Pattern.matches("^[0-9]*$", input[i]));
					value[i] = Integer.parseInt(input[i]);
				}else {
				//	System.out.println(input[i]);
					System.out.println("f1");
					return false;
				}
			}
		}else {
			System.out.println("f2");
		return false;
		}
		return true;
	}


	public boolean limitCheck(int n,int max,int min) {
		if(n < min && n > max) {
			return false;
		}else {
			return true;
		}
	}
}


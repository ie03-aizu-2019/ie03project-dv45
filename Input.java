package ex1;

import java.util.List;
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
					value[i] = Integer.parseInt(input[i]);
				}else if(Pattern.matches("^c?[0-9]*$", input[i])){

				}else {
				//	System.out.println("f1");
					return false;
				}
			}
		}else {
		//	System.out.println("f2");
		return false;
		}
		return true;
	}

// 点の入力を受け付ける
	
	public boolean isP(int P,Point[] set,Point[] points,List<Point> list,int rank) {
	// Pまでの入力を受け付けるが、最後の一つは何番目に近いかを決めるためP-1
		String[] input = new String[P];
		if(input.length == P - 1) {
			Point[] p = new Point[P-1];
			for(int i = 0;i < P-1;i++) {
				p[i] = new Point();
			}
			for(int i = 0;i < P-1;i++) {
				input[i] = scan.next();
				//Matcher m = p.matcher(input[i]);
				if(Pattern.matches("^[0-9]*$", input[i])) {
				set[i] = points[Integer.parseInt(input[i])];
				}else if(Pattern.matches("^c?[0-9]*$", input[i])){
					if(Integer.parseInt(input[i].substring(1)) > list.size()) {
						set[i] = null;
					}else {
						set[i] = list.get(Integer.parseInt(input[i].substring(1)));
					}
				}else {
				//	System.out.println("f1");
					return false;
				}
			}
			rank = Integer.parseInt(input[P-1]);
			return true;
		}else {
		//	System.out.println("f2");
		return false;
		}
	}

	public boolean limitCheck(int n,int max,int min) {
		if(n < min && n > max) {
			return false;
		}else {
			return true;
		}
	}
}


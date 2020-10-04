import java.util.Scanner;

public class RLECompression {
	
	public static void main(String[] args) {
		System.out.println(runLengthEncoding());
	}

	public static String runLengthEncoding() {
		Scanner in = new Scanner(System.in); //gets input from console 
		
		String check = in.nextLine(), answer = "";
		int count = 1;
		char letter =  check.charAt(0);
		
		for(int i = 1;i < check.length();i++) { //loops through input string
			
			if(check.charAt(i) == letter) {
				count++; //Increase count if letter is the same
			}else {
				if(count > 1) { //Check for single letter 
					answer += letter + "" + count;
				}else {
					answer += letter;
				}
				
				letter = check.charAt(i);
				count = 1;
			}
			
		}
		
		return answer; 
	}
}

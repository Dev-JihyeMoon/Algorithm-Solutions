import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String stick = br.readLine();
		Stack<Character> stack = new Stack<>();
		int answer = 0;
		
		for(int i=0; i<stick.length(); i++) {
			char now = stick.charAt(i);
			
			if(now=='(') {
				stack.add(now);
			} else {
				stack.pop();
				char back = stick.charAt(i-1);
				
				if(back=='(') {
					answer += stack.size();
				} else {
					answer += 1;
				}
			}
		}
		
		
		System.out.print(answer);
		br.close();
	}
}
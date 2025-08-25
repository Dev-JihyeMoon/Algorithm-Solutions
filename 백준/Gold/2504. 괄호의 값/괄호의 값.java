import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String input = br.readLine();
		Stack<Character> stack = new Stack<>();
		
		int answer = 0, temp = 1;
		
		for(int i=0; i<input.length(); i++) {
			char now = input.charAt(i);
			
			if(now=='(' || now=='[') {
				stack.add(now);
				
				if(now=='(') {
					temp *= 2;
				} else {
					temp *= 3;
				}
			} else if(now==')') {
				if(stack.isEmpty() || stack.peek() != '(') {
					answer = 0;
					break;
				} else if(input.charAt(i-1)=='(') {
					answer+=temp;
				} 
				stack.pop();
				temp /= 2;
			} else if(now==']') {
				if(stack.isEmpty() || stack.peek() != '[') {
					answer = 0;
					break;
				} else if(input.charAt(i-1)=='[') {
					answer+=temp;
				}
				stack.pop();
				temp /= 3;
			}
		}
		
		if(stack.isEmpty()) {
			System.out.print(answer);
		} else {
			System.out.print(0);
		}
		
		
		
		br.close();
	}
}
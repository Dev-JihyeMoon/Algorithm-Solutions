import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<input.length(); i++) {
			char now = input.charAt(i);
			
			if(now=='<') {
				while(!stack.isEmpty()) {
					bw.write(stack.pop());
				}
				while(true) {
					bw.write(now);
					if(now=='>') {
						break;
					}
					i++;
					now = input.charAt(i);
				}
			} else if(now==' ') {
				while(!stack.isEmpty()) {
					bw.write(stack.pop());
				}
				bw.write(" ");
			} else {
				stack.add(now);
			}
		}
		
		while(!stack.isEmpty()) {
			bw.write(stack.pop());
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		
		for(int i=0; i<count; i++) {
			String input = br.readLine();
			Deque<String> stack = new ArrayDeque<>();
			
			for(int j=0; j<input.length(); j++) {	
				String now = String.valueOf(input.charAt(j));
				
				if(stack.isEmpty()) {
					stack.push(now);
				} 
				else if(now.equals("(")) {
					stack.push(now);
				}
				else {
					if(stack.peek().equals("("))
						stack.pop();
					else 
						stack.push(now);
				}
				
				//System.out.println(stack);
			}
			if(!stack.isEmpty())
				bw.write("NO"+"\n");
			else
				bw.write("YES"+"\n");
			
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}

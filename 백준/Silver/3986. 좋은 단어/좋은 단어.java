import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		
		for(int i=0; i<n; i++) {
			String word = br.readLine();
			count+=goodWord(word);
		}
		
		System.out.print(count);
		br.close();
	}
	
	public static int goodWord(String word) {
		Stack<String> temp = new Stack<>();
		
		for(int i=0; i<word.length(); i++) {
			String now = String.valueOf(word.charAt(i));
			
			if(!temp.isEmpty() && temp.peek().equals(now)) {
				temp.pop();
			} else {
				temp.add(now);
			}
		}
		
		if(temp.isEmpty()) {
			return 1;
		} else {
			return 0;
		}
		
	}
}
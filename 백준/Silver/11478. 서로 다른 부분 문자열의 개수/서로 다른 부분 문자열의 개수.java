import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class Main {	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String s = br.readLine();
		
		LinkedHashSet<String> answer = new LinkedHashSet<>();
		
		int count = 1, goal = s.length();

		while(count<=s.length()) {
			for(int i=0; i<goal; i++) {
				String now = s.substring(i, i+count);
				answer.add(now);
			}
			
			count++;
			goal--;
		}
		
		System.out.print(answer.size());
		br.close();
	}
}

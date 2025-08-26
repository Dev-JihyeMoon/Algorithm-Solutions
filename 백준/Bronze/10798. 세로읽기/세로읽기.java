import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String[] memo = new String[15];
		
		for(int i=0; i<5; i++) {
			String input = br.readLine();
			
			for(int j=0; j<input.length(); j++) {
				memo[j] += Character.toString(input.charAt(j));
			}
		}
		
		for(int i=0; i<15; i++) {
			if(memo[i] != null) {
				int temp = memo[i].length();
				System.out.print(memo[i].substring(4, temp));
			}
		}
	}
}
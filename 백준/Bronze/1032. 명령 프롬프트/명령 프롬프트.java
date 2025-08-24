import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());
		String[] input = new String[n];
		
		for(int i=0; i<n; i++) {
			input[i] = br.readLine();
		}
		
		String answer = "";
		
		for(int i=0; i<input[0].length(); i++) {
			String check = String.valueOf(input[0].charAt(i));
			
			for(int j=1; j<n; j++) {
				if(input[j-1].charAt(i) != input[j].charAt(i)) {
					check = "?";
					break;
				}
			}
			
			answer += check;
		}
		
		System.out.print(answer);
		br.close();
	}
}

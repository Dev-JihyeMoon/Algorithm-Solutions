import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		String text = "";
		
		for(int i=0; i<tc; i++) {
			text = br.readLine();
			
			if(text.contains("N") && text.contains("S")) {
				text = text.replace("N", "");
				text = text.replace("S", "");
			}
			
			if(text.contains("W") && text.contains("E")) {
				text = text.replace("W", "");
				text = text.replace("E", "");
			}
			
			if(text.length() == 0) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
			
		}
		
		
		br.close();
	}
}
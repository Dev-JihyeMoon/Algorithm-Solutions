import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long x = Integer.parseInt(br.readLine());
		
		if(x == 1) {
			System.out.print("1/1");
			return;
		}
		
		int lineNumber = 2; 
		x--;
		
		while(lineNumber < x) {
			x -= lineNumber;
			lineNumber++;
		}
				
		if(lineNumber%2 == 0) {
			System.out.print((x)+"/"+(lineNumber+1-x));
		} else {
			System.out.print((lineNumber+1-x)+"/"+(x));
		}
		
		br.close();
	}
}

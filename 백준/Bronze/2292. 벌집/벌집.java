import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());

		int count = 1, max = 1, add = 6;
		
		while(true) {
			if( n <= max ) {
				break;
			}
			
			max += add;
			add += 6; 
			count++;
		}
		
		System.out.print(count);
		
		br.close();
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int sum = 0;
			int n = Integer.parseInt(br.readLine());
			for(int j = 1; j <= n; j++) {
				int A = 0;
				
				for(int k = 1; k <= (j + 1); k++) {
					A += k;
				}
				sum += (j * A);
			}
			System.out.println(sum);
		}
		
	}

}
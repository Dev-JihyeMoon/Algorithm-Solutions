import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int count = 0, i = 666;
		
		while(true) {
			if(Integer.toString(i).contains("666")) {
				count++;
			}
			
			if(count == n) {
				break;
			}
			i++;
		}
		
		System.out.print(i);
		br.close();
	}
}

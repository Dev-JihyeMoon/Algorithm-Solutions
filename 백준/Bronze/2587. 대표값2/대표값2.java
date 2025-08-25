import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] input = new int[5];
		int sum=0;
		
		for(int i=0; i<5; i++) {
			input[i] = Integer.parseInt(br.readLine());
			sum += input[i];
		}
		
		for(int i=1; i<5; i++) {
			for(int j=0; j<5-i; j++) {
				if(input[j]<input[j+1]) {
					int swap = input[j];
					input[j] = input[j+1];
					input[j+1] = swap;
				}
			}
		}
		
		System.out.print(sum/5+"\n"+input[2]);
		br.close();
	}
}
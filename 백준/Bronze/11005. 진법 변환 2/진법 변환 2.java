import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int N = input[0];
		int B = input[1];
		
		String output = "";
		
		while(true) {	
			if(N<B) {
				output = setting(output, N);
				break;
			}
			
			int temp = N%B;
			N /= B;
			output = setting(output, temp);
		}

		System.out.print(output);
		br.close();
		
	}
	
	public static String setting(String output, int i) {
		char temp = (char) (48 + i);
		
		if(10 <= i) {
			temp = (char) (55+i);
		}
				
		output = String.valueOf(temp) + output;
		
		return output;
	}
}
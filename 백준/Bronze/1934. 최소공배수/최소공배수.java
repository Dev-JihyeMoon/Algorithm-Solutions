import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
			
		for(int i=0; i<n; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			int A = input[0], B = input[1];
			int output = 1, temp = 0;
			
			while(true) {
				temp = A * output;
				
				if(temp % B == 0) {
					bw.write(temp+"\n");
					break;
				} else {
					output++;
				}
				
			}
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
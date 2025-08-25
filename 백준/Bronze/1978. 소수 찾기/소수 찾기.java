import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String arge[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		bw.write(String.valueOf(solution(n, arr)));
		bw.close();
		br.close();
	}
	
	public static int solution(int n, int[] arr) {
		int output = 0;
		
		for(int i=0; i<n; i++) {
			if(arr[i] <= 1) {
				continue;
			}
			
			boolean check = true;
			for(int j=2; j*j <= arr[i]; j++) {
				if(arr[i]%j==0) {
					check = false;
					break;
				}
			}
			
			if(check) {
				output++;
			}
		}
		
		return output;
	}
}

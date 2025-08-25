import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String arge[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		bw.write(String.valueOf(solution(input[0], input[1])));
		bw.close();
		br.close();
		
	}
	
	public static int solution(int n, int k) {
		boolean[] check = new boolean[n+1];
		int count = 0;
		
		for(int i=2; i<=n; i++) {
			if(check[i]) continue;
			
			for(int j=i; j<=n; j+=i) {
				if(!check[j]) {
					count++;
					check[j] = true;
					
					if(count == k) {
						return j;
					}
				}
			}
		}
		
		return 0;
		
	}
}
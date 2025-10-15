import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N; 
	static int[] data, sum;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());		
		data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		sum = new int[N];
		
		sum[0] = data[0];
		dp(1);
		
		Arrays.sort(sum);
		
		System.out.print(String.valueOf(sum[N-1]));
		br.close();
	}
	
	public static void dp(int point) {
		if(point == N) {
			return;
		}
		
		int temp = sum[point-1]+data[point];
		
		if(data[point] < temp) sum[point] = temp;
		else sum[point] = data[point];
		
		dp(++point);		
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] arr = new int[10001];
	static int N;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr[0] = arr[1] = 1;
		
		dp(1);
		
		System.out.print(String.valueOf(arr[N]));
		br.close();
		
	}
	
	public static void dp(int point) {
		if(point == N) {
			return;
		}
		
		arr[point+1] = ( (arr[point-1] * 2) + arr[point] ) % 10007;
		dp(++point);		
	}
}
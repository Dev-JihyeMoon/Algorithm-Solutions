import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] answer = new int[3];
	static int[][] arr;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		arr = new int[N][3];
		
		for(int i=0; i<N; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		dp(1);
		int answer = arr[N-1][0];
		
		System.out.print(String.valueOf(answer));
		br.close();
	}
	
	public static void dp(int depth) {
		if(depth == N) {
			Arrays.sort(arr[N-1]);
			return ;
		}
		
		arr[depth][0] += Math.min(arr[depth-1][1], arr[depth-1][2]);
		arr[depth][1] += Math.min(arr[depth-1][0], arr[depth-1][2]);
		arr[depth][2] += Math.min(arr[depth-1][0], arr[depth-1][1]);
		
		dp(depth+1);
	}
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	static int N, answer;
	static boolean[] isVisited = new boolean[3];
	static int[] arr;
	
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			answer = 0;
			getSolution(0, N);
			bw.write(String.valueOf(answer)+"\n");
		}
		
		bw.close();
		br.close();
	}
	
	public static void getSolution(int cnt, int n) {
		if(cnt==N) {
			int sum = 0;
			for(int i=0; i<n; i++) {
				sum+=arr[i];
			}
			//System.out.println("탈락"+Arrays.toString(arr)+" "+String.valueOf(sum));
			if(sum==N) {
				//System.out.println(Arrays.toString(arr)+" "+String.valueOf(sum));
				answer++;
			}
			
			return;
		}
		
		for(int i=1; i<=3; i++) {
			arr[cnt] = i;
			getSolution(cnt+1, n--);
			
		}
	}
}
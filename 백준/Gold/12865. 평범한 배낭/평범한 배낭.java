import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, K;
	static int[] weight, value;
	static Integer[][] bag;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = input[0];
		K = input[1];
		
		bag = new Integer[N][K+1];
		weight = new int[N];
		value = new int[N];
		
		for(int i=0; i<N; i++) {
			input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			weight[i] = input[0];
			value[i] = input[1];
			
		}
		
		System.out.print(String.valueOf(knapsack(N-1, K)));
		br.close();
	}
	
	public static int knapsack(int i, int k) {
		//범위를 이탈할 경우
		if(i<0) return 0;
		
		//탐색하지 않은 위치일 경우 
		if(bag[i][k] == null) {
			//물건을 추가로 못담는 경우
			if(k < weight[i]) {
				bag[i][k] = knapsack(i-1, k);
			} 
			//물건을 추가로 담을 수 있는 경우
			else {
				bag[i][k] = Math.max(knapsack(i-1, k), knapsack(i-1, k-weight[i])+value[i]);
			}
		}
		
		return bag[i][k];
	}
}
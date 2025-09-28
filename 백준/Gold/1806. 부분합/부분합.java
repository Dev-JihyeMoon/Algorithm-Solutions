import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = input[0], S = input[1];
		
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		System.out.print(String.valueOf(getTwopointer(arr, S)));
		br.close();
		
	}
	
	public static int getTwopointer(int[] arr, int s) {
		int start = 0, end = 0, answer = 100001;
		long sum = arr[0];
		final int len = arr.length-1;
		
		while(start != len+1) {
			if(sum < s && end < len) {
				end++;
				sum+=arr[end];
			} else {
				if(s <= sum && (end-start+1) < answer) answer = end-start+1;
				
				sum-=arr[start];
				start++;
			}
		}
		
		return answer==100001?0:answer; 
	}
}

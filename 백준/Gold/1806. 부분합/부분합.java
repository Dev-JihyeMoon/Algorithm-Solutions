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
	
	public static int getTwopointer(int[] arr, int s) {// 마지막 요소가 유일하게 합을 넘을 경우를 고려해야 하기 때문에 start도 배열의 끝까지 체크가 끝난 후 종료
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int N = input[0], M = input[1];
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		System.out.print(String.valueOf(getTwoPointer(arr, N-1, M)));
		br.close();	
	}
	
	
	public static int getTwoPointer(int[] arr, int size, int min) {
		int start = 0, end = 0, current;
		int answer = 2000000000;
		
		while(start != size) { // 시작 지점이 끝 부분까지 다 탐색하면 종료 
			current = Math.abs(arr[start] - arr[end]);
			
			if(current < min && end < size) {
				end++;
			} else {
				start++;
				
				if(min <= current && current < answer) answer = current;
			}
			
			if(answer == min) break;
		}
		
		return answer;
	}
}
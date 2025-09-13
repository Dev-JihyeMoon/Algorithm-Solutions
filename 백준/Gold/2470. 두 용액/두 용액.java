import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, value;
	static int[] answer = new int[2];
	static int[] arr;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		//오름차순 정렬
		Arrays.sort(arr);
		
		value = 2000000001;
		for(int i=0; i<N-1; i++) {
			binarySearch(i);
			
			if(value == 0) break;
		}
		System.out.print(String.valueOf(answer[0]+" "+answer[1]));
		br.close();
	}
	
	//이진탐색 
	public static void binarySearch(int start) {
		final int i = arr[start]; 

		int end = N-1, point;
		start++;
		while(start <= end) {
			point = ((start)+end)/2; //비교할 주소

			//현재 특성값이 기존 특성값보다 0에 가까울 경우
			if(Math.abs(i+arr[point]) < value) {
				value = Math.abs(i+arr[point]);
				answer[0] = i;
				answer[1] = arr[point];
				
				if(value==0) return;
			}
			
			//다음 경로는 기준점(i)의 절댓값에 가까워지는 방향으로 탐색
			if(Math.abs(i) < arr[point]) end = point-1; 
			else start = point+1;
			
		}
	}
}
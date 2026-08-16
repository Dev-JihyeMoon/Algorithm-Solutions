import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String[] ages) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=1; i<=10; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] now = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			int answer = view(n, now);
			
			bw.write("#"+i+" "+answer+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	public static int view(int n, int[] arr) {
		int output = 0;
		
		for(int i=2; i<n-2; i++) {
			int left = arr[i-2]<arr[i-1]?arr[i-1]:arr[i-2];
			int right = arr[i+2]<arr[i+1]?arr[i+1]:arr[i+2];
			
			if(arr[i] <= left || arr[i] <= right) {
				continue;
			}
			
			int max = left<right?right:left;
			output += arr[i] - max;
			
		}
		
		return output;
	}
}
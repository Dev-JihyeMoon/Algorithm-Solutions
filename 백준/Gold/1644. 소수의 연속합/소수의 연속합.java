import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 2~N까지의 소수 배열
		int[] decimal = getDecimal(N);
		
		// 투포인터, 연속된 소수의 합으로 나타내는 경우의 수 도출
		int answer = decimal.length==0?0:getTwopointer(decimal, N);
		
		System.out.print(String.valueOf(answer));
		br.close();
	}
	
	public static int getTwopointer(int[] decimal, int n) {
		int start=0, end=0, answer = 0, len = decimal.length;
		long sum=decimal[0];
		
		while(start != len) {
			if(sum < n && end < len-1) {
				end++;
				sum+=decimal[end];
			} else {
				if(sum == n) answer++;
				
				sum -= decimal[start];
				start++;
			}
		}
		
		return answer;
	}
	
	//'에라토스테네스의 체'로 N까지의 소수를 배열 형태로 도출
	public static int[] getDecimal(int n) {
		boolean[] isVisited = new boolean[n+1];
		isVisited[0] = isVisited[1] = true;
		
		//에라토스테네스의 체
		for(int i=2; i*i<=n; i++) {
			if(!isVisited[i]) {
				for(int j=i*i; j<=n; j+=i) {
					isVisited[j] = true;
				}
			}
		}
		
		//자연수 배열로 변환
		ArrayList<Integer> temp = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			if(!isVisited[i]) {
				temp.add(i);
			}
		}

		return temp.stream().mapToInt(i -> i).toArray();
	}
}
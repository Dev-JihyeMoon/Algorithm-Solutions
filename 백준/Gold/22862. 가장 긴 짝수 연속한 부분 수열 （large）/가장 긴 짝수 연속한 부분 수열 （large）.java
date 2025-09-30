import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N=input[0], K=input[1];
		
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int answer = getTwopointer(getSummary(arr), K);
		
		System.out.print(String.valueOf(answer));
		
		br.close();
		
	}
	
	public static int getTwopointer(int[] arr, int k) {
		int start=0, end=0, count=0, max=0, temp=0;
		int len=arr.length;
		
		while(start!=len) {
			if(count<=k && end <len) {
				int now = end%2;
				
				count += now==0?0:arr[end];
				temp  += now==0?arr[end]:0;
				end++;
			} else {		
				if(max < temp) {
					max = temp;
				}
				
				int now = start%2;
				
				count -= now==0?0:arr[start];
				temp  -= now==0?arr[start]:0;
				start++;
			}
		}
		return max;
	}
	
	public static int[] getSummary(int[] arr) {
		ArrayList<Integer> temp = new ArrayList<>();
		int start = arr[0]%2, count=0; 
		
		for(int i=0; i<arr.length; i++) {
			int now = arr[i]%2;
			
			if(start==now) {
				count++;
			} else {
				temp.add(count);
				start=now;
				count=1;
			}
		}
		temp.add(count); // 마지막 요소 더하기
		
		int[] output = temp.stream().mapToInt(i -> i).toArray();
		if(arr[0]%2!=0) {
			output = Arrays.copyOfRange(output, 1, output.length);
		}
		
		return output;
	}
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			bw.write(String.valueOf(solution(arr[0], Arrays.copyOfRange(arr, 1, arr[0]+1)))+"\n");
		}
		
		bw.close();
		br.close();
	}
	
	public static long solution(int n, int[] arr) {
		long sum = 0;
		
		if(n==1) {
			return arr[0];
		}
		
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(arr[i]<arr[j]) {
					sum += gcd(arr[j], arr[i]);
				} else {
					sum += gcd(arr[i], arr[j]);
				}
			
			}
		}
		
		return sum;
	}
	
	public static int gcd(int num1, int num2) {
		int temp;
		
		while(num2 != 0) {
			temp = num1 % num2;
			num1 = num2;
			num2 = temp;
		}
		
		return num1;
	}
}
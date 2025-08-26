import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n, m;
	static int[] arr = new int[8];
	static boolean[] isUsed = new boolean[8];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		n = input[0];
		m = input[1];
		
		func(0, 0);
		
		br.close();
	}
	
	public static void func(int k, int temp) {
		if(k==m) {
			for(int i=0; i<m; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.print("\n");
			
			return;
		}
		
		for(int i=temp; i<n; i++) {
			if(!isUsed[i]) {
				arr[k]=i+1;
				isUsed[i]=true;
				func(k+1, i+1);
				isUsed[i] = false;
			}
		}
	}
}
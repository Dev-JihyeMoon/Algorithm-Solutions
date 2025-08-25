import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n, m;
	static int arr[] = new int[10];
	static boolean isUsed[] = new boolean[10];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		n = input[0];
		m = input[1];
		func(0);
		
		br.close();
	}
	
	public static void func(int k) {
		if(k==m) {
			for(int i=0; i<m; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if(!isUsed[i]){
				arr[k] = i;
				isUsed[i] = true;
				func(k+1);
				isUsed[i] = false;
			}
		}
	}
}
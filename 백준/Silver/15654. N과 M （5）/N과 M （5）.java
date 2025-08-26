import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static int n, m;
	static int[] arr = new int[8];
	static int[] output = new int[8];
	static boolean[] isused = new boolean[8];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		n = input[0];
		m = input[1];
		
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
		
		func(0);
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	public static void func(int count) throws IOException  {
		if(count==m) {
			for(int i=0; i<m; i++) {
				bw.write(output[i]+" ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!isused[i]) {
				output[count] = arr[i];
				isused[i] = true;
				func(count+1);
				isused[i] = false;
			}
		}
	}
}
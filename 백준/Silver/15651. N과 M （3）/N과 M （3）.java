
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static int n, m;
	static int[] arr = new int[8];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		n = input[0];
		m = input[1];
	
		func(0);
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static void func(int k) throws IOException {
		if(k==m) {
			for(int i=0; i<m; i++) {
				bw.write(arr[i]+" ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i=1; i<=n; i++) {
				arr[k] = i;
				func(k+1);
		}
	}
}

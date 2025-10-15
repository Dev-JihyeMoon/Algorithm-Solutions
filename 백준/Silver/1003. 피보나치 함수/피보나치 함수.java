import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static int[][] arr = new int[41][2];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		arr[0][0] = arr[1][1] = 1;
		arr[0][1] = arr[1][0] = 0;
		setFibo(1);
		
		int N;
		for(int i=0; i<T; i++) {
			N = Integer.parseInt(br.readLine());
			
			bw.write(String.valueOf(arr[N][0]+" "+arr[N][1]+"\n"));
		}
		
		bw.close();
		br.close();
	}
	
	public static void setFibo(int point) {
		if(point == 40) {
			return;
		}
		
		arr[point+1][0] = arr[point][0]+arr[point-1][0]; 
		arr[point+1][1] = arr[point][1]+arr[point-1][1]; 
		setFibo(++point);
	}
}
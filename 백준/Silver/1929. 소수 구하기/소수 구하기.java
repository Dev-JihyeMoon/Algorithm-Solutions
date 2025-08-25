import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//범위 내에서의 소수 판정법 에라토스테네스의 체
public class Main {
	public static void main(String arge[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int start = arr[0], end = arr[1];
		boolean[] check = new boolean[end+1];
		
		check[1] = true;
		
		for(int i=2; i*i<=end; i++) {
			if(check[i]) {
				continue;
			}
			for(int j=i*i; j<=end; j+=i) {
				check[j] = true;
			}
		}
		
		for(int i=start; i<=end; i++) {
			if(!check[i]) {
				bw.write(String.valueOf(i)+"\n");
			}
		}
		
		bw.close();
		br.close();
	}
}

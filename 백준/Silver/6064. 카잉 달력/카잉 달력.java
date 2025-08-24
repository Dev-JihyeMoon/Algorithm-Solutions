import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String arge[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			bw.write(String.valueOf(solution(data[0], data[1], data[2], data[3]))+"\n");
		}
		
		bw.close();
		br.close();
	}
	
	public static int solution(int m, int n, int x, int y) {
		int lcm = LCM(m, n);
		
		if(x==m) x = 0;
		if(y==n) y = 0;
		
		for(int i=x; i<=lcm; i+=m) {
			if(i == 0) continue;
			if(i%n==y) {
				return i;
			}
		}
		
		return -1;
	}
	
	//유클리드 호제법을 이용한 최소공배수 구하기
	public static int LCM(int m, int n) {
		int output = m*n;
		
		//gcd(최대공약수 구하기)		
		while(n!=0) {
			int temp = m%n;
			
			m = n;
			n = temp;
		}
		
		return output / m;
	}
}


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static final int MAX = 1000000;
	static boolean[] primeList = new boolean[MAX+1];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		prime();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			bw.write(count(n)+"\n");
		}
		
		bw.close();
		br.close();
	}
	
	public static int count(int n) {
		int output = 0;
		
		for(int i=2; i<=n/2; i++) {
			if(!primeList[i] && !primeList[n-i]) {
				output++;
			}
		}
		return output;
		
	}
	
	public static void prime() {
		//0, 1은 소수가 아니니 예외 처리
		primeList[0] = primeList[1] = true;
		
		//에라토스테네스의 체로 소수 판별, primeList 배열 내 false가 소수가 됨. 
		for(int i=2; i*i<=MAX; i++) {
			if(primeList[i]) continue;
			
			for(int j=i*i; j<MAX; j+=i) {
				primeList[j] = true;
			}
		}
	}
}
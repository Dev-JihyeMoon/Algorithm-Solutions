import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static boolean[] isList = new boolean[123457*2];
	static int checkPoint = 1; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			
			if(n==0) {
				break;
			}
			
			bw.write(String.valueOf(count(n))+"\n");
		}
		
		br.close();
		bw.close();
	}
	
	public static int count(int n) {
		if(checkPoint < n) {
			check(n, n*2);
		} else if(n == 1) {
			return 1;
		}
		
		int answer = 0;
		
		//false 일 경우 소수
		for(int i=n+1; i<n*2; i++) {
			if(!isList[i]) {
				answer++;
			}
		}
		
		return answer;
	}
	
	public static void check(int n, int m) {
		for(int i=2;i*i<=m;i++) {
			if(isList[i]) {
				continue;
			} 
			
			for(int j=i*i;j<m;j+=i) {
				isList[j] = true;
			}
		}
		
		checkPoint = n;
	}
}

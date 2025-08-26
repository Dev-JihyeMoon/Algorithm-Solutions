import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static final int MAX = 100000;
	static int[] primeList;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		prime();
		
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			
			for(int j:primeList) {
				if(n%j!=0) {
					continue;
				}
				
				int count = 0;
				while(n%j==0) {
					n /= j;
					count++;
				}
				
				bw.write(j+" "+count+"\n");
				if(n==1) {
					break;
				}
			}
			
			if(n != 1) {
				bw.write(n+" "+1+"\n");
			}
		}
		
		bw.close();
		br.close();
	}
	
	public static void prime() {
		int[] temp = new int[MAX];
		boolean[] check = new boolean[MAX+1];
		
		for(int i=2; i*i<=MAX; i++) {
			if(check[i]) {
				continue;
			}
			
			for(int j=i*i; j<=MAX; j+=i) {
				check[j] = true;
			}
		}
		
		int count = 0;
		for(int i=2; i<(MAX/2+1); i++) {
			if(!check[i]) {
				temp[count++] = i;
			}
		}
		
		primeList = Arrays.copyOf(temp, count);
	}
}
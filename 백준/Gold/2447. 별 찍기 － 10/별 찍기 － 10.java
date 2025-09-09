import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				getSolution(i, j, N);
			}
			
			sb.append("\n");
		}
		System.out.print(String.valueOf(sb));
		br.close();
	}

	public static void getSolution(int i, int j, int num) {	
		if((i/num)%3==1 && (j/num)%3==1) {
			sb.append(" ");
		} else {
			if(num/3==0) {
				sb.append("*");
			} else {
				getSolution(i, j, num/3);
			}
		}
	}
	
}
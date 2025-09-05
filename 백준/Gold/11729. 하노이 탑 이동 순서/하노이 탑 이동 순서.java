import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int count=0;
	static StringBuffer st = new StringBuffer();
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		Integer N = Integer.parseInt(br.readLine());
		solution(N, 1, 3, 2);
		System.out.print(count+"\n"+String.valueOf(st));
		br.close();
		
	}
	
	public static void solution(int N, int start, int end, int temp) {
		if(N==0)
			return;
		else {
			count++;
			
			solution(N-1, start, temp, end);
			st.append(start+" "+end+"\n");
			solution(N-1, temp, end, start);
		}
		
	}
}
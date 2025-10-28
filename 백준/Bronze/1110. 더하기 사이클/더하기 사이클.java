import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int count=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		getSolution(N);
		
		System.out.print(String.valueOf(count));
		br.close();
	}
	
	public static void getSolution(int num) {
		count++;
		
		int sum = (num/10) + (num%10);
		int temp = ((num%10) * 10) + (sum%10);
		
		if(N == temp) {
			return;
		}
		
        getSolution(temp);
		
	}
}
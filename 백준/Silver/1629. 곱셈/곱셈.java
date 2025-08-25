import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long input[] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		
		System.out.print(solution(input[0], input[1], input[2]));
		br.close();
	}
	
	public static long solution(long a, long b, long m) {
		if(b==1) {
			return a%m;
		}
		
		long val = solution(a, b/2, m);
		val = ( val * val ) % m;
		
		if(b%2 == 0) {
			return val;
		} else {
			return val * a % m;
		}
	}
	
}
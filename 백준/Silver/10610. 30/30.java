import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = br.readLine().toCharArray();
		Arrays.sort(input);
		
		//10의 배수가 될 수 있는가 확인
		if(input[0] != '0') {
			System.out.print("-1");
			br.close();
			return;
		}
		
		//3의 배수가 될 수 있는가 확인
		int sum = 0;
		for(char i:input) {
			sum += i - '0';
		}
		
		//3의 배수가 아닐 경우 -1 출력, 아닐 경우 위 for문에서 저장한 30의 가장 큰 배수 출력
		if(sum%3 != 0) {
			System.out.print("-1");
		} else {
			StringBuilder sb = new StringBuilder(input.length);
		    for (int i = input.length - 1; i >= 0; i--) {
		    	sb.append(input[i]); // 내림차순
		    }
			System.out.print(sb.toString());
		}
		
		br.close();		
	}
}

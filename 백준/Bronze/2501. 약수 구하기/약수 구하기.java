import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
		int i=1, count=0;;
		
		while(true) {
			//조건 검사
			if(n%i == 0) {
				count++;
			}
			
			//종료 조건
			if(count==k) {
				System.out.print(i);
				break;
			} else if (n==i) {
				System.out.print(0);
				break;
			}
			
			i++;
		}
		
		br.close();
		
	}
}

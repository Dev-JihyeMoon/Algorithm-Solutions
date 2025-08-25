import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] number = new int[9];
		int max=0;
		
		String str = br.readLine();
		
		for(int i=0; i<str.length(); i++) {
			int now = str.charAt(i)-48;
			
			if(now==6||now==9) {
				number[6]++;
			} else {
				number[now]++;
			}
		}
		
		if(number[6] % 2 == 0) {
			number[6] /= 2;
		} else {
			number[6] /= 2;
			number[6]++;
		}
		
		for(int i:number) {
			if(max <i) {
				max = i;
			}
		}
		
		System.out.print(max);
		
		br.close();
		
	}
}

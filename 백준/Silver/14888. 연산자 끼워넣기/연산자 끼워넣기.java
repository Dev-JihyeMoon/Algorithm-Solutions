import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int[] numbers;
	static String[] output;
	static int[] operator = new int[4];
	static int n;
	static int max = -100000000, min = 1000000000;
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		numbers = new int[n];
		output = new String[n-1];
		numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		operator = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		func(0);
		
		System.out.print(max+"\n"+min);
		br.close();
	}
	
	public static void func(int count) {
		if(count == n-1) {
			int temp = numbers[0];
			for(int i=0; i<n-1; i++) {
				switch(output[i]) {
				case"+":
					temp+=numbers[i+1];
					break;
				case"-":
					temp-=numbers[i+1];
					break;
				case"%":
					temp/=numbers[i+1];
					break;
				case"*":
					temp*=numbers[i+1];
					break;
				}
			}
			if(max<temp) {
				max = temp;
			} 
			if(temp<min) {
				min = temp;
			}
			
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(operator[i] != 0) {
				switch(i) {
				case 0:
					output[count] = "+";
					break;
				case 1:
					output[count] = "-";
					break;
				case 2:
					output[count] = "*";
					break;
				case 3:
					output[count] = "%";
					break;
				}
				operator[i]--;
				func(count+1);
				operator[i]++;
			}
		}
	}
}

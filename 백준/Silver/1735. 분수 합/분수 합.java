import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] input2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int output[] = new int[2];
		
		output[1] = input1[1] * input2[1];
		output[0] = (input1[0] * input2[1]) + (input2[0] * input1[1]);
		
		boolean check = false;
		int count = output[0]<output[1]?output[0]:output[1];
		
		while(true) {
			if( (output[0]==1) || (output[1]==1) ) {
				break;
			}
			
			if(count==1) {
				break;
			}
			
			if( (output[0]%count==0) && (output[1]%count==0) ) {
				output[0] /= count;
				output[1] /= count;
				
				count = output[0]<output[1]?output[0]:output[1];
			} else {
				count--;
			}
		}
		
		System.out.print(output[0]+" "+output[1]);
		br.close();
	}
}
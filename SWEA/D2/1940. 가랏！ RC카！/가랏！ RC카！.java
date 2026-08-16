import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int t = Integer.parseInt(br.readLine());
	
		for(int i=1; i<=t; i++) {
			int n = Integer.parseInt(br.readLine());
			int speed = 0;
			int answer = 0;
			
			for(int j=0; j<n; j++) {
				int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				
				if(input[0] == 0) {
					answer += speed;
				} else if(input[0] == 1) {
					speed += input[1];
					answer += speed;
				} else {
					if(speed-input[1] < 0) {
						speed = 0;
					} else {
						speed -= input[1];
						answer += speed;
					}
				}
			}
			
			bw.write("#"+i+" "+answer+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
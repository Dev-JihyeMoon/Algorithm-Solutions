import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<T; i++) {
			float input = Integer.parseInt(br.readLine());
			int[] output = new int[4];
			
			while(input != 0) {
				if(input >= 25) {
					output[0] = (int) (input / 25);
					input %= 25;
				} else if(input >= 10) {
					output[1] = (int) (input/10);
					input %= 10;
				} else if(input >= 05) {
					output[2] = (int) (input/5);
					input %= 5;
				} else {
					output[3] = (int) (input/1);
					input %= 1;
				}
			}
			
			bw.write(output[0]+" "+output[1]+" "+output[2]+" "+output[3]+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}

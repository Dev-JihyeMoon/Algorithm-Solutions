import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int A = input[0], B = input[1], V = input[2];
		
		int count = (V - A) / (A - B);
		
		if((V - A) % (A - B) == 0) {
			count+=1;
		} else {
			count+=2;
		}
		
		System.out.print(count);
		br.close();
	}
}

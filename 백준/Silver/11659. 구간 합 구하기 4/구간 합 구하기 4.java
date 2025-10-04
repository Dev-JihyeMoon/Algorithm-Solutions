import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static int[] original, sumList;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N=input[0], M=input[1];
		
		original = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		sumList = new int[N];
		setPrefixSum(N);

		for(int i=0; i<M; i++) {
			input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int answer =  getAnswer(input[0], input[1]);
			
			bw.write(String.valueOf(answer+"\n"));
		}
		
		bw.close();
		br.close();
	}
	
	public static int getAnswer(int i, int j) {
		if(i==j) {
			return original[i-1];
		} else if(i==1) {
			return sumList[j-1];
		}

		return sumList[j-1]-sumList[i-2];
	}
	
	public static void setPrefixSum(int n) {
		sumList[0] = original[0];
		
		for(int i=1; i<n; i++) {
			sumList[i] = sumList[i-1]+original[i];
		}
		
		return;
	}
}
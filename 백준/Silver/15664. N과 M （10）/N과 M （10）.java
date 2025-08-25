import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class Main {
	static int n, m;
	static int[] arr, output;
	static LinkedHashSet<String> answer;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		n = input[0];
		m = input[1];
		arr = new int[n];
		output = new int[m];
		answer = new LinkedHashSet<>();
		
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);

		func(0, 0);
		
		for(String i:answer) {
			bw.write(i+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	public static void func(int count, int depth) {
		if(count == m) {
			String temp = "";
			for(int i=0; i<m; i++) {
				temp += output[i]+" ";
			}
			answer.add(temp);
			return;
		}
		
		for(int i=depth; i<n; i++) {
			output[count] = arr[i];
			func(count+1, i+1);
		}
	}
}
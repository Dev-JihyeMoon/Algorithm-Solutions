import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class Main {
	static Stack<Integer> arr, answer;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		arr = new Stack<>();
		answer = new Stack<>();
		for(int i=0; i<N; i++) {
			arr.add(input[i]);
		}

		getSolution(N);
		for(int i=0; i<N; i++) {
			bw.write(String.valueOf(answer.pop()+" "));
		}
		
		br.close();
		bw.close();
		
	}
	
	public static void getSolution(int n) {
		Stack<Integer> temp = new Stack<>();
		
		temp.add(0);
		for(int i=0; i<n; i++) {
			int now = arr.pop();
			Integer tem;
			
			while(true) {
				if(temp.isEmpty()){
					answer.add(Integer.valueOf(-1));
					break;
				} 
				
				tem = temp.peek();
				if(now < tem) {
					answer.add(tem);
					break;
				}
				
				temp.pop();
			}
			
			temp.add(now);
		}
		
		return;
	}
}
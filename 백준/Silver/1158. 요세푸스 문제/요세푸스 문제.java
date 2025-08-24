import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int n = input[0], k = input[1];
		
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> answer = new ArrayList<>();

		for(int i=1; i<=n; i++) {
			list.add(i);
		}
		
		int count = k-1, point = 0;
		
		while(!list.isEmpty()) {
			
			if(point==list.size()) {
				point = 0;
			}
			
			if(count==0) {
				count = k-1;
				answer.add(list.get(point));
				list.remove(point);
				continue;
			}
			
			count--;
			point++;
			
		}
		
		System.out.print("<"+answer.get(0));
		answer.remove(0);
		for(int i:answer) {
			System.out.print(", "+i);
		}
		System.out.print(">");
		br.close();
		
	
	}
}

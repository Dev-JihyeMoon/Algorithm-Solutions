import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = input[0], w = input[1], l = input[2]; //n은 다리를 건너는 트럭의 수, w는 다리의 길이, L은 다리의 최대하중
		int[] truck = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		Queue<Integer> wait = new LinkedList<>();
		Queue<Integer> bridge = new LinkedList<>();
		
		for(int i:truck) {
			wait.add(i);
		}
		
		for(int i=0; i<w; i++) {
			bridge.add(0);
		}
		
		int sum = 0, answer = 0;
		
		while(!bridge.isEmpty()) {
			if(wait.isEmpty()) {
				sum-=bridge.poll();
				answer++;
				continue;
			}

			sum-=bridge.poll();
			
			if(sum+wait.peek() <= l) {
				sum+=wait.peek();
				bridge.add(wait.poll());
				answer++;
			} else {
				bridge.add(0);
				answer++;
			}
		}
		
		System.out.print(answer);
		
		br.close();
	}
}

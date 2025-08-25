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
		
		int f = input[0], start = input[1], goal = input[2], up = input[3], down = input[4];
		
		int[] floor = new int[f];
		
		//BFS
		int[] dx = {up, down*-1};
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start-1);
		floor[start-1] = 1;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			
			for(int i=0; i<2; i++) {
				int x = dx[i] + now;
				
				if(x<0||x>=f) {
					continue;
				}
				
				if(floor[x] != 0) {
					continue;
				}
				
				floor[x] = floor[now]+1;
				queue.add(x);				
			}
		}
		
		System.out.print(floor[goal-1]==0?"use the stairs":floor[goal-1]-1);

		br.close();
	}
}
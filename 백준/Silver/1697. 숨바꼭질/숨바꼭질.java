
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = input[0], k = input[1];
		
		int temp;
		if(n==k) {
			System.out.print(0);
			System.exit(0);
		}
		
		if(n<k) {
			temp = k;
		} else {
			temp = n;
		} 
		
		int[] map = new int[temp*2];
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		map[n] = 1;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			int[] point = {now-1, now+1, now*2};
			
			for(int i:point) {
				if(i<0||i>=map.length) {
					continue;
				}
				
				if(map[i] != 0) {
					continue;
				}
				
				map[i] = map[now]+1;
				queue.add(i);
			}
			
			if(map[k] != 0) {
				break;
			}
		}
		
		System.out.print(map[k]-1);
		br.close();
	}
}

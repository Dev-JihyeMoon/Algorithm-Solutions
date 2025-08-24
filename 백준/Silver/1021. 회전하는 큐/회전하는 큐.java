import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = input[0], m = input[1];
		
		LinkedList<Integer> deque = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			deque.offerLast(i);
		}
		
		int[] key = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int count = 0;
		for(int i=0; i<m; i++) {
			while(true) {
				if(deque.peekFirst() == key[i]) {
					deque.pollFirst();
					break;
				}
				
				if(deque.indexOf(key[i]) > deque.size()/2) {
					deque.offerFirst(deque.pollLast());
				} else {
					deque.offerLast(deque.pollFirst());
				}
				
				count++;
			}
		}
		
		System.out.print(count);
		
		br.close();
	}
}
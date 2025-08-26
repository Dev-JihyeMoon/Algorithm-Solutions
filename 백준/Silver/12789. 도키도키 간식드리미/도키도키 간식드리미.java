import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> stack1 = new ArrayDeque<>();
		Deque<Integer> stack2 = new ArrayDeque<>();
		
		String[] input = br.readLine().split(" ");
		boolean check = true;
		//입력
		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(input[i]);
			
			stack1.offer(now);
		}
		
		for(int i=1; i<=N; i++) {
			//System.out.println(stack1 +" "+ stack2);
			//첫번째 대기줄에 순번이 있을 때
			if(stack1.contains(i)) {
				while(true) {
					if(stack1.peek() != i) {
						stack2.push(stack1.pop());
					} else {
						stack1.pop();
						break;
					}
				}
			} 
			else if(stack2.peek() == i) {
				stack2.pop();
			} else {
				check = false;
				break;
			}
		}
		
		if(check) {
			System.out.println("Nice");
		} else {
			System.out.println("Sad");
		}
	}
}

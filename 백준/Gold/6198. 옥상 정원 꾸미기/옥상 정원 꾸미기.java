import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] building = new int[n];
		
		for(int i=0; i<n; i++) {
			building[i] = Integer.parseInt(br.readLine());
		}
		
		long sum = solution(n, building);
		
		System.out.print(sum);
		br.close();
	}
	
	public static long solution(int n, int[] list) {
		Stack<Integer> stack = new Stack<>();
		stack.push(list[0]);
		
		long count = 0;
		
		for(int i=1; i<n; i++) {	
			//자신이 위치한 빌딩보다 높거나 같은 빌딩이 있는 경우
			while(stack.peek() <= list[i]) {
				stack.pop();
				
				if(stack.isEmpty()){
					break;
				}
			}
			
			//높거나 같은 빌딩을 제외한 후 옥상을 확인하는 총 수 카운트
			stack.push(list[i]);
			count+=stack.size()-1;
		}
		
		return count;
	}
}
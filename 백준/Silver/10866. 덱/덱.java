import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Deque<Integer> deque = new ArrayDeque<>();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			String[] command = br.readLine().split(" ");
			
			switch(command[0]) {
			case "push_front":
				deque.offerFirst(Integer.parseInt(command[1]));
				break;
			case "push_back":
				deque.offerLast(Integer.parseInt(command[1]));
				break;
			case "pop_front":
				if(!deque.isEmpty()) {
					bw.write(deque.pollFirst()+"\n");
				} else {
					bw.write("-1"+"\n");
				}
				break;
			case "pop_back":
				if(!deque.isEmpty()) {
					bw.write(deque.pollLast()+"\n");
				} else {
					bw.write("-1"+"\n");
				}
				break;
			case "size":
				bw.write(deque.size()+"\n");
				break;
			case "empty":
				if(deque.isEmpty()) {
					bw.write("1"+"\n");
				} else {
					bw.write("0"+"\n");
				}
				break;
			case "front":
				if(!deque.isEmpty()) {
					bw.write(deque.peekFirst()+"\n");
				} else {
					bw.write("-1"+"\n");
				}
				break;
			case "back":
				if(!deque.isEmpty()) {
					bw.write(deque.peekLast()+"\n");
				} else {
					bw.write("-1"+"\n");
				}
				break;
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
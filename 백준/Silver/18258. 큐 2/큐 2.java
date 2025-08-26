import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		Deque<Integer> queue = new LinkedList<>();
		
		for(int i=0; i<count; i++) {
			String[] input = br.readLine().split(" ");
			
			switch(input[0]) {
			case"push":
				int now = Integer.parseInt(input[1]);
				queue.offerLast(now);
				break;
				
			case"pop":
				if(!queue.isEmpty()) 
					bw.write(queue.poll()+"\n");
				else
					bw.write("-1"+"\n");
				break;
				
			case"size":
				bw.write(queue.size()+"\n");
				break;
				
			case"empty":
				if(!queue.isEmpty())
					bw.write("0"+"\n");
				else
					bw.write("1"+"\n");
				break;
				
			case"front":
				if(!queue.isEmpty()) 
					bw.write(queue.peek()+"\n");
				else
					bw.write("-1"+"\n");
				break;
				
			case"back":
				if(!queue.isEmpty()) 
					bw.write(queue.peekLast()+"\n");
				else
					bw.write("-1"+"\n");
				break;
			}
			//System.out.println(queue);
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			int size = Integer.parseInt(br.readLine());
			int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] goal = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			int answer = move(size, start, goal);
			
			bw.write(answer+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int move(int size, int[] start, int[] goal) {
		int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1}, dy = {-2, -1, 1, 2, 2, 1, -1, -2};
		
		int[][] board = new int[size][size];
		board[start[0]][start[1]] = 1;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int i=0; i<8; i++) {
				int x = now[0]+dx[i];
				int y = now[1]+dy[i];
				
				if(x<0||x>=size||y<0||y>=size) {
					continue;
				} 
				
				if(board[x][y] != 0) {
					continue;
				}
				
				board[x][y] = board[now[0]][now[1]] + 1;
				int[] nextPoint = {x, y};
				queue.add(nextPoint);
			}
		}
		
		return board[goal[0]][goal[1]]-1;
		
	}
}

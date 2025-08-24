import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			int[][] board = new int[input[0]][input[1]];
			
			for(int j=0; j<input[2]; j++) {
				int[] point = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				
				board[point[0]][point[1]] = 1;
			}
			
			int output = search(board);
			
			bw.write(output+"\n");
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int search(int[][] board) {
		int count = 0;
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				if(board[i][j] == 1) {
					board = bfs(board, i, j);
					count++;
				}
			}
		}
		
		return count;
	}
	
	public static int[][] bfs(int[][] board, int x, int y){
		int dx[] = {1, 0, -1, 0}, dy[] = {0, 1, 0, -1};
		Queue<int[]> queue = new LinkedList<>();
		
		int[] start = {x, y};
		board[x][y] = 2;
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nx = now[0]+dx[i];
				int ny = now[1]+dy[i];
				
				if(nx<0 || nx>=board.length || ny<0 || ny>=board[0].length) {
					continue;
				} 
				
				if(board[nx][ny] != 1) {
					continue;
				}
				
				board[nx][ny] = 2;
				int[] nextPoint = {nx, ny};
				queue.add(nextPoint);
			}
		}
		
		return board;
		
	}
	
}

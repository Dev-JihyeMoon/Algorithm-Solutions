
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int maxSize = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = size[0], m = size[1];
		
		int[][] board = new int[n][m];
		int count = 0;
		
		for(int i=0; i<n; i++) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(board[i][j] == 1) {
					int[] point = {i, j};
					board = BFS(board,  point);
					count++;
				}
			}
		}
		
		System.out.print(count+"\n"+maxSize);
		br.close();
		
	}
	
	public static int[][] BFS(int[][] board, int[] point){
		int dx[] = {1, 0, -1, 0}, dy[] = {0, 1, 0, -1};
		Queue<int[]> queue = new LinkedList<>();
		queue.add(point);
		
		board[point[0]][point[1]] = 0;
		int temp = 1; // 시작 좌표는 이미 1이므로 검사 완료로 가정
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int i=0; i<4; i++) {
				int x = now[0]+dx[i];
				int y = now[1]+dy[i];
				
				if(x<0 || x>=board.length || y<0 || y>=board[0].length) {
					continue;
				}
				
				if(board[x][y] != 1) {
					continue;
				}
				
				board[x][y] = 0;
				temp++;
				int nextPoint[] = {x, y};
				queue.add(nextPoint);
			}
		}
		
		if(maxSize < temp) {
			maxSize = temp;
		}
		
		return board;
	}
}

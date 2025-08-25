import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n, m;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		n = size[0];
		m = size[1];
		int[][] map = new int[n][m];
		int[] start = new int[2];
		
		for(int i=0; i<n; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
			for(int j=0; j<map[i].length; j++) {
				if(map[i][j] == 2) {
					start[0] = i;
					start[1] = j;
				}
			}
		
		}

		bfs(map, start);
		
		br.close();
	}
	
	public static void bfs(int[][] map, int[] start) {
		int dx[] = {1, 0, -1, 0}, dy[] = {0, 1, 0, -1};
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] mapCheck = new boolean[n][m];
		
		map[start[0]][start[1]] = 0;
		mapCheck[start[0]][start[1]] = true;
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int i=0; i<4; i++) {
				int x = now[0]+dx[i];
				int y = now[1]+dy[i];
				
				if(x<0||x>=n||y<0||y>=m) {
					continue;
				}
				
				if(mapCheck[x][y] == true || map[x][y] == 0) {
					mapCheck[x][y] = true;
					continue;
				}
				
				map[x][y] = map[now[0]][now[1]] + 1;
				mapCheck[x][y] = true;
				int[] nextPoint = new int[2];
				nextPoint[0] = x;
				nextPoint[1] = y;
				queue.add(nextPoint);
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==1 && mapCheck[i][j]==false) {
					System.out.print("-1 ");
				} else {
					System.out.print(map[i][j]+" ");
				}
			}
			
			System.out.print("\n");
		}
		return;
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int[][] maze = new int[size[0]][size[1]];
		int[][] answer = new int[size[0]][size[1]];

		for(int i=0; i<size[0]; i++) {
			String now = br.readLine();
			
			for(int j=0; j<size[1]; j++) {
				maze[i][j] = Integer.parseInt(String.valueOf(now.charAt(j)));
			}
			
		}

		
		
		//BFS
		Queue<int[]> queue = new LinkedList<>();
		int dx[] = {1, 0, -1, 0}, dy[] = {0, 1, 0, -1};
		
		int temp[] = {0, 0};
		queue.add(temp);
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			if(now[0] == size[0] && now[1] == size[1]) {
				break;
			}
			
			for(int i=0; i<4; i++) {
				int x=now[0]+dx[i];
				int y=now[1]+dy[i];
				
				if(x<0 || x>=size[0] || y<0 || y>=size[1]) {
					continue;
				} 

				if(maze[x][y]!=1) {
					continue;
				}
				
				int[] nextPoint = {x, y};
				queue.add(nextPoint);
				maze[x][y] = 0;
				answer[x][y] = answer[now[0]][now[1]] + 1;
				
			}
			
			
		}
		
		System.out.print(answer[size[0]-1][size[1]-1] + 1);
		
	}
}

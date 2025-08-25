import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int count = 0;
	static ArrayList<Integer> size = new ArrayList<>();
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			
			for(int j=0; j<input.length(); j++) {
				map[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]==1) {
					map = bfs(map, i, j);
					count++;
				}
			}
		}
		
		System.out.println(count);
		size.sort(Comparator.naturalOrder());
		for(Integer i:size) {
			System.out.println(i);
		}
		
		br.close();
	}
	
	public static int[][] bfs(int[][] map, int sx, int sy){

		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		Queue<int[]> queue = new LinkedList<>();
		
		map[sx][sy] = 0;
		int temp = 1;
		int[] start = {sx, sy};
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int i=0; i<4; i++) {
				int x = now[0]+dx[i];
				int y = now[1]+dy[i];
				
				if(x<0||x>=n||y<0||y>=n) {
					continue;
				}
				
				if(map[x][y] == 0) {
					continue;
				}
				
				temp++;
				map[x][y] = 0;
				int[] nextPoint = {x, y};
				queue.add(nextPoint);
				
			}
		}
		size.add(temp);
		return map;
	}
	
}
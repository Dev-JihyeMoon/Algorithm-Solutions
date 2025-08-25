import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());
		
		char[][] draw1 = new char[n][n]; //색약이 아닌 사람의 시야
		char[][] draw2 = new char[n][n]; //색약의 시야
		
		for(int i=0; i<n; i++) {
			String input = br.readLine();

			for(int j=0; j<n; j++) {
				draw1[i][j] = input.charAt(j);
				if(input.charAt(j) != 'B') {
					draw2[i][j] = 'R';
				} else {
					draw2[i][j] = input.charAt(j);
				}
			}
		}
		int normal = countDraw(draw1);
		int colorWeakness = countDraw(draw2);
		
		System.out.print(normal+" "+colorWeakness);
		br.close();
	}
	
	public static int countDraw(char[][] draw) {		
		int count = 0;
		for(int i=0; i<draw.length; i++) {
			for(int j=0; j<draw.length; j++) {
				if(draw[i][j] != '0') {
					draw = BFS(draw, i, j);
					count++;
				}
			}

			
		}
		
		return count;
	}
	
	public static char[][] BFS(char[][] draw, int x, int y){
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		Queue<int[]> queue = new LinkedList<>();
		
		int[] start = {x, y};
		char color = draw[x][y];
		draw[x][y] = '0';

		queue.add(start);
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nx = now[0]+dx[i];
				int ny = now[1]+dy[i];
				
				if(nx<0 || nx>=draw.length || ny<0 ||ny>=draw.length) {
					continue;
				}
				
				if(draw[nx][ny] != color) {
					continue;
				}
				
				draw[nx][ny] = '0';
				int[] nextPoint = {nx, ny};
				queue.add(nextPoint);
			}
		}
		
		return draw;
	}
}
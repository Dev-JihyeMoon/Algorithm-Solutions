import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[][] map; 
	static int count = 0;
	
	final static int cleaning = 2;
	final static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		map = new int[size[0]][size[1]];
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		for(int i=0; i<size[0]; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		getSolution(input[0], input[1], input[2]);
		
		System.out.print(String.valueOf(count));
		br.close();
		
	}
	
	//map[][] => 0: 청소하지 않은 칸, 1: 벽, 2(cleaning): 청소한 칸
	
	public static void getSolution(int x, int y, int d) {
		if(map[x][y] == 0) {
			map[x][y] = cleaning;
			count++;
		}
		
		int nx, ny, nd=d;
		
		while(true) {
			nd = (nd-1)==(-1) ? 3 : (nd-1);
			nx = dx[nd]+x;
			ny = dy[nd]+y;
			
			//반시계 방향 90도 회전한 칸이 청소를 안한 칸인 경우 전진처리. 
			if(map[nx][ny] == 0) break;
			
			//4방향을 다 조사한 경우
			if(nd == d) {
				//후진처리.
				nx = x - dx[nd];
				ny = y - dy[nd];
				
				//후진했으나 벽인 경우 탐색 종료
				if(map[nx][ny] == 1) return;
				
				//벽이 아닌 경우 후진 처리. 
				break;
			}
		}
		
		getSolution(nx, ny, nd);
	}
}
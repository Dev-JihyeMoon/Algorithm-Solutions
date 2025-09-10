import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	
	
	final static int[] dx = {1, 0, -1, 0};
	final static int[] dy = {0, 1, 0, -1};
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	
		N = input[0];
		M = input[1];
		map = new int[N][M];
		
		//빙산 입력
		for(int i=0; i<N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		int time = 0;
		while(true) {
			int count = 0;
			visited = new boolean[N][M];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]!=0 && !visited[i][j]) {
						count++;
						BFS(i, j);
					}
				}
			}
			
			if(count == 0) {
				time = 0;
				break;
			} 
			if(count >= 2) {
				break;
			}
			
			time++;
		}
		
		System.out.print(String.valueOf(time));
		br.close();
	}
	
	public static void BFS(int x, int y) {
		Queue<int[]> point = new LinkedList<>();
		point.add(new int[] {x, y});
		
		visited[x][y] = true;
		
		//빙산 주변 바다(0)의 개수 확인
		while(!point.isEmpty()) {
			int[] now = point.poll();
			
			int count = 0;
			for(int i=0; i<4; i++) {
				int nx = now[0]+dx[i];
				int ny = now[1]+dy[i];
				
				if(nx<0 || ny<0 || nx>=N || ny>M) continue;
				if(visited[nx][ny]) continue;
				
				// 검사 범위가 바다일 경우
				if(map[nx][ny]==0) { 
					count++; 
					continue;
				} 
				
				visited[nx][ny] = true; 
				point.add(new int[] {nx, ny});
			}
			int temp = map[now[0]][now[1]]-count;
			map[now[0]][now[1]] = temp>=0?temp:0;
		}
	}
}

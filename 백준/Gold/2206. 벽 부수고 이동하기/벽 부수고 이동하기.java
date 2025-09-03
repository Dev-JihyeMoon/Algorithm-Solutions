import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {	
	static int N, M;
	static char[][] map;
	
	final static int[] dx = {1, 0, -1, 0};
	final static int[] dy = {0, 1, 0, -1};
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		N = size[0];
		M = size[1];
		map = new char[N][M];
		
		for(int i=0; i<N; i++) {
			String temp = br.readLine();
			
			for(int j=0; j<M; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		
		System.out.print(String.valueOf(getEscape()));
		br.close();
	}
	
	public static int getEscape() {
		//만일 맵이 1x1일 경우
		if(N==1 && M==1) 
			return 1;
		
		int[][][] route = new int[N][M][2];
		route[0][0][0] = route[0][0][1] = 1;
		
		Queue<int[]> point = new LinkedList<>();
		point.add(new int[] {0, 0, 0}); // 시작 좌표, 벽 통과 여부
		
		while(!point.isEmpty()) {
			int[] now = point.poll();
			
			for(int i=0; i<4; i++) {
				int nx = now[0]+dx[i];
				int ny = now[1]+dy[i];

				if(nx==N-1 && ny==M-1) {
					if(now[2]==0) return route[now[0]][now[1]][0]+1;
					else return route[now[0]][now[1]][1]+1;
				}
				
				//검사 범위가 배열을 벗어났을 때
				if(nx<0 || ny<0 || nx>=N || ny>=M) continue; 
				
				if(map[nx][ny]=='0') { //벽이 아닌 경우
					if(route[nx][ny][now[2]] == 0) {
						point.add(new int[] {nx, ny, now[2]});
						route[nx][ny][now[2]] = route[now[0]][now[1]][now[2]]+1;
					}
				} else if(map[nx][ny] == '1') { //벽인 경우
					//벽을 부순 적이 없으며, 벽을 부수고 방문한 적이 없을 경우
					if(now[2] == 0 && route[nx][ny][1] == 0) { 
						point.add(new int[] {nx, ny, 1});
						route[nx][ny][1] = route[now[0]][now[1]][now[2]]+1;
					}
				}
			}
		}
		
		return -1;
	}
}
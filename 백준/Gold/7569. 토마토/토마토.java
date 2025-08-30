import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[][][] box;
	static boolean[][][] visit;
	
	static int m, n, h;
	static final int[] dx = {1, 0, -1, 0, 0, 0};
	static final int[] dy = {0, 1, 0, -1, 0, 0};
	static final int[] dz = {0, 0, 0, 0, -1, 1};
	static Queue<int[]> point = new LinkedList<>();

	static int unripeCount = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		m = size[0];
		n = size[1];
		h = size[2];
		
		box  = new int[h][n][m];
		visit = new boolean[h][n][m];
		
		//토마토 상자 세팅
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				box[i][j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				
				//BFS 시작 좌표 세팅
				for(int k=0; k<m; k++) {
					if(box[i][j][k] == 1) {
						point.add(new int[]{i, j, k});
					} else if(box[i][j][k] == 0) {
						unripeCount++;
					}
				}
			}
		}
		
		//토마토가 모두 익지 못하거나(-1) 토마토가 모두 익어있을 경우(0) 예외 처리
		if(point.isEmpty()) {
			System.out.print("-1");
			return;
		} else if(unripeCount == 0) {
			System.out.print("0");
			return;
		}
		
		int output = 0;
		//토마토가 익는 기간 계산, BFS 
		while(!point.isEmpty()) {
			int[] now = point.poll();
			int temp = box[now[0]][now[1]][now[2]] + 1;
			
			for(int i=0; i<6; i++) {
				int nowX = now[1]+dx[i];
				int nowY = now[2]+dy[i];
				int nowZ = now[0]+dz[i];
				
				//x, y, z가 배열 범위를 벗어났는지 확인
				if(nowZ<0 || nowX<0 || nowY<0) 
					continue;
				if(nowZ>=h || nowX>=n || nowY>=m)	
					continue;

				//현재 위치가 '익지 않은 토마토'칸인지 확인
				if(box[nowZ][nowX][nowY] != 0) {
					continue;
				}
				
				unripeCount--; //남은 덜익은 토마토
				box[nowZ][nowX][nowY] = box[now[0]][now[1]][now[2]] + 1; //토마토가 익기까지 걸린 시간
				output = box[nowZ][nowX][nowY]-1; 
				point.add(new int[]{nowZ, nowX, nowY}); //다음 검사 범위 지정
			}
		}
		
		
		//출력
		if(unripeCount==0) {
			System.out.println(output);
		} else {
			System.out.print("-1");
		}
		
		br.close();
		return;
	}
}
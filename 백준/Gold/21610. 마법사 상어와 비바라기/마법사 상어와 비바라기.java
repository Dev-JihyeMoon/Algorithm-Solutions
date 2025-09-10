import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] cloud;
	
	static Queue<int[]> point = new LinkedList<>();
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		N = input[0];
		M = input[1];
		map = new int[N][N];
		cloud = new boolean[N][N];
		
		//맵 입력
		for(int i=0; i<N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}	
		
		//비바라기 수행
		for(int i=0; i<M; i++) {
			input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			//구름 생성
			if(i==0) {
				setCloud(N-1);
			} 
			setMove(input[0]-1, input[1]);  //구름 이동 및 물의 양 증가
			setBugWater(); //물복사버그
			setCloud();
		}
		
		int answer = 0;
		for(int i=0; i<N; i++) {
			for(int j:map[i]) answer+=j;
		}
		
		System.out.print(String.valueOf(answer));
		br.close();
	}
	
	public static void setCloud(int n) {
		int[] x = {0, 0, -1, -1};
		int[] y = {0, 1, 0, 1};
		
		for(int i=0; i<4; i++) {
			cloud[n+x[i]][y[i]] = true;
		}
	}
	
	public static void setCloud() {
		boolean[][] temp = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!cloud[i][j] && map[i][j] >= 2) {
					map[i][j] -= 2;
					temp[i][j] = true;
				}
			}
		}
		cloud = temp;
	}
	
	public static void setMove(int d, int s) {
		int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
		int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
		//구름 이동
		boolean[][] temp = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(cloud[i][j]) {					
					int nx = ( (((dx[d]*s)+i) % N) + N ) % N;
					int ny = ( (((dy[d]*s)+j) % N) + N ) % N;
					
					temp[nx][ny] = true;
					map[nx][ny]++; //비로 인한 물 증가
					point.add(new int[] {nx, ny});
				}
			}
		}
		cloud = temp;
	}
	
	public static void setBugWater() {
		int[] dx = {-1, -1, 1, 1};
		int[] dy = {-1, 1, -1, 1};
		
		while(!point.isEmpty()) {
			int[] now = point.poll();
			
			for(int i=0; i<4; i++) {
				int nx = dx[i]+now[0];
				int ny = dy[i]+now[1];
				
				if(nx<0||ny<0||nx>=N||ny>=N) continue;
				if(map[nx][ny] == 0) continue;
				
				map[now[0]][now[1]]++;
			}
		}
	}
}

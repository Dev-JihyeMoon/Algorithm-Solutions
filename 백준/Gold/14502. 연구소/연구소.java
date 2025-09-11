import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, M;
	static int[][] map;
	static int answer=0;
	static Queue<int[]> virusPoint = new LinkedList<>();
	
	final static int[] dx = {1, 0, -1, 0};
	final static int[] dy = {0, 1, 0, -1};
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		N = input[0];
		M = input[1];
		map = new int[N][M];
		
		//map 세팅 + 시작점(바이러스) 저장
		for(int i=0; i<N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
			for(int j=0; j<M; j++) {
				if(map[i][j] == 2) {
					virusPoint.add(new int[] {i, j});
				}
			}
		}
		
		backTracking(0);
		
		System.out.print(String.valueOf(answer));		
		br.close();
	}
	
	//백트레킹으로 생성할 수 있는 모든 벽의 경우의 수 시도
	public static void backTracking(int depth) {
		if(depth==3) {
			//앝은 복사(Shallow Copy)로 인한 원본 훼손을 막기 위한 배열 깊은 복사(Deep Copy)
			int[][] temp = new int[N][M];
			for(int i=0; i<N; i++) {
				temp[i] = map[i].clone();
			}	
			
			//안전 구역이 가장 큰 값만 저장
			answer = Math.max(answer, countSafe(BFS(temp)));
			return;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1; //벽 세움
					backTracking(depth+1);
					map[i][j] = 0; //벽 해제
				}
			}
		}
	}
	
	//벽 생성 후 바이러스 도포
	public static int[][] BFS(int[][] copyMap){
		Queue<int[]> point = new LinkedList<>(virusPoint);
		
		while(!point.isEmpty()) {
			int[] now = point.poll();
			int x = now[0], y = now[1];
			
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
				if(copyMap[nx][ny] != 0) continue;
				
				copyMap[nx][ny] = 2;
				point.add(new int[] {nx, ny});
			}
		}
		
		return copyMap;
	}
	
	//안전구역의 크기 도출
	public static int countSafe(int[][] copyMap) {
		int count=0;
		
		for(int i=0; i<N; i++) {
			for(int j:copyMap[i]) {
				if(j==0) count++;
			}
		}
		
		return count;
	}
}
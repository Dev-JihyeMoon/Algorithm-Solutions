import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	static char[][] building; // 입력받는 빌딩의 지도, 이 배열에 불이 확산되는 과정도 기록
	static int[][] escapeRoute; // 상근이의 탈출 거리 기록
	static int w, h;
	
	static final int[] dx = {1, 0, -1, 0};
	static final int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			w = size[0];
			h = size[1];
			building = new char[h][w];
			escapeRoute = new int[h][w];
			
			Deque<int[]> point = new LinkedList<>();
			
			//빌딩 지도 세팅
			for(int j=0; j<h; j++) {
				String temp = br.readLine();
				
				for(int k=0; k<w; k++) {
					building[j][k] = temp.charAt(k);
					
					//BFS 시작 위치 세팅(상근의 위치, 불의 위치)
					if(building[j][k] == '@') {
						point.addFirst(new int[] {j, k, 0});
					} else if(building[j][k] == '*') {
						point.add(new int[] {j, k, 1});
					}
				}
			}
			
			bw.write(getEscape(point)+"\n");	
			
		}
		
		bw.close();
		br.close();
	}
	
	public static String getEscape(Deque<int[]> point) {
		int[] now = point.peekFirst();
		escapeRoute[now[0]][now[1]] = 1;
		
		while(!point.isEmpty()) {
			now = point.pollLast();
			
			for(int i=0; i<4; i++) {
				int nowX = now[0]+dx[i];
				int nowY = now[1]+dy[i];
				int mode = now[2]; // 0:상근, 1:불
				
				if(nowX<0 || nowY<0 || nowX >= h || nowY >= w) {
					//탈출 성공. 최단 거리 반환.
					if(mode == 0) {
						return String.valueOf(escapeRoute[now[0]][now[1]]);
					}
					continue;
				}
				
				if(building[nowX][nowY] != '.' || escapeRoute[nowX][nowY] != 0) {
					continue;
				}
				
				if(mode==0) {
					escapeRoute[nowX][nowY] = escapeRoute[now[0]][now[1]]+1;
				} else if(mode==1) {
					building[nowX][nowY] = '*';
				}
				
				point.addFirst(new int[] {nowX, nowY, mode});
			}
		}
		
		//마지막까지 탈출을 못한 경우 
		return "IMPOSSIBLE";
	}
}

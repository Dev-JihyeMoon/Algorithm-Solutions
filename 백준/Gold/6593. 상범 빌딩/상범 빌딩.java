import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int L, R, C;
	static char[][][] building;
	
	final static int[] dx = {1, 0, -1, 0, 0, 0};
	final static int[] dy = {0, 1, 0, -1, 0, 0};
	final static int[] dz = {0, 0, 0, 0, -1, 1};
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			String input = br.readLine();
			if(input.equals("0 0 0")) {
				break;
			}
			int[] size = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
			
			L = size[0];
			R = size[1];
			C = size[2];
			building = new char[L][R][C];
			
			int[] start = null;
			for(int i=0; i<L; i++) {
				for(int j=0; j<R; j++) {
					String temp = br.readLine();
					
					for(int k=0; k<C; k++) {
						building[i][j][k] = temp.charAt(k);
						
						if(building[i][j][k] == 'S')
							start = new int[] {i, j, k};
					}
				}
				br.readLine();
			}	
			
			bw.write(getEscape(start)+"\n");
		}
		
		bw.close();
		br.close();
	}
	
	public static String getEscape(int[] start) {
		Queue<int[]> point = new LinkedList<>();
		int[][][] route = new int[L][R][C];
		point.add(start);
		
		route[start[0]][start[1]][start[2]] = building[start[0]][start[1]][start[2]] = 0;
		
		while(!point.isEmpty()) {
			int[] now = point.poll();
			
			for(int i=0; i<6; i++) {
				int nx = now[1]+dx[i];
				int ny = now[2]+dy[i];
				int nz = now[0]+dz[i];
				
				if(nx <0 || ny <0 || nz <0) continue;
				if(nx >= R || ny >= C || nz >= L) continue;
				
				if(building[nz][nx][ny] != '.' || route[nz][nx][ny] != 0) {
					//출구에 도착했을 경우
					if(building[nz][nx][ny] == 'E') {
						return "Escaped in "+(route[now[0]][now[1]][now[2]]+1)+" minute(s).";
					}
					continue;
				}
				
				route[nz][nx][ny] = route[now[0]][now[1]][now[2]]+1; 
				point.add(new int[] {nz, nx, ny});
			}
		}
		
		//끝까지 탈출하지 못했을 경우
		return "Trapped!";
	}
}

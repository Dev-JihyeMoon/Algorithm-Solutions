import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int N; 
	public static int[][] map;
	public static int[] pass;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		map = new int[N][N];
		pass = new int[N];
		
		for(int i=0; i<N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
	
		//이동 가능한 도시끼리 표시
		int count = 1;
		for(int i=0; i<N; i++) {
			if(pass[i] == 0) {
				getConnect(count++, i);
			}
		}
		
		//여행 계획 도시 정리
		int[] plan = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		plan = Arrays.stream(plan).distinct().toArray(); //중복제거

		//방문 가능한 도시인지 확인
		String answer = "YES";
		if(plan.length!=1) {
			int temp = pass[plan[0]-1];
			for(int i:plan) {
				int now = pass[i-1];
				if(now==0||now!=temp) {
					answer = "NO";
					break;
				}
			}
		}
		System.out.print(answer);
		br.close();
		
	}
	
	public static void getConnect(int count, int x) {
		for(int j=0; j<N; j++) {
			if(map[x][j]==1 && pass[j]==0) {
				pass[j] = count;
				getConnect(count, j);
			}
		}
		
	}
}
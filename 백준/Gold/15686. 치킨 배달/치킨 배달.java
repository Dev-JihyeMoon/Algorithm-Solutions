import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static int N, M, answer = Integer.MAX_VALUE;
	static boolean[] isVisited;
	static ArrayList<int[]> home = new ArrayList<>();
	static ArrayList<int[]> chicken = new ArrayList<>();
	static ArrayList<int[]> select = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = input[0];
		M = input[1];
		
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) {
					home.add(new int[] {i, j});
				} else if(map[i][j] == 2) {
					chicken.add(new int[] {i, j});
				}
			}
		}
		
		isVisited = new boolean[chicken.size()];
		backTracking(0, 0);
		System.out.print(String.valueOf(answer));
		br.close();
	}
	
	public static void backTracking(int depth, int start) {
		if(depth == M) {
			answer = Math.min(answer, getDistance());
			return;
		}
		
		//모든 치킨집 탐색
		for(int i=start; i<chicken.size(); i++) {
			if(!isVisited[i]) {
				isVisited[i] = true;
				select.add(chicken.get(i));
				backTracking(depth+1, i+1);
				//탐색이 끝난 치킨집 제거
				select.remove(select.size()-1); 
				isVisited[i] = false;
			}
		}
	}
	
	public static int getDistance() {
		int sum = 0;
		
		for(int[] h : home) {
			int min = 50*50;
			
			for(int[] s : select) {
				int temp = Math.abs(h[0]-s[0]) + Math.abs(h[1]-s[1]);
				min = Math.min(temp, min);
			}
			
			sum+=min;
		}
		
		return sum;
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static boolean[][] map;
	static boolean[] isVisited;
	static int N, count=0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		map = new boolean[N][N];
		isVisited = new boolean[N];
		
		for(int i=0; i<M; i++) {
			int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int x = temp[0]-1, y = temp[1]-1;
			
			if(map[x][y]==false) {
				map[x][y] = map[y][x] = true;
			}
		}
		
		getSolution(0);
		
		System.out.print(String.valueOf(count));
		br.close();
	}
	
	public static void getSolution(int n) {
		if(isVisited[n] == true) {
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(map[n][i] == true && isVisited[i] == false) {
				count++;
				isVisited[n] = true;
				getSolution(i);
				isVisited[i] = true;
			}
		}
		
		return;
	}
}
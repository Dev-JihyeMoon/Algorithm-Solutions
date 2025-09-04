import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	static int[] map = new int[200001];
	static boolean[] visited = new boolean[200001];
	static Stack<int[]> route = new Stack<>();
	static int N, K;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		N = input[0];
		K = input[1];
		
		if(N==K) {
			System.out.print("0"+"\n"+K);
		} else {
			System.out.println(getBFS()); 
			System.out.println(getRoute()); 
		}

		br.close();
	}
	
	public static int getBFS() {		
		map[N] = 0;
		visited[N] = true;

		Queue<Integer> point = new LinkedList<>();
		point.add(Integer.valueOf(N));
		
		while(!point.isEmpty()) {
			int now  = point.poll().intValue();
			
			int[] move = {now*2, now-1, now+1};
			for(int i=0; i<3; i++) {
				if(move[i] < 0 || move[i] > 200000) continue; //검사 범위를 벗어나면 예외처리
				if(visited[move[i]] == true) continue; //이미 방문했던 곳이면 예외처리
				
				map[move[i]] = map[now]+1; 
				visited[move[i]] = true;
				point.add(Integer.valueOf(move[i]));
				route.add(new int[] {move[i], now});
				
				//목적지에 도달했을 경우
				if(move[i] == K) return map[move[i]];
			}
		}

		return map[K];
	}
	
	public static String getRoute() {
		StringBuffer st = new StringBuffer();
		
		int point = K;
		int[] now;
		
		while(!route.isEmpty()) {
			now = route.pop();
			
			if(now[0] == point) {
				st.insert(0, String.valueOf(point+" "));
				point = now[1];
				
				if(point==N) {
					st.insert(0, String.valueOf(point+" "));
					break;
				}
			}
		}
		
		return st.toString();
	}
}
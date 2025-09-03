import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {	
	static int[] map = new int[200001];
	static boolean[] visited = new boolean[200001];
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int N = input[0];
		int K = input[1];
		
		if(N==K || N*2 == K) 
			System.out.print("0");
		else 
			System.out.print(getBFS(N, K));
		
		br.close();
	}
	
	public static int getBFS(int start, int end) {		
		map[start] = 0;
		visited[start] = true;
		
		Queue<Integer> point = new LinkedList<>();
		point.add(Integer.valueOf(start));
		
		while(!point.isEmpty()) {
			int now  = point.poll().intValue();
			
			//목적지에 도달했을 경우
			if(now == end) return map[now];
			
			int[] move = {now*2, now-1, now+1};
			for(int i=0; i<3; i++) {
				if(move[i] < 0 || move[i] > 200000) continue; //검사 범위를 벗어나면 예외처리
				if(visited[move[i]] == true) continue; //이미 방문했던 곳이면 예외처리
				
				//순간이동 제외 1초씩 기록
				if(i!=0) { 
					map[move[i]] = map[now]+1; 
				} else {
					map[move[i]] = map[now];
				}

				visited[move[i]] = true;
				point.add(Integer.valueOf(move[i]));
			}
		}

		return map[end];
	}
}

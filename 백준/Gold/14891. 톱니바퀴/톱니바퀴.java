import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static boolean[][] cogwheel;
	static int[] cogwheelNum;
	static int[] dx = {-1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cogwheel = new boolean[4][8];
		cogwheelNum = new int[4];
		
		for(int i=0; i<4; i++) {
			String input = br.readLine();
			
			for(int j=0; j<8; j++) {
				if(input.charAt(j) == '1') {
					cogwheel[i][j] = true;
				}
			}
		}
		
		int t = Integer.parseInt(br.readLine());
		int[] move; //move[0]=톱니바퀴 번호, move[1]=방향
		for(int i=0; i<t; i++) {
			move = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			int now = move[0]-1, d = move[1]*-1;
			
			getMove(now, d);
		}
		
		System.out.print(String.valueOf(getScore()));
		br.close();
		
	}
	
	public static int getScore() {
		int output = 0;
		
		for(int i=0; i<4; i++) {
			int num = cogwheelNum[i];
			
			if(cogwheel[i][num]) {
				output+=Math.pow(2, i);
			}
		}
		
		return output;
	}
	
	public static void getMove(int start, int direction) {
		int[] output = new int[4];
		boolean[] isVisited = new boolean[4];
		Queue<int[]> point = new LinkedList<>();
		
		isVisited[start] = true;
		output[start] += direction;
		point.add(new int[] {start, direction*-1});
		
		while(!point.isEmpty()) {
			int[] now = point.poll();
			
			for(int i=0; i<2; i++) {
				int next = dx[i] + now[0];
				
				//범위 이탈 & 방문했던 바퀴 가지치기
				if(next < 0 || 3 < next) continue;
				if(isVisited[next]) continue;
				
				//방향에 따른 바퀴 세팅
				int nextCog = cogwheelNum[next], nowCog = cogwheelNum[now[0]];
				if(dx[i] == 1) {
					nextCog = nextCog-2 < 0 ? (nextCog-2)+8 : nextCog-2;		//오른쪽
					nowCog = nowCog+2 >= 8 ? (nowCog+2)-8 : nowCog+2;		//왼쪽
				} else {
					nowCog = nowCog-2<0 ?(nowCog-2)+8:nowCog-2;				//오른쪽
					nextCog = nextCog+2 >= 8 ? (nextCog+2)-8 : nextCog+2;	//왼쪽
				}
				
				//비교
				if(cogwheel[now[0]][nowCog] != cogwheel[next][nextCog]) {
					output[next] += now[1];
					point.add(new int[] {next, now[1]*-1});
				}
				
			}
			
			isVisited[now[0]] = true;
		}
		
		for(int i=0; i<4; i++) {
			if(output[i] == 0) 
				continue;
			
			cogwheelNum[i]+=output[i];
			
			if(cogwheelNum[i] == -1) cogwheelNum[i] = 7;
			else if(cogwheelNum[i] == 8) cogwheelNum[i] = 0;
		}
	}	
}
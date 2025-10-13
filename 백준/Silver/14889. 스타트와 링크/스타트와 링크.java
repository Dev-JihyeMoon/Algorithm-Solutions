import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	static int N, valueS=0, valueL=0, answer=101;
	static boolean[] isTeam;
	static int[] member = new int[2];
	static int[][] arr;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		isTeam = new boolean[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		//팀 세팅
		isTeam[0] = true;
		setTeam(1, 1);
		
		System.out.print(answer);
		br.close();
		
	}
	
	public static void setTeam(int start, int depth) {
		if(depth == N/2) {
			if(answer == 0) return;
			
			//System.out.println(Arrays.toString(isTeam));
			ArrayList<Integer> teamS = new ArrayList<>();
			ArrayList<Integer> teamL = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				if(isTeam[i]) {
					teamS.add(i);
				} else {
					teamL.add(i);
				}
			}
			
			getScore(teamS.stream().mapToInt(i->i).toArray(), 'S', 0, 0);
			getScore(teamL.stream().mapToInt(i->i).toArray(), 'L', 0, 0);
			
			if(Math.abs(valueS-valueL) < answer) {
				answer = Math.abs(valueS-valueL);
			}
			
			valueS = valueL = 0;
			return;
		}
		
		for(int i=start; i<N; i++) {
			isTeam[i] = true;
			setTeam(i+1, depth+1);
			isTeam[i] = false;
		}
	}
	
	public static void getScore(int[] teamArr, char mode, int start, int depth) {
		if(depth == 2) {
			//System.out.println(String.valueOf("Team: "+Arrays.toString(value)));
			int s1 = member[0], s2 = member[1];
			
			if(mode == 'S') {
				valueS += arr[s1][s2] + arr[s2][s1];
			} else {
				valueL += arr[s1][s2] + arr[s2][s1];
			}
			
			return;
		}
		
		for(int i=start; i<teamArr.length; i++) {
			member[depth] = teamArr[i];
			getScore(teamArr, mode, i+1, depth+1);
		}
	}
	
}
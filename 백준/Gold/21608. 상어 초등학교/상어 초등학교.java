import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Main {
	static int N, T;
	static int[][] room, emptyCount, Distance;

	static boolean[] isSeat;
	static int[][] isSeatPoint;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		T = N*N;
		int[][] students = new int[T][5];
		room = new int[N][N];
		emptyCount = new int[N][N];
		isSeat = new boolean[T+1];
		isSeatPoint = new int[T+1][2];
		
		for(int i=0; i<T; i++) {
			students[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		getEmpty(students[0][0]);
		setting(students[0][0], 1, 1);
		
		//자리 배치
		for(int i=1; i<T; i++) {
			Distance = new int[N][N];
			ArrayList<int[]> list = getLike(Arrays.copyOfRange(students[i], 1, 5));
			
			if(list.size() != 1) {
				list = new ArrayList<>(getMax(list, Distance));
			} 
			if(list.size() != 1) {
				list = new ArrayList<>(getMax(list, emptyCount));
			}
			
			list.sort((a, b) -> {
			    if (a[0] != b[0]) 
			    	return Integer.compare(a[0], b[0]); // 행 우선
			    	return Integer.compare(a[1], b[1]); // 행 같으면 열
			});
						
			setting(students[i][0], list.get(0)[0], list.get(0)[1]);
			list.clear();
		}
		
		//만족도 조사
		int answer = 0;
		final int[] score = {0, 1, 10, 100, 1000};
		for(int i=0; i<T; i++) {
			int stu = students[i][0];
			int x = isSeatPoint[stu][0], y = isSeatPoint[stu][1];
			
			int count = 0;
			for(int j=0; j<4; j++) {
				int nx = dx[j]+x;
				int ny = dy[j]+y;
				
				if(nx<0||ny<0||nx>=N||ny>=N) continue;
				for(int s=1; s<5; s++) {
					if(students[i][s] == room[nx][ny]) count++;
				}
			}
		
			answer+=score[count];
		}
		
		System.out.print(String.valueOf(answer));
		br.close();
	}
	
	public static void setting(int stu, int x, int y) {
		//배열에 저장
		room[x][y] = stu;
		
		//배정된 학생 체크
		isSeat[stu] = true;
		isSeatPoint[stu] = new int[] {x, y};
		
		for(int i=0; i<4; i++) {
			int nx = dx[i]+x;
			int ny = dy[i]+y;
			
			if(nx<0||ny<0||nx>=N||ny>=N) continue;
			if(room[nx][ny] != 0) continue;
			
			emptyCount[nx][ny]--;
		}
		emptyCount[x][y] = 0;
	}
	
	public static ArrayList<int[]> getMax(ArrayList<int[]> list, int[][] map) {
		ArrayList<int[]> output = new ArrayList<>();
		if(list.size() == 0) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(room[i][j]!=0) continue;
					list.add(new int[] {i, j});
				}
			}
		}
		
		int max=0;
		for(int[] i:list) {
			if(max < map[i[0]][i[1]]) {
				output.clear();
				max = map[i[0]][i[1]];
				output.add(i);
			} else if(max == map[i[0]][i[1]]) {
				output.add(i);
			}
		}
		
		return output;
	}
	
	public static ArrayList<int[]> getLike(int[] stu){
		ArrayList<int[]> output = new ArrayList<>();
				
		for(int i:stu) {
			if(isSeat[i]) {
				int x = isSeatPoint[i][0], y=isSeatPoint[i][1];
				
				for(int k=0; k<4; k++) {
					int nx = dx[k]+x;
					int ny = dy[k]+y;
					
					if(nx<0||ny<0||nx>=N||ny>=N) continue;
					if(room[nx][ny] != 0) continue;
					
					Distance[nx][ny]++;
					output.add(new int[] {nx, ny});
				}
			}
		}
		
		return output;
	}
	
	public static void getEmpty(int t) {		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				
				for(int k=0; k<4; k++) {
					int nx = dx[k]+i;
					int ny = dy[k]+j;
					
					if(nx<0||ny<0||nx>=N||ny>=N) continue;
					if(room[nx][ny] != 0) continue;
					
					emptyCount[i][j]++;
				}
			}
		}
	}
}
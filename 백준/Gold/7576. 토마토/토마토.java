import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int[][] board = new int[size[1]][size[0]];
		
		Queue<int[]> queue= new LinkedList<>();
		int startCount = 0;
		
		for(int i=0; i<size[1]; i++) {
			//데이터 입력
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			//시작점 탐색
			for(int j=0; j<size[0]; j++) {
				if(board[i][j] == 1) {
					int[] start = {i, j};
					queue.add(start);
					startCount++;
				} 
			}
		}

		int dx[] = {1, 0, -1, 0}, dy[] = {0, 1, 0, -1};
		while(!queue.isEmpty()) {

			for(int i=0; i<startCount; i++) {
				if(queue.isEmpty()) {
					break;
				}
				int[] now = queue.poll();
				
				for(int j=0; j<4; j++) {
					int x = now[0]+dx[j];
					int y = now[1]+dy[j];

					if(x<0 || x>=size[1] || y<0 || y>=size[0]) {
						continue;
					}

					if(board[x][y]!=0) {
						continue;
					}

					board[x][y] = board[now[0]][now[1]] + 1;
					int[] nextPoint = {x, y};
					queue.add(nextPoint);

				}
			}			
		}
		
		int output=0;
		for(int[] i:board) {
			for(int j:i) {
				if(j==0) {
					output = 0;
					break;
				}
				if(output < j) {
					output = j;
				}
			}
			if(output==0) {
				break;
			}
		}
		
		if(output == 1) {
			System.out.print(0);
		} else {
			System.out.print(output-1);
		}
		
		br.close();	
		
	}
	
}
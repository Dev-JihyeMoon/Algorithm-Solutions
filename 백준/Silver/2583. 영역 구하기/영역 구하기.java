
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int m = input[0], n = input[1], k = input[2];
		
		int[][] map = new int[m][n];
		
		for(int i=0; i<k; i++) {
			input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] point01 = Arrays.copyOfRange(input, 0, 2);
			int[] point02 = Arrays.copyOfRange(input, 2, 4);
			
			
			for(int j=point01[0]; j<point02[0]; j++) {
				for(int l=point01[1]; l<point02[1]; l++) {
					map[l][j] = 1;
				}
			}
		}
		
		func(map);
		br.close();
		
		
	}
	
	public static void func(int[][] map) {
		//시작점 탐색
		int count = 0;
		ArrayList<Integer> output = new ArrayList<>();
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				if(map[i][j] == 0) {
					count++;
					
					int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
					Queue<int[]> queue = new LinkedList<>();
					map[i][j] = 1;
					int temp = 1;
					int[] start = {i, j};
					queue.add(start);
					
					while(!queue.isEmpty()) {
						int[] now = queue.poll();
						
						for(int bi=0; bi<4; bi++) {
							int x = now[0]+dx[bi];
							int y = now[1]+dy[bi];
							
							if(x<0 || x>=map.length || y<0 || y>=map[0].length) {
								continue;
							}
							
							if(map[x][y] == 1) {
								continue;
							}
							
							temp++;
							map[x][y] = 1;
							int[] nextPoint = {x, y};
							queue.add(nextPoint);
						}
					}
					
					output.add(temp);
				}
			}
		}
		
		output.sort(Comparator.naturalOrder());
		
		System.out.println(count+" ");
		
		for(int i=0; i<count; i++) {
			System.out.print(output.get(i)+" ");
		}
	}
	
}

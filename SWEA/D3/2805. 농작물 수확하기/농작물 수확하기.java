import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {        	
        	// 변수 설정
        	int size = Integer.parseInt(br.readLine());
        	int[][] map = new int[size][size];
        	
        	for(int i=0; i<size; i++) {
        		map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        	}
        	
        	// 함수 호출
        	int answer = map[0][0];
        	if(size != 1) {
        		answer = diffusion(map, size);
        	} 
        	
        	bw.write("#"+t+" "+answer+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int diffusion(int[][] map, int size) {    	
    	int center = size/2;
    	
    	Queue<int[]> queue = new LinkedList<>();
    	queue.add(new int[] {center, center});
    	
    	int output = map[center][center];
    	map[center][center] = -1; // 방문 표시
    	
    	while(!queue.isEmpty()) {
    		int[] now = queue.poll();
    		
    		for(int i=0; i<4; i++) {
    			int x = now[0]+dx[i];
    			int y = now[1]+dy[i];
    			
    			if(0>x || size<=x || 0>y || size<=y) {
    				return output;
    			}
    			
    			if(map[x][y] == -1) {
    				continue;
    			}
    			
    			queue.add(new int[] {x, y});
    			output+=map[x][y];
    			map[x][y]=-1;
    		}
    	}
    	
    	return output;
    }
}
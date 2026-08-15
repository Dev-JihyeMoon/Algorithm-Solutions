import java.util.*;

class Solution {
    
    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {1, 0, -1, 0};
        
    public int solution(int[][] maps) {
        int answer = bfs(maps);
        return answer;
    }
    
    public int bfs(int[][] maps){
        int[] size = new int[] {maps.length, maps[0].length};
        int[][] isCheck = new int[size[0]][size[1]];
        Queue<int[]> queue = new LinkedList<>();
        
        //setting
        queue.add(new int[] {0, 0});
        isCheck[0][0] = 1;
        
        //bfs
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nx = now[0], ny = now[1];
            
            for(int i=0; i<4; i++){
                int x = nx+dx[i];
                int y = ny+dy[i];
                
                if(x<0 || size[0]<=x || y<0 || size[1]<=y) { continue; } 
                if(maps[x][y] == 0) { continue; }
                if(isCheck[x][y] != 0) { continue; }
                
                isCheck[x][y] = isCheck[nx][ny] + 1;
                queue.add(new int[] {x, y});
            }
        }
        
        if(isCheck[size[0]-1][size[1]-1] == 0){
            return -1;
        }
        
        return isCheck[size[0]-1][size[1]-1];
    }
}
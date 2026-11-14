import java.util.*;

class Solution {

    static int[][] map; //0은 검사 범위 아님, 1은 미방문, 2는 방문
    static int size;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        map = computers;
        size = n;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1){
                    bfs(i, j);
                    answer++;
                    continue;
                }
            }
        }
        
        return answer;
    }
    
    public static void bfs(int x, int y){
        Queue<Integer> point = new LinkedList<>();
        
        point.add(x);
        map[x][y] = 2;
        
        while(!point.isEmpty()){
            int nx = point.poll();
            
            for(int ny=0; ny<size; ny++){
                
                // 검사 범위가 아닌 경우
                if(map[nx][ny] != 1){
                    continue;
                }
                
                map[nx][ny] = 2; 
                point.add(ny);
            }
        }
    }
}
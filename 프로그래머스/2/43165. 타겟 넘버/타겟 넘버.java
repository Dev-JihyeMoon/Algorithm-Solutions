import java.util.*;

class Solution {
    
    final static int[] dy = {-1, 1};
    
    public int solution(int[] numbers, int target) {
        int answer = bfs(numbers, target);
        return answer;
    }
    
    public int bfs(int[] numbers, int target){
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        //setting
        queue.add(new int[]{0, 0});
        
        //bfs
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            
            int index = now[0];
            int value = now[1];
            
            if(index == numbers.length){
                if(target == value){ count++; }

                continue;
            }
            
            for(int i=0; i<2; i++){ 
                int temp = value + (numbers[index] * dy[i]);
                queue.add(new int[]{index+1, temp});
            }
        }
        
        return count;
    }
}
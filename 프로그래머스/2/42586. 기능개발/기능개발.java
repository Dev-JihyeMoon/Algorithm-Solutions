import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> countDay = new LinkedList<>();
        int point = 0;
        
        while(true){
            int day = ( 100-progresses[point] ) / speeds[point];
            if( (speeds[point]*day) + progresses[point]  < 100 ){
                day++;
            }
            
            for(int i=point; i<progresses.length; i++){
                progresses[i] += speeds[i]*day;
            }
            
            int count=0;
            for(int i=point; i<progresses.length; i++){
                if(100 <= progresses[i]) {
                    count++;
                }
                else break;
            }
            
            point+= count;
            countDay.add(count);
            
            if(progresses.length <= point){
                break;
            }
        }
        
        int size = countDay.size();
        int[] answer = new int[size];
        for(int i=0; i<size; i++){
            answer[i] = countDay.poll();
        }
        return answer;
    }
}
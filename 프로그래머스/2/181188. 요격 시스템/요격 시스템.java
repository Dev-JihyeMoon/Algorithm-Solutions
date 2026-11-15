import java.util.*;

// 그리디(탐욕) 알고리즘. 

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        //2번째 원소 기준 오름차순 정렬
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        int standard = targets[targets.length-1][1];
        
        //
        for(int i=targets.length-1; i>=0; i--){
            int back = targets[i][1];
            int front = targets[i][0];
            
            if(back <= standard) {
                standard = front;
                answer++;
            } else if(standard < front) {
                standard = front;
            }
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public long solution(long n) {
        long num = 1;
        long answer;
        
        while(true){
            long now = num*num;
            
            if(now == n){
                num++;
                answer = num*num;
                break;
            }
            
            if(n < now) {
                answer = -1;
                break;
            }
            
            num++;
        }
        
        return answer;
    }
}
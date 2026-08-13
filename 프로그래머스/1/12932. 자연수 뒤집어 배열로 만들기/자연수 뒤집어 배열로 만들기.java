import java.util.*;

class Solution {
    public int[] solution(long n) {
        int[] answer = new int[String.valueOf(n).length()];
        int count = 0;
        
        
        while(true){
            answer[count] = (int)( n%10 );
            if(n/10 == 0){
                break;
            }
            n /= 10;
            count++;
        }
        return answer;
    }
}
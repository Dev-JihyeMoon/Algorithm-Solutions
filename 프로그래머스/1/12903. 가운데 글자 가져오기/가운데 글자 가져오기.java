import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = String.valueOf(s.charAt(s.length()/2));
        
        if(s.length()%2 == 0){
            answer = String.valueOf(s.charAt((s.length()/2)-1)) + answer;
        }
        return answer;
    }
}
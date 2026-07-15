import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<String> open = new Stack<>();
        Stack<String> close = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char temp = s.charAt(i);
            
            if(temp == '('){
                open.add("(");
            } else if(!open.isEmpty()){
                open.pop();
            } else {
                close.add(")");
            }
        }
        
        if(!open.isEmpty() || !close.isEmpty()){
            answer = false;
        }
        
        return answer;
    }
}
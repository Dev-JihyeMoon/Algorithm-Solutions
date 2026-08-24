import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++){
            String str = s.substring(i, s.length()) + s.substring(0, i);
            
            if(isCheck(str)) answer++;
        }
        
        return answer;
    }
    
    public static boolean isCheck(String str){
        String open = "([{";
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<str.length(); i++){
            char now = str.charAt(i);
            
            if(open.indexOf(now) != -1){
                stack.add(now);
            } else {
                
                if(stack.isEmpty()) return false;
                
                char temp = stack.peek();
                
                if(now == ')' && temp == '(') { stack.pop(); continue; }
                else if(now == ']' && temp == '[') { stack.pop(); continue; }
                else if(now == '}' && temp == '{') { stack.pop(); continue; }
                
                return false;
            }
        }
        
        return stack.isEmpty();
    }
}
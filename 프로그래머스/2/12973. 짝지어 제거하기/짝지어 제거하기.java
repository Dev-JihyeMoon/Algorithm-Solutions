import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char alp = s.charAt(i);
            
            if(stack.isEmpty() || stack.peek() != alp) {
                stack.add(alp);
            } else {
                stack.pop();
            }
        }
        
        int answer = stack.isEmpty()?1:0;
        
        return answer;
    }
}
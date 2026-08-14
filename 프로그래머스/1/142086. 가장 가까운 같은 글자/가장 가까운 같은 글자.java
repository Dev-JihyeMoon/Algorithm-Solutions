import java.util.*;

class Solution {
    public int[] solution(String s) {
        HashMap<Character, Integer> words = new HashMap<>();
        int[] answer = new int[s.length()];
        
        for(int i=0; i<s.length(); i++){
            Character now = s.charAt(i);
            int index = now - 'a';
            
            if(!words.containsKey(now)){
                answer[i] = -1;
                words.put(now, i);
            } else {
                answer[i] = i-words.get(now);
                words.put(now, i);
            }
        }
        
        return answer;
    }
}
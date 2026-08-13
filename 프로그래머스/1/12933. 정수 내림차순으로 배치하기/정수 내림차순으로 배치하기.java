import java.util.*;

class Solution {
    public long solution(long n) {
        String word = String.valueOf(n);
        
        Character[] words = new Character[word.length()];
        for(int i=0; i<word.length(); i++){
            words[i] = word.charAt(i);
        }
        
        Arrays.sort(words, Collections.reverseOrder());
        String temp = "";
        for(char i:words){
            temp += String.valueOf(i);
        }
        
        
        return Long.parseLong(temp);
    }
}
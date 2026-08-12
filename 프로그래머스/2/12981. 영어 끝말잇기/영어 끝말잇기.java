import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2]; // 0: 번호, 1: 차례
        
        int turn = words.length/n;        
        int wordNum = 0;
        
        for(int i=0; i<turn; i++){
            for(int j=0; j<n; j++){
                int now = (i*n)+j;
                boolean checkDup = checkDuplicate(Arrays.copyOfRange(words, 0, now), words[now]);
                boolean checkR = now==0 ? false : checkRole(words[now-1], words[now]);
                
                
                if(checkDup||checkR){
                    answer[0] = j+1;
                    answer[1] = i+1;
                    
                    return answer;
                }
            }
        
        }
        
        
        return answer;
    }
    
    public boolean checkDuplicate(String[] list, String word){
        if(list.length == 0)
            return false;
        
        for(int i=0; i<list.length; i++){            
            if(list[i].equals(word))
                return true;
        }
        
        return false;
    }
    
    public boolean checkRole(String before, String now){
        if(before.charAt(before.length()-1) == now.charAt(0))
            return false;
        
        return true;
    }
}
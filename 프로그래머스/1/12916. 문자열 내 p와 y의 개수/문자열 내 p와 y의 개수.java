import java.util.*;

class Solution {
    boolean solution(String s) {
        int pCount = 0, yCount = 0;
        
        for(int i=0; i<s.length(); i++){
            char now = s.charAt(i);
            
            if(now=='y' || now=='Y'){
                yCount++;
            } else if(now=='p' || now=='P'){
                pCount++;
            }
        }
        
        return pCount==yCount?true:false;
    }
}
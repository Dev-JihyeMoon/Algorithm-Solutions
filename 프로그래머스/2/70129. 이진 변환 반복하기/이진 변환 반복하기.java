import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int convert = 0, sliceCount=0;
        
        while(true){
            if(s.equals("1"))
                break;
            
            int count=0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '1'){
                    count++;
                }
            }
            
            convert++;
            sliceCount += (s.length() - count);
            
            s = Integer.toBinaryString(count);
        }
        
        answer[0] = convert;
        answer[1] = sliceCount;

        return answer;
    }
    
    
}
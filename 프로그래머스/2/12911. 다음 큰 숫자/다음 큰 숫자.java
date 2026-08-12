import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // n의 1의 개수 
        String binaryStr = Integer.toBinaryString(n);
        int standard = 0;
        for(int i=0; i<binaryStr.length(); i++){
            char temp = binaryStr.charAt(i);
            if(temp == '1') 
                standard++;
        }
        
        int now=n;
        while(true){
            now++;
            String nowbinaryStr = Integer.toBinaryString(now);
            
            int count = 0;
            for(int i=0; i<nowbinaryStr.length(); i++){
                char temp = nowbinaryStr.charAt(i);
                if(temp == '1') 
                    count++;
            }
            
            if(count==standard){
                answer = now;
                break;
            }
            
        }
        return answer;
    }
}
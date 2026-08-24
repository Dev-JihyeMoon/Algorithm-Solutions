import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right){
        int size = (int)(right-left)+1;
        int[] answer = new int[size];
        
        for(int i=0; i<size; i++){
            long num = i+left;
            
            long x = num/n;
            long y = num%n;
            
            long temp = x<y?y:x;
            
            answer[i] = (int) temp+1;
        }
        
        return answer;
    }
}
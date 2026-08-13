import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int minNum = arr[0];
        
        if(arr.length == 1) {
            int[] answer = {-1};
            return answer;
        }
        
        for(int i=1; i<arr.length; i++){
            if(arr[i] < minNum) 
                minNum = arr[i];
        }
        
        int[] answer = new int[arr.length-1];
        int count=0;
        for(int i:arr){
            if(i == minNum){
                continue;
            }
            
            answer[count] = i;
            count++;
        }
        return answer;
    }
}
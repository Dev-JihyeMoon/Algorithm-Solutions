import java.util.*;

class Solution {
    static int[] check;
    
    public int solution(int[] arr) {        
        int answer = 0;
        Arrays.sort(arr);
        int count = 1, size = arr.length-1; 
        
        while(true){
            count++;
            boolean check = true;
            int num = arr[size] * count;
            
            for(int i=0; i<size; i++){
                if(num % arr[i] != 0){
                    check = false;
                    break;
                }
            }
            
            if(!check) {
                continue;
            }
            
            answer = num;
            break;
        }
        
        return answer;
    }
}
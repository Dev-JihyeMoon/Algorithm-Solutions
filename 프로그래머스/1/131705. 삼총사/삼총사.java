import java.util.*;

class Solution {
    
    static int[] arr, student = new int[3];
    static boolean[] isVisited;
    static int answer = 0;
    
    public int solution(int[] number) {
        arr = number;
        isVisited = new boolean[number.length];
        Arrays.sort(arr);
        count(0, 0);
        return answer;
    }
    
    public static int count(int num, int start){
        if(num == 3) {
            int temp = student[0] + student[1] + student[2];
            
            if(temp == 0){
                answer++;
            }
            
            return 0;
        }
        
        for(int i=start; i<arr.length; i++){
            if(!isVisited[i]){
                student[num] = arr[i];
                isVisited[i] = true;
                count(num+1, i+1);
                isVisited[i] = false;
            }
        }
        
        return 0;
    }
}
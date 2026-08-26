import java.util.*;

class Solution {
    
    public int solution(int[][] triangle) {        
        return dp(triangle);
    }
    
    public static int dp(int[][] arr) {
        int size = arr.length;
        
        for(int i=size-1; i>0; i--){
            for(int j=0; j<i; j++){
                int num = Math.max(arr[i][j], arr[i][j+1]);
                arr[i-1][j] = arr[i-1][j] + num;
            }
        }
        
        return arr[0][0];
    }
}
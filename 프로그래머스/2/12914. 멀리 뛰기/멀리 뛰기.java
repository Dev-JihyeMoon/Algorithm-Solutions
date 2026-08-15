import java.util.*;

class Solution {
    static long[] memo;
    
    public long solution(int n) {
        memo = new long[n+1];
        long answer = fibonacci(n);
        return answer;
    }
    
    public long fibonacci(int i){
        if(memo[i] != 0)
            return memo[i];
        
        if(i<=1){ return 1; }
        
        memo[i] = (fibonacci(i-1)+fibonacci(i-2)) % 1234567;        
        
        return memo[i];
    }
}
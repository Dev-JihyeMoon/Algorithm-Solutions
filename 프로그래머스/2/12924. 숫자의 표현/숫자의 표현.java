class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int start = 1, end = 1, num=0;
        
        while(start <= n){
            if(n < num){
                num -= start;
                start++;
            } else {
                if(num == n) {
                    answer ++;
                }
                num+=end;
                end++;
            }
            
        }
        
        return answer;
    }
}
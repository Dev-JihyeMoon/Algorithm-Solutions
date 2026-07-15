class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int start, end;
        
        if(a<b){
            start = a;
            end = b;
        } else if(a>b){
            start = b;
            end = a;
        } else {
            return a;
        }
        
        for(int i=start; i<=end; i++){
            answer += i;
        }
        
        return answer;
    }
}
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left; i<=right; i++){
            answer += decide(i);
        }
        
        return answer;
    }
    
    public int decide(int num){
        int count=0;
        for(int i=1; i<=num; i++){
            if(num%i == 0){
                count++;
            }
        }
        
        return count%2==0?num:num*(-1);
    }
}
class Solution {
    public boolean solution(int x) {
        int num = x;
        int sum = 0;
        
        while(true){
            sum += num % 10;
            num = num / 10;
            
            if(num == 0) break;
        }
        
        boolean answer = x%sum==0?true:false;
        
                
        return answer;
    }
}
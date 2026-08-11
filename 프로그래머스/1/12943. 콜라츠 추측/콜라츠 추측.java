class Solution {
    public int solution(int num) {
        int answer = getCount(0, (long) num);
        return answer;
    }
    
    public int getCount(int count, Long num){
        if(num == 1) 
            return count;
        
        if(500 < count) 
            return -1;
        
        count++;
        num = num%2==0 ? num/2 : (num*3)+1;
        
        return getCount(count, num);
    }
}
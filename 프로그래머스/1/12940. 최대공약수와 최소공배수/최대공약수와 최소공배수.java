class Solution {
    public int[] solution(int n, int m) {
        int num1 = Math.min(n, m);
        int num2 = Math.max(n, m);
        
        int[] answer = {getGCD(num1, num2), getLCM(num1, num2)};
        return answer;
    }
    
    public static int getGCD(int n, int m){
        int[] arr = new int[m];
        
        int max = 0;
        
        for(int i=1; i<=n; i++){
            if(n%i==0 && m%i==0) {
                max = i;
            }
        }
        
        return max;
    }
    
    public static int getLCM(int n, int m){
        if(m%n==0) return m;
        
        int count=2;
        while(true){
            int now = m*count;
            
            if(now%n == 0)
                return now;
            
            count++;
        }
    }
}
class Solution {
    static boolean[] isCheck;
    
    public int solution(int n) {
        isCheck = new boolean[n+1];
        check(n);
        
        int answer = 0;
        for(int i=2; i<=n; i++){
            if(!isCheck[i]) { answer++; }
        }
        
        return answer;
    }
    
    public static void check(int n){
        for(int i=2; i<=n; i++){
            for(int j=i+i; j<=n; j=j+i) {
                if(isCheck[j]) { continue; }
                isCheck[j] = true;
            }
        }
    }
}
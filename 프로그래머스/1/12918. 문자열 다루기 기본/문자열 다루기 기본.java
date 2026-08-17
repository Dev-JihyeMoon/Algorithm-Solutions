class Solution {
    public boolean solution(String s) {
        boolean answer = getCheck(s);
        
        
        return answer;
    }
    
    public static boolean getCheck(String word){        
        if(word.length() != 4 && word.length() != 6){
            return false;
        }
        
        for(int i=0; i<word.length(); i++){
            int now = word.charAt(i);
            
            if(!(48 <= now) || !(now <= 57)) {
                return false;
            }
        }
        
        return true;
    }
}
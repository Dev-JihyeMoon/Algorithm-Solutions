class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        
        
        for(int i=0; i<my_string.length(); i++){
            String temp = String.valueOf(my_string.charAt(i));
            
            if(!letter.equals(temp)){
                answer+=temp;
            }
        }
        return answer;
    }
}
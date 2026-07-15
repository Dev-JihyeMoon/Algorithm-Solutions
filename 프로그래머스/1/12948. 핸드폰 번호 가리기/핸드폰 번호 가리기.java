class Solution {
    public String solution(String phone_number) {
        
        int len = phone_number.length() - 4;
        
        String answer = ( "*".repeat(len) ) + phone_number.substring(len);
        return answer;
    }
}
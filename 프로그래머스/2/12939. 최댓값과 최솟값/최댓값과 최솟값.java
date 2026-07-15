import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        int[] num = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(num);
        
        answer = String.valueOf(num[0])+" "+String.valueOf(num[num.length-1]);        
        return answer;
    }
}
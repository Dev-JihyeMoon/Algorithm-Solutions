class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        // 바로 앞 글자가 공백이었는지를 판별 (첫 글자는 무조건 대문자 대상이므로 true로 시작)
        boolean isFirst = true;
        
        // 문자열을 한 글자씩 분리하여 배열로 순회
        for (String c : s.split("")) {
            // 현재 문자가 공백이면 다음 글자가 첫 글자가 되도록 설정
            if (c.equals(" ")) {
                answer.append(" ");
                isFirst = true; 
            } 
            // 공백이 아니면서 단어의 첫 글자라면 대문자로 변환
            else if (isFirst) {
                answer.append(c.toUpperCase());
                isFirst = false; 
            } 
            // 단어의 첫 글자가 아니라면 모두 소문자로 변환
            else {
                answer.append(c.toLowerCase());
            }
        }
        
        return answer.toString();
    }
}

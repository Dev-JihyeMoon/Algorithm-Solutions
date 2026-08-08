class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int baseNum = brown + yellow;
        
        for(int i=1; i<=baseNum; i++){
            // 직사각형으로 존재할 수 있는지 확인
            if(baseNum % i != 0){
                continue;
            }
            
            int temp = baseNum / i;
            // 가로 길이가 짧은 경우 확인
            if(i < temp) {
                continue;
            }
            
            // 노랑색이 격자모양으로써 yellow 값과 일치하는지 확인
            if((temp-2)*(i-2) != yellow) {
                continue;
            }
            
            // 정답
            answer[0] = i;
            answer[1] = temp;
            
            break;
        }
        return answer;
    }
}
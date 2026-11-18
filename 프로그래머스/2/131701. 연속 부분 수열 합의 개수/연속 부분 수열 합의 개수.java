import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<elements.length; i++){
            int end = i;
            
            // 초기 합 세팅
            int sum = 0;
            for(int j=0; j<end; j++){
                sum+=elements[j];
            }
            
            // 양 끝에 있는 수 계산
            for(int start=0; start<elements.length; start++){
                
                // 뒷부분 수 더하기
                sum += elements[end];
                set.add(sum);
                
                // 앞에 있는 수 제외하기
                sum -= elements[start];
                
                // 끝 좌표 설정
                end++;
                if(elements.length <= end) {
                    end=0;
                }
            }
            
        }
        
        return set.size();
    }
}
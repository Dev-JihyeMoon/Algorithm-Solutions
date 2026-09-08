import java.util.*;

/*
회고: 심사 받는 시간을 배열로 저장했다가 메모리 초과
*/
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        Long start = (long) 0, end = (long) (times[times.length-1]* (long)n);
        
        while(start <= end){
            Long mid = (start+end)/2;
            long people=0;
            
            for(int i:times){
                people += mid/i;
            }
            
            if(n <= people) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        
        return start;
    }
}
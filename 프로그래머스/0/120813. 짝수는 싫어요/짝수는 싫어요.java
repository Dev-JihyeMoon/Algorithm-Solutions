import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> temp = new ArrayList<>();
        
        for(int i=1; i<=n; i+=2){
            temp.add(i);
        }
        
        return temp.stream().mapToInt(Integer::intValue).toArray();
    }
}
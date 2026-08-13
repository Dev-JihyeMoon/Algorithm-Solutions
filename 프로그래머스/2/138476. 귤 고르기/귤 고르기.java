import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> box = new HashMap<>();
        
        for(int i=0; i<tangerine.length; i++){
            Integer temp = tangerine[i];
            
            if(box.containsKey(temp)){
                box.put(temp, box.get(temp)+1);
            } else {
                box.put(temp, 1);
            }            
        }
        
        Integer[] arr = new Integer[box.size()];
        int count=0;
        for(Integer i:box.values()){
            arr[count] = i;
            count++;
        }
        
        Arrays.sort(arr, Collections.reverseOrder());
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            if(k <= sum) {
                answer = i+1;
                break;
            }
        }
        
        return answer;
    }
}
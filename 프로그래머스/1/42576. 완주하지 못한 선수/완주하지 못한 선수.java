import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> people = new HashMap<>();
        
        for(String i:participant){
            int count = people.containsKey(i)?people.get(i)+1:1;
            people.put(i, count);
        }
        
        for(String i:completion){
            if(people.get(i) == 1){
                people.remove(i);
            } else {
                people.put(i, people.get(i)-1);
            }
        }
        
        return people.keySet().iterator().next();
    }
}
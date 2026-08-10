import java.util.*;

class Solution {
    public static String[] name;
    public static int[] yearning;
    
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // 점수 세팅
        HashMap<String, Integer> scoreMap = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            scoreMap.put(name[i], yearning[i]);
        }
        
        int[] answer = new int[photo.length];
        for(int i=0; i<photo.length; i++){
            answer[i] = getScore(scoreMap, photo[i]);
        }
        return answer;
    }
    
    public int getScore(HashMap<String, Integer> standard, String[] photo){
        int score = 0;
        
        for(int i=0; i<photo.length; i++){
            if(standard.containsKey(photo[i])) {
                score+=standard.get(photo[i]);
            }
        }
        
        return score;
    }
}
import java.util.*;

class Solution {
    Integer[] sortedMats;
    
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        int n = park.length;
        int m = park[0].length;
        
        sortedMats = new Integer[mats.length];
        for(int i=0; i<mats.length; i++){
            sortedMats[i] = mats[i];
        }
        Arrays.sort(sortedMats, Collections.reverseOrder());
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(park[i][j].equals("-1")){
                    int result = findMat(park, i, j);
                    
                    if(result > answer){
                        answer = result;
                    }
                    
                    if(answer == sortedMats[0]){
                        return answer;
                    }
                }
            }
        }
        
        return answer;
    }
    
    int findMat(String[][] park, int x, int y){
        int n = park.length;
        int m = park[0].length;
        
        outer:
        for(int idx=0; idx<sortedMats.length; idx++){
            int size = sortedMats[idx];
            
            if(x + size > n || y + size > m){
                continue;
            }
            
            for(int i=x; i<x+size; i++){
                for(int j=y; j<y+size; j++){
                    if(!park[i][j].equals("-1")){
                        continue outer;
                    }
                }
            }
            
            return size;
        }
        
        return -1;
    }
}
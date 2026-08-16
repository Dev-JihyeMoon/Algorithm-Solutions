import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int size = sc.nextInt();
            String word = sc.next();
            
            int answer = getPair(size, word);
            
            bw.write(answer+"\n");
		}
        
        bw.close();
	}
    
    public static int getPair(int size, String word){
        HashMap<String, Integer> map = new HashMap<>();
        int diffAT = 0, diffCG = 0, count = 0;
        map.put("0,0", 1);
        
        for(int i=0; i<size; i++){
            char now = word.charAt(i);
            
            if(now == 'A') { diffAT++; }
            else if(now == 'T') { diffAT--; }
            else if(now == 'C') { diffCG++; }
            else if(now == 'G') { diffCG--; }
            
            String key = diffAT + "," + diffCG;
            int value = 1;
            //과거에 등장했다면 카운트
            if(map.containsKey(key)){
                count += map.get(key);
                value += map.get(key);
            }
            
            map.put(key, value);
        }
        
        return count;
    }
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
        	// 입력받기
        	
        	String[] input = br.readLine().split(" ");
        	
        	int point = setPoint(input[0]);
        	int count = Integer.parseInt(input[1]);
        	
        	if(count == 0) {
        		bw.write("#"+t+" "+point+"\n");
        		continue;
        	}
        	
        	int answer = count%2==0?0:1;
        	
        	if(point==1) {
        		answer = count%2==0?1:0;
        	}
        	
        	bw.write("#"+t+" "+answer+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int setPoint(String temp) {
    	int output=0;
    	
    	switch (temp) {
		case "o..": 
			output = 0;
			break;
		case ".o.": 
			output = 1;
			break;
		case "..o": 
			output = 2;
			break;
		}
    	
    	return output;
    }
}
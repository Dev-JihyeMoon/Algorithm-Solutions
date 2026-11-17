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
        	
        	// 소리가 안들렸다면 => 원래 자리 그대로 출력
        	if(count == 0) {
        		bw.write("#"+t+" "+point+"\n");
        		continue;
        	}
        	
        	// 방울이 0, 2에 있다면 => 홀수면 1, 짝수면 0
        	int answer = count%2==0?0:1;
        	
        	// 방울이 1에 있다면 => 홀수면 0, 짝수면 1
        	if(point==1) {
        		answer = count%2==0?1:0;
        	}
        	
        	bw.write("#"+t+" "+answer+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
    
    //지금 방울이 어디에 있는지
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

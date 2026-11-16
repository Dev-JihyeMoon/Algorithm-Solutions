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
        	int[] turn = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        	
        	int last = turn[0];
        	int boom = turn[1];
        	
        	long answer = 0;
        	int check = 0;
        	
        	for(int i=1; i<=last; i++) {
        		if(answer+i == boom) {
        			check=1;
        		}
        		
        		answer += i;
        	}
        	
        	answer -= check;
        	
        	bw.write(answer+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
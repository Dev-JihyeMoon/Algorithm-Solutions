import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int t = Integer.parseInt(br.readLine());
	
		for(int i=1; i<=t; i++) {
			int n = Integer.parseInt(br.readLine());
			
			int answer = count(n);
			
			bw.write("#"+i+" "+answer+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int count(int n) {
		int answer = 1;
		Set<String> check = new HashSet<>();
		
		while(true) {
			String temp = String.valueOf(n*answer);
			
			for(int i=0; i<temp.length(); i++) {
				check.add(String.valueOf(temp.charAt(i)));
			}
			
			if(check.size() == 10) {
				break;
			} else {
				answer++;
			}
		}
		return answer*n;
	}
}

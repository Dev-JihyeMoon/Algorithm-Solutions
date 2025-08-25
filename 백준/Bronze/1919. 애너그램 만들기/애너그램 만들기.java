import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String word01 = br.readLine();
		String word02 = br.readLine();
		
		int spelling01[] = new int[26], spelling02[] = new int[26];
		int answer = 0;
		
		for(int i=0; i<word01.length(); i++) {
			spelling01[word01.charAt(i)-'a']++;
		}
		

		for(int i=0; i<word02.length(); i++) {
			spelling02[word02.charAt(i)-'a']++;
		}
		
		for(int i=0; i<26; i++) {
			if(spelling01[i] != spelling02[i]) {
				answer += Math.abs(spelling01[i] - spelling02[i]);
			}
		}
		
		String a = String.valueOf(answer);
		
		bw.write(a);
		bw.close();
		br.close();
		
	}
}
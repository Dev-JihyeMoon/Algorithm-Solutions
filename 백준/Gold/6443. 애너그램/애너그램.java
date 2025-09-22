import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	static ArrayList<String> answer = new ArrayList<>();
	static char[] alp, word;
	static boolean[] isVisited;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		String[] input = new String[N];
		
		for(int i=0; i<N; i++) {
			input[i] = br.readLine();
		}
		
		for(int i=0; i<N; i++) {
			String now = input[i];
			
			setAlp(now);
			getAnagram(0, now.length());
			
			Collections.sort(answer);
			
			for(String j:answer) {
				System.out.println(j);
			}
			
			answer.clear();
		}
		
		br.close();
	}
	
	public static void getAnagram(int cnt, int end) {
		if(cnt==end) {
			//에너그램 문자 생성
			String temp = "";
			for(char i:word) {
				temp += String.valueOf(i);
			}
			
			answer.add(temp);
			
			return;
		}
		
		char check = '\0'; // 이 깊이에서 마지막으로 쓴 문자
		for(int i=0; i<end; i++) {
			if(isVisited[i]) continue;
			if (alp[i] == check) continue;  // 같은 문자면 같은 깊이에서 한 번만
			
			word[cnt] = alp[i];
			check = alp[i]; // 마지막으로 사용한 문자 고정
			
			isVisited[i] = true;
			getAnagram(cnt+1, end);
			isVisited[i] = false;
		
		}
	}
	
	public static void setAlp(String temp) {
		alp = new char[temp.length()];
		word = new char[temp.length()];
		isVisited = new boolean[temp.length()];
		
		for(int i=0; i<temp.length(); i++) {
			alp[i] = temp.charAt(i);
		}
		
		Arrays.sort(alp);
		return;
	}
}
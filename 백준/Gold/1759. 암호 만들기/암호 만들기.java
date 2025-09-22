import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static String[] alp, word;
	static boolean[] isVisited, vowel = new boolean[26];
	static int L, C;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		L = input[0];
		C = input[1];
		alp = br.readLine().split(" ");
		
		Arrays.sort(alp);
		
		//모음 확인을 위한 세팅
		char[] temp = {'a', 'e', 'i', 'o', 'u'};
		for(char i:temp) {
			vowel[(int)i-97] = true;
		}
		
		word = new String[L];
		isVisited = new boolean[C];
		
		getPassword(0, 0);
		
		br.close();
	}
	
	//구성된 암호 안에 모음, 자음이 조건을 만족하는지 확인
	public static boolean getvalidCheck() {
		int count=0; 
		
		for(String i:word) {
			if(vowel[i.charAt(0) - 'a']) count++;
		}
		
		if(count==0) return false;
		
		return 2<=L-count?true:false;
	}
	
	public static void getPassword(int cnt, int front) {		
		if(cnt == L) {
			
			//모음 자음 조건을 충족한 경우 출력
			if(getvalidCheck()) { 
				for(String i:word) {
					System.out.print(i);
				}
				System.out.println();
			}
			return;
		}
		
		for(int j=front; j<C; j++) {
			if(isVisited[j]) continue;
			
			word[cnt] = alp[j];
			isVisited[j] = true;
			getPassword(cnt+1, ++front);
			isVisited[j] = false;
		}
	}
}
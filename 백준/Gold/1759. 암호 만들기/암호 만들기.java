import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static String[] alp, word, vowel = {"a", "e", "i", "o", "u"};
	static boolean[] isVisited;
	static int L, C;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		L = input[0];
		C = input[1];
		alp = br.readLine().split(" ");
		
		Arrays.sort(alp);
		
		word = new String[L];
		isVisited = new boolean[C];
		getPassword(0, 0);
		
		br.close();
	}
	
	public static boolean getvalidCheck() {
		int vowelCount=0; 
		for(String i:word) {
			for(String j:vowel) {
				if(i.equals(j)) vowelCount++;
			}
		}
		
		if(vowelCount==0) return false;
		
		return 2<=L-vowelCount?true:false;
	}
	
	public static void getPassword(int cnt, int front) {
		
		//System.out.println(String.valueOf(cnt));
		
		if(cnt == L) {
			//구성된 암호 안에 모음, 자음이 조건을 만족하는지 확인
			if(getvalidCheck()) {
				for(int i=0; i<L; i++) {
					System.out.print(word[i]);
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

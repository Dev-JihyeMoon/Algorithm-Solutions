import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int repeat = Integer.parseInt(br.readLine());
		int count=0;
		boolean check;
		
		for(int i=0; i<repeat; i++) {
			String input = br.readLine();
			check = true;
			
			if(input.length() <= 2) {
				count++;
//				System.out.println("2미만 ++");
			} else {				
//				System.out.println("그룹단어 체크 진입");
				int[] checkAlphabet = new int[26];
				
				for(int j=0; j<input.length(); j++) {
					int now = input.charAt(j)-97;
					
					if(checkAlphabet[now] != 0) {
						if(input.charAt(j) != input.charAt(j-1)) {
//							System.out.println(now+"+안함"+checkAlphabet[j]);
							check = false;
							break;
						}
					} 
					checkAlphabet[now] = checkAlphabet[now]+1 ;

//					System.out.println(now+"+함"+checkAlphabet[now]);
				}
				
				if(check) {
					count ++;
//					System.out.println("그룹단어 ++");
				}
			}
		}
		
		System.out.print(count);
	}
}
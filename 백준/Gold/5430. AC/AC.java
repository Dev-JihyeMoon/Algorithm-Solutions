
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			//D(버리기)가 배열보다 클 경우 error 처리
			if(n<getCount(p)) {
				bw.write("error"+"\n");
				continue;
			}
			
			//n이 0일 경우 공백 배열 출력
			if(n == 0) {
				bw.write("[]"+"\n");
				continue;
			}
			
			//명령문 수행 
			int[] list = setArr(n, str);
			int start = 0, end = list.length-1;
			boolean course = true;
			boolean space = false;
			
			//명령문 수행
			for(int j=0; j<p.length(); j++) {
				if(p.charAt(j) == 'R') {
					course = course?false:true;
				} else {
					if(start==end) {
						space = true;
						break;
					}
					
					if(course) start++;
					else end--;
				}
			}
			
			//출력값 생성
			StringBuffer sb = new StringBuffer();
			sb.append("[");
			while(start != end) {
				sb.append((course?list[start++]:list[end--])+",");
			}
			if(start==end && !space) {
				sb.append((course?list[start]:list[end]));
			}
			sb.append("]"+"\n");
			
			//출력
			bw.write(String.valueOf(sb));
		}
		
		bw.close();
		br.close();
	}
	
	//문자열을 정수 배열로 변환
	public static int[] setArr(int n, String str) {
		int[] output = new int[n];
		int count = 0;
		String temp = "";
		
		for(int i=1; i<str.length(); i++) {
			if(str.charAt(i) == ',' || str.charAt(i) == ']') {
				output[count] = Integer.parseInt(temp);	
				count++;
				temp = "";
			} else {
				temp += String.valueOf(str.charAt(i));
			}
		}
		return output;
	}
	
	//수행 할 명령어에서 'D(버리기)'의 개수 확인
	public static int getCount(String command) {
		int output = 0;
		
		for(int i=0; i<command.length(); i++) {
			if(command.charAt(i) == 'D') output++;
		}
		
		return output;
	}
}

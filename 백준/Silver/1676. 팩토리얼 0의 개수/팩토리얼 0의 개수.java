import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//핵심 규칙: 5!단위로 0 증가. 추가로 5의 제곱인 경우 지수만큼 0이 증가. 
//5(1x5), 10(2x5) ... 25(5x5) ... 125(5x5x5)
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());		
		int output = 0;
		
		while(n>0) {
			n /= 5;
			output += n;
		}
		
		bw.write(String.valueOf(output));
		br.close();
		bw.close();
	}
}
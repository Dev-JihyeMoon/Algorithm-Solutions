import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String st = br.readLine();
		st = st.strip(); //앞 뒤 공백제거
		String[] output = st.split(" "); //공백 기준으로 단어 분리

		br.close();
		
		if(output[0] == "") {
			System.out.print("0");
		} else {
			System.out.print(output.length);
		}
	}
}

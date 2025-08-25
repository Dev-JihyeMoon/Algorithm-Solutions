import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = nm[0], m = nm[1];
		
		HashMap<Integer, String> numberBook = new HashMap<>(n);
		HashMap<String, Integer> nameBook = new HashMap<>(n);
		
		for(int i=1; i<=n; i++) {
			String input = br.readLine();
			
			numberBook.put(i, input);
			nameBook.put(input, i);
		}
		
		for(int i=0; i<m; i++) {
			String input = br.readLine();
			//숫자일 경우
			if(48 < input.charAt(0) && input.charAt(0) <= 57) {
				String answer = numberBook.get(Integer.parseInt(input));
				bw.write(answer+"\n");
			} else {
				int answer = nameBook.get(input);
				bw.write(answer+"\n");
			}
			
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}
}
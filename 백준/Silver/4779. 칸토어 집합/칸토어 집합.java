import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = "";
		
		while((input=br.readLine())!=null) {
			int n = Integer.parseInt(input);
			
			bw.write(cantor((int)Math.pow(3, n)/3)+"\n");
			
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
	public static String cantor(int count) {
		if(count == 0) {
			return "-";
		}  else {
			String space = " ".repeat(count);
			String save = cantor(count/3);
			
			return save+space+save;
		}
	}
}
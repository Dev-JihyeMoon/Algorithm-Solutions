import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String arge[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=2; i*i<=n; i++) {
			while(n%i==0) {
				bw.write(String.valueOf(i)+"\n");
				n/=i;
			}
		}
		if (n != 1) {
			bw.write(String.valueOf(n)+"\n");
		}
		bw.close();
		br.close();
	}
}

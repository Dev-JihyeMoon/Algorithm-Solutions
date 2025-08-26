import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] cardN = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int m = Integer.parseInt(br.readLine());
		int[] cardM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		Set<Integer> card = new HashSet<>();
		
		for(int i=0; i<cardN.length; i++) {
			card.add(cardN[i]);
		}
		
		for(int i:cardM) {
			int now = card.contains(i)?1:0;
			
			bw.write(now+" ");
		}
	
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = nm[0], m = nm[1];
		int count = 0;
		
		List<String> list = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			list.add(br.readLine());
		}
		
		for(int i=0; i<m; i++) {
			String input = br.readLine();
			
			if(list.contains(input)) {
				count++;
			}
		}
		
		System.out.print(count);
		
		br.close();
		
	}
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		HashSet<String> work = new HashSet<>();
		
		for(int i=0; i<n; i++) {
			String[] input = br.readLine().split(" ");
			
			if(input[1].equals("enter")) {
				work.add(input[0]);
			} else {
				work.remove(input[0]);
			}
		}
		
		br.close();
		
		List<String> list = new ArrayList<>(work);
		Collections.sort(list, Collections.reverseOrder());
		
		for(String i:list) {
			bw.write(i+"\n");
		}
		
		bw.flush();
		bw.close();
	}
}

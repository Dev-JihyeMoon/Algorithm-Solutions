import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] input = new String[n];
		ArrayList<String> output = new ArrayList<>();
		
		int maxSize = 0;
		for(int i=0; i<n; i++) {
			input[i] = br.readLine();
			
			if(maxSize < input[i].length()) {
				maxSize = input[i].length();
			}
		}
		
		for(int i=1; i<=maxSize; i++) {
			ArrayList<String> temp = new ArrayList<>();
			for(int j=0; j<n; j++) {
				String now = input[j];
				if(now.length() == i) {
					temp.add(now);
				}
			}
			
			temp.sort(Comparator.naturalOrder());
			
			for(String j:temp) {
				output.add(j);
			}
		}
		
        List<String> newList = output.stream().distinct().collect(Collectors.toList());
        
		for(String i:newList) {
			System.out.println(i);
		}
		
		br.close();
	}
	
	
}

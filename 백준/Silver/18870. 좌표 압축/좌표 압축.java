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
	
		int n = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] temp = Arrays.copyOfRange(arr, 0, n);
		HashMap<Integer, Integer> numbers = new HashMap<>();
		
		Arrays.sort(temp);
		
		int count = 0;
		for(int i:temp) {
			if(numbers.containsKey(i)) {
				continue;
			}
			
			numbers.put(i, count);
			count++;
		}

		
		for(int i:arr) {
			bw.write(numbers.get(i)+" ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
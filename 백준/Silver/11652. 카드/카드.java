import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());
		Long[] arr = new Long[n];
		
		HashMap<Long, Integer> map = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<n; i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			} else {
				map.put(arr[i], 0);
			}
		}
		
		
		int max = -1;
		Long answer = (long) 0;
		
		for(Entry<Long, Integer> i:map.entrySet()) {
			if(max <= i.getValue()) {
				if(max==i.getValue()) {
					answer = answer<i.getKey()?answer:i.getKey();
				} else {
					answer = i.getKey();
				}
				
				max = i.getValue();
			}
		}
		
		System.out.print(answer);
		br.close();
	}
}
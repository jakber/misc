import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MegaInversions {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String line = in.readLine();
		String[] split = line.split(" ");
		int[] seq = new int[n];
		for (int i = 0; i< n; i++) {
			seq[i] = Integer.parseInt(split[i]);
		}
		
		
		List<List<Integer>> sorted = new ArrayList<List<Integer>>();
		if (n > 100) {
			for (int i = 0; i < n; i+= n/25) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				for (int j = i; j < n; j++) {
					list.add(j);
				}
				Collections.sort(list);
				sorted.add(list);
			}
		}		
		long count = 0;
		
		for (int i = 0; i<  n; i++) {
			for (int j = i+1; j < n; j++) {
				if (seq[i] > seq[j]) {
					int k = j+1;
					for (k = j+1; k < n; k++) {
						if (n>100 && k % (n/25) == 0) break;
						if (seq[j] > seq[k]) count++;
					}
					if (n > 100 && k < n) {
						List<Integer> l = sorted.get(k / (n/25));
						count +=  Math.abs(Collections.binarySearch(l, seq[j]));
					}
				}
			}
		}
		
		System.out.println(count);
	}
	
}

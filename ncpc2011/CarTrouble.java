import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;



public class CarTrouble {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		Map<Integer,List<Integer>> f = new HashMap<Integer,List<Integer>>();
		Map<Integer,List<Integer>> b = new HashMap<Integer,List<Integer>>();
		for (int i = 0; i < 1000; i++) {
			f.put(i, new ArrayList<Integer>());
			b.put(i,new ArrayList<Integer>());
		}
		
		int streets[] = new int[n];
		
		
		for (int i = 0; i < n; i++) {
			String street = in.readLine();
			String[] split = street.split(" ");
			
			int id = Integer.parseInt(split[0]);
			streets[i] = id;
			int m = Integer.parseInt(split[1]);
			for (int j = 2; j < m+2; j++) {
				int v = Integer.parseInt(split[j]);
				f.get(id).add(v);
				b.get(v).add(id);
			}
		}
		boolean problem = false;
			if (n > 0) {
			{
				Queue<Integer> q = new LinkedList<Integer>();			
				q.add(0);
				BitSet d = new BitSet(n);
				d.set(0);
				while (!q.isEmpty()) {
					int here = q.poll();
					for (int edge : b.get(here)) {
						if (!d.get(edge))
						q.add(edge);
						d.set(edge);
					}
				}
		
				for (int street : streets) {
					if (!d.get(street)) {
						System.out.println("TRAPPED " + street);
						problem = true;
					}
				}
			}
			
			{
				Queue<Integer> q = new LinkedList<Integer>();			
				q.add(0);
				BitSet d = new BitSet(n);
				d.set(0);
				while (!q.isEmpty()) {
					int here = q.poll();
					for (int edge : f.get(here)) {
						if (!d.get(edge))
						q.add(edge);
						d.set(edge);
					}
				}
		
				
				for (int street : streets) {
					if (!d.get(street)){
						System.out.println("UNREACHABLE " + street);
						problem = true;
					}
				}
			}
		}
		if (!problem) System.out.println("NO PROBLEMS");
	}
}

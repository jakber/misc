import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.BitSet;
import java.util.SortedSet;
import java.util.TreeSet;


public class Elevator {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		String[] strings = line.split(" ");
		int f = Integer.parseInt(strings[0]);
		int s = Integer.parseInt(strings[1]);
		int g = Integer.parseInt(strings[2]);
		int u = Integer.parseInt(strings[3]);
		int d = Integer.parseInt(strings[4]);
		
		SortedSet<Integer> q = new TreeSet<Integer>();
		q.add(s);
		int[] dist = new int[f+1];
		for (int i = 0; i < dist.length; i++) dist[i] = Integer.MAX_VALUE;
		dist[s] = 0;
		while (!q.isEmpty()) {
			int here = q.first();
			q.remove(here);
			int up = here+u;
			int down = here-d;
			if (up <= f && dist[here] + 1 < dist[up]) {
				dist[up] = dist[here]+1;
				q.add(up);
			}
			if (down >= 1 && dist[here] + 1 < dist[down]) {
				dist[down] = dist[here]+1;
				q.add(down);
			}
		}
		if (dist[g] == Integer.MAX_VALUE) {
			System.out.println("use the stairs");
		} else 
		System.out.println(dist[g]);
	}
}

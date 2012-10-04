import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

	public class Robots {
		static List<String> grid = new ArrayList<String>();
		static int n;
		static long[][] mem;
		public static void main(String[] args) throws IOException {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String line = in.readLine();
			n = Integer.parseInt(line);
			mem = new long[n][n];
			
			for (int i = 0; i < n; i++) {
				grid.add(in.readLine());
			}

			
			Queue<Coords> q = new LinkedList<Coords>();			
			q.add(new Coords(0,0));
			mem[0][0] = 1;
			
			while (!q.isEmpty()) {
				Coords here = q.poll();
				if (mem[here.y][here.x] < 0) {
					System.out.println("wtf" + here.x + ", "+ here.y);
					return;
				}

				if (isWalkable(here.x+1,here.y)) {
					if (mem[here.y][here.x+1] == 0) 
						q.add(new Coords(here.x+1, here.y));
					mem[here.y][here.x+1] += mem[here.y][here.x] % Integer.MAX_VALUE;
				}
				if (isWalkable(here.x,here.y+1)) {
					if (mem[here.y+1][here.x] == 0) 
						q.add(new Coords(here.x, here.y+1));
					mem[here.y+1][here.x] += mem[here.y][here.x] % Integer.MAX_VALUE;
				}
			}
			
			if (mem[n-1][n-1] != 0)
				System.out.println(mem[n-1][n-1] % Integer.MAX_VALUE);
			else {
				q.add(new Coords(0,0));
				mem = new long[n][n];
				while (!q.isEmpty()) {
					Coords here = q.poll();
					if (isWalkable(here.x+1,here.y) && mem[here.y][here.x+1] == 0) {
						q.add(new Coords(here.x+1, here.y));
						mem[here.y][here.x+1]++;
					}
					if (isWalkable(here.x-1,here.y) && mem[here.y][here.x-1] == 0) {
						q.add(new Coords(here.x-1, here.y));
						mem[here.y][here.x-1]++;
					}
					if (isWalkable(here.x,here.y+1) && mem[here.y+1][here.x] == 0) {
						q.add(new Coords(here.x, here.y+1));
						mem[here.y+1][here.x]++;
					}
					if (isWalkable(here.x,here.y-1) && mem[here.y-1][here.x] == 0) {
						q.add(new Coords(here.x, here.y-1));
						mem[here.y-1][here.x]++;
					}
				}
				if (mem[n-1][n-1] != 0) System.out.println("THE GAME IS A LIE");
				else System.out.println("INCONCEIVABLE");
			}
		}
		
		private static boolean isWalkable(int x, int y) {
			if (x < 0 || x >= n) return false;
			if (y < 0 || y >= n) return false;
			return (grid.get(y).charAt(x) == '.');
		}
		
		
		private static class Coords {
			public int x;
			public int y;
			public Coords(int x, int y) {
				super();
				this.x = x;
				this.y = y;
			}
		}
}

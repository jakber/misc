import java.util.BitSet;


public class Primes {
	public static void main(String[] args) {
		BitSet sieve = new BitSet(10000);
		for (int i = 2; i < sieve.size(); i++) {
			if (!sieve.get(i)) {
				System.out.print(", " + i);
				for (int j = 2*i; j < sieve.size(); j+=i)
					sieve.set(j);
			}
		}
	}
}

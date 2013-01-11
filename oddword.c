#import <stdio.h>


// Found this code, and two variations of the problem online. This program solves neither.
// http://c2.com/cgi/wiki?OddWordProblem
// http://rosettacode.org/wiki/Odd_word_problem

int main() {
	while (1) {
		while (echo_word(getchar()));
		while (reverse_word(getchar()));
		putchar(' ');
	}
}

int echo_word(int c) {
	if (c == EOF) return 0;
	putchar( c );
	return c != ' ';
}

int reverse_word(int c) {
	if (c == EOF) return 0;
	if (c != ' ') {
		reverse_word(getchar());
		putchar( c );
	}
	return 0;
}

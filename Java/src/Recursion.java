
public class Recursion {
//https://www.youtube.com/watch?v=9f7mjOX4z5A
	private void printNums(int num) {
		if (num == 0) {
			return;
		}
		// 5-1
		// System.out.print(num);
		printNums(num - 1);
		// 1-5
		System.out.print(num);
	}

	private int sum(int num) {
		if (num == 0) {
			return 0;
		} else {
			return 2 + sum(num - 1);
		}
	}

	private int power(int base, int num) {
		if (num == 1) {
			return base;
		} else {
			return base * power(base, num - 1);
		}
	}

	// Factorial
	private int fact(int num) {
		if (num == 0 || num == 1) {
			return 1;
		} else {
			return num * fact(num - 1);
		}
	}

	private int add(int num) {
		// System.out.println(num);
		int x = num % 10;
		int y = num / 10;
		if (num < 9) {
			return num;
		} else {
			return x + add(y);
		}
	}

	private int countNum(int count, int num) {
		int x = num % count;
		int y = num / count;

		if (num < 9) {
			return 0;
		}

		if (num == count) {
			return count;
		}
		
		if() {
			
		}
		else {
			return x + add(y);
		}
	}

	public static void main(String[] args) {
		Recursion rec = new Recursion();
		// rec.printNums(5);
		// System.out.println(rec.sum(5));
		// System.out.println(rec.power(3, 3));
		// System.out.println(rec.fact(3));
		System.out.println(rec.add(32134445));

	}
}


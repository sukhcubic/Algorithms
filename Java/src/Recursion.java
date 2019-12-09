
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

		private int countNum(int num) {
			int x = num % 10;
			int y = num / 10;

			if (num <= 9) {
				return num == 5 ? 1:0;
			}else {
			   return x == 5 ?  1+countNum(y) : countNum(y) ;
			}	
		}
			
	
	         private void printBinary(int num) {
			  if(num < 0) {
				  System.out.print("-");
				  printBinary(-num);
			  }
		     else if(num <= 1) {
				System.out.print(num);
				return ;
			}else {
				int x = num % 2;
				int y = num / 2;
			    printBinary(y);
				//System.out.print(x);
			   // or
			    printBinary(x);
			}
		}
	
	       		//https://www.bilibili.com/video/av21619854?p=9  starting around 20:00
		private int evaluateHelper(String expression, int index) {
			if(Character.isDigit(expression.charAt(index))) {
				int result = expression.charAt(index++) - '0';
				return result;
			}else {	
				index++; //get next value
				
				int left = evaluateHelper(expression, index);
				
				char op = expression.charAt(index++);
				
				int right = evaluateHelper(expression, index);
				int result;
                 if(op == '*') {
                	 result = left*right;
                 }else {
                	 result = left+right;
                 }
                 
                 return result;
			}			
		}
		
		private int evaluate(String expression) {
			return evaluateHelper(expression, 0);			
		}

		public static void main(String[] args) {
			Recursion rec = new Recursion();
			// rec.printNums(5);
			// System.out.println(rec.sum(5));
			// System.out.println(rec.power(3, 3));
			// System.out.println(rec.fact(3));
			//System.out.println(rec.add(32134445));
			System.out.println(rec.countNum(33545445));
			rec.printBinary(-5);
		}
}


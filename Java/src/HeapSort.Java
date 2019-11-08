	static int[] a;
	static int lastIndex = a.length - 1;
	
	public static void insert(int element) {
		a[++lastIndex] =  element;
		swim(lastIndex);
	}
	
	public static void delete() {
		a[0] =  a[lastIndex--];	
		sink(0);
	}
	
	private static void swim(int x) {
		while(x >0 && x > x/2) {
			swap(x, x/2);
			 x = x/2;
		}
	}
	
	private static void sink(int x) {
		while(x < lastIndex) {
			swap(x, x/2);
		}
	}
	
	private static void swap(int i, int j){
		int swap = a[i]; 
		a[i] = a[j];
		a[j] = swap; 
	  }

       	private static void heapify(){
	
	  }

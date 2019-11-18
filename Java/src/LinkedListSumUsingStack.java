import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

//Sum of Two Linked Lists using Stacks
//Mentioned at: https://www.ideserve.co.in/learn/sum-of-two-linked-lists-using-stacks
class LinkedListSumUsingStack{
   //Given two numbers which are represented using linked lists as shown below.
	//Your program should return the reference to a new linked list which stores the sum of given two numbers.
	//Numbers are represented as following:
	//Number 99971, corresponding linked list: 9->9->9->7->1
	//Number 998,   corresponding linked list: 9->9->8
	//The output returned by the program for above two linked lists as the input should be the linked list 1->0->0->9->6->9 
	//which represents number 100969 which is sum of numbers 99971 and 998.

	private static LinkedList<Integer> sum(LinkedList<Integer> l1, LinkedList<Integer> l2 ) {
	  Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		ListIterator<Integer> list1 = l1.listIterator();
		ListIterator<Integer> list2 = l2.listIterator();
	    LinkedList<Integer> result = new LinkedList<Integer>();
	    Stack<Integer> s3 = new Stack<Integer>();
	    while(list1.hasNext()) {
	    	s1.push(list1.next());
	    }
	    while(list2.hasNext()) {
	    	s2.push(list2.next());
	    }
	    
      int carry = 0;
    //core logic
	    while(true) {	    	
	    	if(!s1.isEmpty() || !s2.isEmpty() ) {
	    		int addition = 0;
	    		int z1 = s1.isEmpty() ? 0: s1.pop();
	    		int z2 = s2.isEmpty() ? 0: s2.pop();
                addition = (z1+z2+carry)%10;
                carry = (z1+z2+carry)/10;
	    		s3.push(addition);
	 	    }else {
	 	    	if(carry>0) {
	 	    		s3.push(1);
	 	    	}
	 	    	break;
	 	    }
	    }
	    
	    while(!s3.isEmpty()) {
	    	result.add(s3.pop());
	    }
	    return result;
	}
	

	public static void main(String[] args) {
		 LinkedList<Integer> ll1 = new LinkedList<Integer>();
		 LinkedList<Integer> ll2 = new LinkedList<Integer>();
		int[] a = new int[] {9, 9, 9, 9, 7, 1};
		
		int[] b = new int[] {1, 1, 1, 9, 9, 8};
		
		for (int i = 0; i < a.length;  i++) {
			ll1.add(i, a[i]);
	 	}
		
		for (int i = 0; i < b.length;  i++) {
			ll2.add(i, b[i]);
	 	}
	    ListIterator<Integer> list3 = sum(ll1, ll2).listIterator();
	    while(list3.hasNext()) {
	    	System.out.print(list3.next() + "\n");
	    }
	}

}

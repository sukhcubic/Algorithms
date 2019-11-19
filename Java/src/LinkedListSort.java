public class LinkedListSort {

	Node node;

	public void add(int value) {
		Node current = node;
		if (current == null) {
			node = new Node(value);
			return;
		}
		while (current.next != null) {
			current = current.next;
		}
		current.next = new Node(value);
	}

//	private static void sort(Node list, ) {
//
//	}

	private void swap(Node first, Node second) {
		// Taking int data type for now
		int temp = first.data;
		first.data = second.data;
		second.data = temp;
	}

	public int getMiddle() {
		// Move second pointer twice as much get get middle in N/2 time complexity
		Node last = node;
		Node first = node;
		while (last != null) {
			if (last.next != null && last.next.next != null) {
				last = last.next.next;
				first = first.next;
			} else {
				last = null;
			}
		}
		return first.data;
	}

	public static void main(String[] args) {
		LinkedListSort ll = new LinkedListSort();

		int[] a = new int[] { 12, 34, 6, 7, 8, 45, 78, 9809, 1 };

		for (int z : a) {
			ll.add(z);
		}
		System.out.println(ll.getMiddle());
	}
}

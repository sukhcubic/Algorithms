//Sort a linked list of 0s, 1s and 2s by changing links
//Ref: https://www.geeksforgeeks.org/sort-linked-list-0s-1s-2s-changing-links/
public class LinkedListDutchNationalFlag {
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

	private void sort() {

	}

	public static void main(String[] args) {
		LinkedListDutchNationalFlag ll = new LinkedListDutchNationalFlag();

		int[] a = new int[] { 1, 2, 0, 2, 0, 1, 0, 2, 0, 1 };

		for (int z : a) {
			ll.add(z);
		}
		ll.sort();
		while (ll.node != null) {
			System.out.println(ll.node.data);
			ll.node = ll.node.next;
		}
	}
}

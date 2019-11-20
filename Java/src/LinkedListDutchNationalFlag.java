//Sort a linked list of 0s, 1s and 2s by changing links
//Ref: https://www.geeksforgeeks.org/sort-linked-list-0s-1s-2s-changing-links/
//Hint: https://www.codelike.in/c/linked-list/sort-a-linked-list-of-0s-1s-and-2s

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
		// Create three node to hold 0s, 1s and 2s
		Node zero = new Node(0);
		Node one = new Node(0);
		Node two = new Node(0);
		Node current = node;
		// Create three references which will point to head. We need all nodes but head
		Node a = zero;
		Node b = one;
		Node c = two;
		// Assume we have elements in the list
		while (current != null) {

			if (current.data == 0) {
				a.next = current;
				a = a.next;
			} else if (current.data == 1) {
				b.next = current;
				b = b.next;
			} else {
				c.next = current;
				c = c.next;
			}
			current = current.next;
		}

		// Linking all node
		a.next = one.next;
		b.next = two.next;
		// last node null to break look
		c.next = null;
		node = zero.next;
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

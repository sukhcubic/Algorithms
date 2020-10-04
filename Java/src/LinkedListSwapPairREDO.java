public class LinkedListSwapPairREDO {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
         //Given 1->2->3->4, you should return the list as 2->1->4->3.

            ListNode save = head.next.next;
            ListNode ret = head.next;
            head.next.next = head;
            head.next = swapPairs(save);
            //Because we swapped this became new head
            return ret;

        }

        public ListNode swapPairsIterative(ListNode head) {

            // Dummy node acts as the prevNode for the head node
            // of the list and hence stores pointer to the head node.
            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode prevNode = dummy;

            while ((head != null) && (head.next != null)) {

                // Nodes to be swapped
                ListNode firstNode = head;
                ListNode secondNode = head.next;

                // Swapping
                prevNode.next = secondNode;
                firstNode.next = secondNode.next;
                secondNode.next = firstNode;

                // Reinitializing the head and prevNode for next swap
                prevNode = firstNode;
                head = firstNode.next; // jump
            }

            // Return the new head node.
            return dummy.next;
        }
}

public class LinkedListMergeSortedListsREVISIT {
// https://leetcode.com/problems/merge-two-sorted-lists/


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null && l2 == null){
            return null;
        }
        return helper(l1, l2);
    }

    ListNode helper(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }else if(l1.val < l2.val){
            l1.next = helper(l1.next, l2);
            return l1;
        }else {
            l2.next = helper(l1, l2.next);
            return l2;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}

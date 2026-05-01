/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ref = head;
        for(int i = 0; i < n;i++){
            ref = ref.next;
        }
        if(ref == null) return head.next;
        ListNode curr = head;
        while(ref.next != null){
            ref = ref.next;
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}

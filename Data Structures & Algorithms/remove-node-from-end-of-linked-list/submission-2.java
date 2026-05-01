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
        if(head == null) return null;
        ListNode refer = head;
        for(int i = 0; i < n;i++){
            refer = refer.next;
        }
        if (refer == null) {
            return head.next;
        }
        ListNode current = head;
        while(refer.next != null){
            refer = refer.next;
            current = current.next;
        }
        
        ListNode temp = current.next;
        current.next = current.next.next;
        temp.next= null;
        return head;
    }
}

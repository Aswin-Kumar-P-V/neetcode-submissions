# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        fast= slow = head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        current = slow.next
        slow.next = prev = None
        while current:
            temp = current.next
            current.next = prev
            prev = current
            current = temp
        head2 = prev
        head1 = head
        while head2:
            t1, t2 = head1.next, head2.next
            head1.next = head2
            head2.next = t1
            head1, head2 = t1,t2
        
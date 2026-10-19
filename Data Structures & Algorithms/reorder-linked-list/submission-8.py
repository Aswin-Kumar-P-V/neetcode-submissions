# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        secondPart = slow.next
        prev, curr = None, secondPart
        slow.next = None
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        secondhead = prev
        firsthead = head
        while secondhead:
            tempfirsthead = firsthead.next
            tempsecondhead = secondhead.next
            firsthead.next = secondhead
            secondhead.next = tempfirsthead
            firsthead = tempfirsthead
            secondhead = tempsecondhead
        
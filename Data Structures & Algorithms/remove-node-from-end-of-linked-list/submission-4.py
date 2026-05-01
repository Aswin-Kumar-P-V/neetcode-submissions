# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        refer=current=head
        for i in range(n):
            refer = refer.next
        if refer == None:
            return head.next
        while refer.next:
            refer = refer.next
            current=current.next
        current.next=current.next.next
        return head
        
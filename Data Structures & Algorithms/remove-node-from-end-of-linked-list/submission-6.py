# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        ref= head
        for i in range(n):
            ref = ref.next
        cur = head
        if not ref:
            return head.next
        while ref.next:
            ref = ref.next
            cur = cur.next
        cur.next = cur.next.next
        return head
        
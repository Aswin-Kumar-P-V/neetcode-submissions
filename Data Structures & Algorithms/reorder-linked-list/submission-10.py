# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        slow = fast =list1 = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        curr = slow.next
        slow.next = prev = None
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        list2 = prev
        while list2:
            templ1 = list1.next
            templ2 = list2.next
            list1.next, list2.next = list2, templ1
            list1, list2 = templ1, templ2

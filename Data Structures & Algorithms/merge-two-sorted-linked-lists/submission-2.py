# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        Dummy= newnode = ListNode()
        while list1 and list2:
            if list1.val <= list2.val:
                newnode.next = list1
                list1=list1.next
            else:
                newnode.next=list2
                list2=list2.next
            newnode = newnode.next
        if list1:
            newnode.next = list1
        else:
            newnode.next = list2
        return Dummy.next

        
        
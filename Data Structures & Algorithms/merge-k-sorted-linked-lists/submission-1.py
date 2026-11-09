# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:    
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if len(lists) == 0:
            return None
        count = 0
        min_heap = []
        for i, node in enumerate(lists):
            if node:
                heapq.heappush(min_heap, [node.val, count, node])
                count += 1
        dummy = ListNode()
        curr = dummy
        while min_heap:
            val, count, node = heapq.heappop(min_heap)
            curr.next = node
            curr = curr.next
            node = node.next
            if node:
                heapq.heappush(min_heap, [node.val, count, node])
                count += 1
        return dummy.next
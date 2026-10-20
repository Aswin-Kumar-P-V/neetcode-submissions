class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.prev = self.next = None
class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache = {}
        self.left, self.right = Node(0, 0), Node(0, 0)
        self.left.next, self.right.prev = self.right, self.left
    
    
    def remove(self, node):
        prev, nxt = node.prev, node.next
        prev.next = nxt
        nxt.prev = prev
        node.left = node.right = None
        

    def insert(self, node):
        prev, curr = self.right.prev, self.right
        prev.next = node
        curr.prev = node
        node.prev = prev
        node.next = curr

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        node = self.cache[key]
        self.remove(node)
        self.insert(node)
        return node.value
        
    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            self.remove(self.cache[key])
        node = Node(key, value)
        self.cache[key] = node
        self.insert(node)

        if len(self.cache) > self.capacity:
            node = self.left.next
            self.remove(node)
            del self.cache[node.key]
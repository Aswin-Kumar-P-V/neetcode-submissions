class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.prev = self.next = None

class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache = {}
        self.left, self.right = Node(0,0), Node(0, 0)
        self.left.next = self.right
        self.right.prev = self.left
 
    def remove(self, node):
        prev = node.prev
        nxt = node.next
        prev.next, nxt.prev = nxt, prev

    def insert(self, node):
        prev, right = self.right.prev, self.right
        prev.next = node
        right.prev = node
        node.prev, node.next = prev, right

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
        self.cache[key] = Node(key, value)
        self.insert(self.cache[key])

        if len(self.cache) > self.capacity:
            node = self.left.next
            self.remove(node)
            del self.cache[node.key]

        
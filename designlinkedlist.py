class Node:
    def __init__(self, val=0, n=None):
        self.val = val
        self.next = n
class MyLinkedList:
    def __init__(self):
        self.head = None
        self.length = 0

    def get(self, index: int) -> int:
        if index < 0 or index >= self.length:
            return -1
        cur = self.head
        while index > 0:
            cur = cur.next
            index -= 1
        return cur.val

    def addAtHead(self, val: int) -> None:
        newHead = Node(val, self.head)
        self.head = newHead
        self.length += 1

    def addAtTail(self, val: int) -> None:
        if self.head is None:
            self.head = Node(val)
            self.length += 1
            return

        cur = self.head
        while cur.next:
            cur = cur.next

        cur.next = Node(val)
        self.length += 1

    def addAtIndex(self, index: int, val: int) -> None:
        if index < 0 or index > self.length:
            return

        if index == 0:
            self.addAtHead(val)
            return

        cur = self.head
        for _ in range(index - 1):
            cur = cur.next

        cur.next = Node(val, cur.next)
        self.length += 1

    def deleteAtIndex(self, index: int) -> None:
        if index < 0 or index >= self.length:
            return

        if index == 0:
            self.head = self.head.next
            self.length -= 1
            return

        cur = self.head
        for _ in range(index - 1):
            cur = cur.next

        cur.next = cur.next.next
        self.length -= 1
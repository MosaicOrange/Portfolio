def insert(self,head,data):
    if head is None:
        return Node(data)
    elif head.next is None:
        head.next = Node(data)
    else:
        self.insert(head.next,data)
    return head
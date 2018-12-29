    def removeDuplicates(self,head):
        tmp_set = set()
        queue = [head]
        while queue:
            node_itm = queue.pop(0)
            tmp_set.add(node_itm.data)
            if node_itm.next:
                queue.append(node_itm.next)
        for i in sorted(tmp_set):
            print(i, end=" ")
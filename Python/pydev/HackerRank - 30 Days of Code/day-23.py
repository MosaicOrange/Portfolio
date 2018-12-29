def levelOrder(self,root):
    tmp_str = ""
    queue = [root]
    while queue:
        node_itm = queue.pop(0)
        tmp_str += str(node_itm.data) + " "
        if node_itm.left:
            queue.append(node_itm.left)
        if node_itm.right:
            queue.append(node_itm.right)
    print(tmp_str.strip())
    def getHeight(self,root):
        value = 0
        if root.left is not None and root.right is not None:
            if self.getHeight(root.left) > self.getHeight(root.right):
                value += 1 + self.getHeight(root.left)
            else:
                value += 1 + self.getHeight(root.right)
        elif root.left is not None:
            value += 1 + self.getHeight(root.left)
        elif root.right is not None:
            value += 1 + self.getHeight(root.right)
        else:
            return 0
        return value
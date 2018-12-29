class Solution:
    def __init__(self):
        self.stack = []
        self.queue = []

    def pushCharacter(self, ch_arr):
        for c in ch_arr:
            self.stack.append(c)

    def enqueueCharacter(self, ch_arr):
        for c in ch_arr:
            self.queue.insert(0,c)

    def popCharacter(self):
        return self.stack.pop()

    def dequeueCharacter(self):
        return self.queue.pop()
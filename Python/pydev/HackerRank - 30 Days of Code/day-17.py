#Write your code here
class Calculator:
    def __init__(self):
        self

    def power(self,n,p):
        if isinstance(n,int) and isinstance(p,int):
            if n >= 0 and p >= 0:
                return n**p
        return "n and p should be non-negative"
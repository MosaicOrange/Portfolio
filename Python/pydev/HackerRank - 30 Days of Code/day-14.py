# Add your code here
def computeDifference(self):
	templist = sorted(self.__elements, key=int)
	self.maximumDifference = abs(templist[0] - templist[len(templist)-1])
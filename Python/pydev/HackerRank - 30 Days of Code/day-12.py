class Student(Person):
    def __init__(self, firstName, lastName, id, scores):
        Person.__init__(self, firstName, lastName, id)
        self.scores = scores
    
    def calculate(self):
        grade = float(sum(self.scores)/len(self.scores))
        if grade >= 90 and grade <= 100:
            return ("O")
        if grade >= 80 and grade < 90:
            return ("E")
        if grade >= 70 and grade < 80:
            return ("A")
        if grade >= 55 and grade < 70:
            return ("P")
        if grade >= 40 and grade < 55:
            return ("D")
        if grade < 40:
            return ("T")


print("How old are you in years?", end=' ')
age = input()
print("How tall are you in inches?", end=' ')
height = input()
print("How much do you weigh in pounds?", end=' ')
weight = input()

bmi = '{0:.2f}'.format( ( int(weight) / ( int(height) ** 2 ) ) * 703 )

print(f"So, you're {age} years old, {height} inches tall, weight {weight} pounds, and have a BMI of {bmi}.")
# having alittle fun by including BMI from already provided information

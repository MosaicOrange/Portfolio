import math

side_AB = int(input().strip())
side_BC = int(input().strip())

side_CM = (math.sqrt((side_AB**2) + (side_BC**2)))/2
cos_ACB = side_BC/(side_CM*2)
side_BM = math.sqrt((side_BC**2)+(side_CM**2)-(2*side_CM*side_BC*cos_ACB))
angle_MBC = (math.acos(((side_BM**2) + (side_BC**2) - (side_CM**2))/(2*side_BM*side_BC)))*(180/math.pi)

print(str(round(angle_MBC)) + u"\N{DEGREE SIGN}")
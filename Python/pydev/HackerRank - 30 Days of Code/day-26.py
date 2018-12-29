actual_date = [int(x) for x in input().strip().split(" ")]
expected_date = [int(x) for x in input().strip().split(" ")]

actual_day = actual_date[0]
actual_month = actual_date[1]
actual_year = actual_date[2]
expected_day = expected_date[0]
expected_month = expected_date[1]
expected_year = expected_date[2]

if expected_year >= actual_year:
    if expected_month >= actual_month or (expected_month < actual_month and expected_year > actual_year):
        if expected_day >= actual_day or (expected_day < actual_day and (expected_month > actual_month or expected_year > actual_year)):
            print("0")
        else:
            print(str(15*(actual_date[0] - expected_date[0])))
    else:
        print(str(500*(actual_date[1] - expected_date[1])))
else:
    print("10000")
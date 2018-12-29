from datetime import datetime

def assign_papers1(the_judges, the_papers, the_factor):
    some_value = (the_factor * (len(the_papers)) // len(the_judges))
    another_value = (the_factor * (len(the_papers)) % len(the_judges))
    start_value = 0
    end_value = some_value
    composite_dict = dict()
    for i, j in enumerate(the_judges):
        if i < another_value:
            end_value += 1
        if end_value > len(the_papers):
            tmp_value = end_value - len(the_papers)
            tmp_list = the_papers[start_value:len(the_papers)] + the_papers[0:tmp_value]
            composite_dict[j] = tmp_list
            start_value = tmp_value
            end_value = start_value + some_value
        else:
            tmp_list = the_papers[start_value:end_value]
            composite_dict[j] = tmp_list
            start_value = end_value
            end_value += some_value
    return composite_dict

def assign_papers2(the_judges, the_papers, the_factor):
    total_list = the_papers * the_factor
    some_value = len(total_list) // len(the_judges)
    another_value = len(total_list) % len(the_judges)
    start_value = 0
    end_value = some_value
    composite_dict = dict()
    i = 0
    for j in the_judges:
        if i < another_value:
            end_value += 1
            i += 1
        tmp_list = total_list[start_value:end_value]
        composite_dict[j] = tmp_list
        start_value = end_value
        end_value += some_value
    return composite_dict

the_judges = [("Judge " + str(x)) for x in range(1,10)]
the_papers = [x for x in range(1,151)]
the_factor = 2
assigned_dict = assign_papers1(the_judges, the_papers, the_factor)


for k in assigned_dict:
    print(k, "|->", assigned_dict[k])
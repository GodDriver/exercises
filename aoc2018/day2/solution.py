"""Day 2"""

from collections import Counter

filename = 'input'

#Part 1

two_times = sum([1 for line in open(filename)\
                    if 2 in Counter(line).values()])
three_times = sum([1 for line in open(filename)\
                    if 3 in Counter(line).values()])

print(two_times * three_times)

#Part 2

lines = [line.strip() for line in open(filename)]
search = False
for i in range(0, len(lines)):
    a = lines[i]
    for j in range(i + 1, len(lines)):
        b = lines[j]
        diff = 0
        k = 0
        letters = ''
        while diff <= 1 and k < len(a):
            if a[k] != b[k]:
                diff += 1
            else:
                letters += a[k]
            k += 1
        if diff == 1:
            print(letters)
            search = True
            break

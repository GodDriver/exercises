"""Day 2"""

from collections import Counter

filename = 'input'

#Part 1

two_times = sum([1 for letters in open(filename)\
                    if 2 in Counter(letters).values()])
three_times = sum([1 for letters in open(filename)\
                    if 3 in Counter(letters).values()])

print(two_times * three_times)

#Part 2



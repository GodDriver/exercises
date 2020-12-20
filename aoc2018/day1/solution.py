"""Day 1"""

filename = 'input'

# Part 1

print(sum([int(change) for change in open(filename)]))

# Part 2

change = [int(change) for change in open(filename)]
frequency = 0
frequencies = {}
frequencies[frequency] = 1
i = 0
while True:
    frequency += change[i % len(change)]
    i += 1
    if frequency not in frequencies:
        frequencies[frequency] = 1
    else:
        print(frequency)
        break

"""Day 5"""

def nice_strings():
    """
    How many strings are nice?
    How many strings are nice under new rules?
    """

    filename = '/home/goddriver/Documents/exercises/aoc2015/5/input'

    with open(filename) as f_input:
        lines = f_input.readlines()
    #Old rules
    not_contains = ['ab', 'cd', 'pq', 'xy']
    vowels = ['a', 'e', 'i', 'o', 'u']
    nice_lines = 0
    for line in lines:
        line = line.lower()
        if all(not_contain not in line.lower()
               for not_contain in not_contains):
            count = 0
            for i in line:
                for vowel in vowels:
                    if i == vowel:
                        count += 1
            if count > 2:
                count = 0
                for i in range(len(line) - 1):
                    if line[i] == line[i + 1]:
                        count += 1
                if count > 0:
                    nice_lines += 1
    print(f"Nice strings are {nice_lines}.")

    #New rules
    new_nice_lines = 0
    for line in lines:
        line = line.lower()
        count = 0
        for i in range(len(line) - 2):
            if line[i] == line[i + 2]:
                count += 1
        if count > 0:
            count = 0
            for i in range(len(line) - 3):
                for n_int in range(0, len(line)):
                    if n_int + i < len(line) - 2:
                        if (line[i] == line[i + 2 + n_int]
                            and line[i + 1] == line[i + 3 + n_int]):
                            count += 1
            if count > 0:
                new_nice_lines += 1

    print("Nice strings under new rules are: " + str(new_nice_lines))
nice_strings()

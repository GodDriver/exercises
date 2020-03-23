def nice_strings():
    """
    How many strings are nice?
    How many strings are nice under new rules?
    """

    filename = '/home/goddriver/Documents/exercises/aoc2015/5/input'

    with open(filename) as f:
        lines = f.readlines()
        
    #Old rules
    not_contains = ['ab', 'cd', 'pq', 'xy']
    vowels = ['a', 'e', 'i', 'o', 'u']
        
    nice_lines = 0
    
    for line in lines:
        if all(not_contain not in line.lower() for not_contain in not_contains):
            count = 0
            for i in line:
                for vowel in vowels:
                    if i.lower() == vowel:
                        count += 1
                    
            if count > 2:
                count = 0
                for i in range(len(line) - 1):
                    if line[i].lower() == line[i + 1].lower():
                        count += 1

                if count > 0:
                    nice_lines += 1
                    
    print("Nice strings are: " + str(nice_lines))

    #New rules
    new_nice_lines = 0

    for line in lines:
        count = 0
        for i in range(len(line) - 2):
            if line[i].lower() == line[i + 2].lower():
                count += 1

        if count > 0:
            count = 0
            for i in range(len(line) - 3):
                for n in range(0, len(line)):
                    if n + i < len(line) - 2:
                        if (line[i].lower() == line[i + 2 + n].lower()
                            and line[i + 1].lower() == line[i + 3 + n].lower()):
                            count += 1
            if count > 0:
                new_nice_lines += 1

    print("Nice strings under new rules are: " + str(new_nice_lines))           

nice_strings()

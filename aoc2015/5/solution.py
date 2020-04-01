"""Day 5"""

def get_nice_string(string: str) -> bool:
    """If string is nice - return True, if not - False."""

    not_contains = ['ab', 'cd', 'pq', 'xy']
    vowels = ['a', 'e', 'i', 'o', 'u']
    string = string.lower()
    if all(not_contain not in string
           for not_contain in not_contains):
        count = 0
        for i in string:
            for vowel in vowels:
                if i == vowel:
                    count += 1
        if count >= 3:
            count = 0
            for i in range(len(string) - 1):
                if string[i] == string[i + 1]:
                    count += 1
            if count > 0:
                return True
            else:
                return False
        else:
            return False
    else:
        return False

def get_nice_string_new_rules(string: str) -> bool:
    """If string is nice under new rules - return True, if not - False."""

    string = string.lower()
    count = 0
    for i in range(len(string) - 2):
        if string[i] == string[i + 2]:
            count += 1
    if count > 0:
        count = 0
        for i in range(len(string) - 3):
            for n_int in range(0, len(string)):
                if n_int + i < len(string) - 3:
                    if (string[i] == string[i + 2 + n_int]
                            and string[i + 1] == string[i + 3 + n_int]):
                        count += 1
        if count > 0:
            return True
        else:
            return False
    else:
        return False

def main():
    """Main."""
    filename = '/home/goddriver/Documents/exercises/aoc2015/5/input'

    with open(filename) as f_input:
        lines = f_input.readlines()

    nice_lines = 0 #Old rules
    nice_lines_new_rules = 0 #New rules

    for line in lines:
        if get_nice_string(line) == 1:
            nice_lines += 1
        if get_nice_string_new_rules(line) == 1:
            nice_lines_new_rules += 1

    print(f"Number of nice strings is {nice_lines}.")
    print(f"Number of nice strings under new rules is \
{nice_lines_new_rules}.")

if __name__ == "__main__":
    main()

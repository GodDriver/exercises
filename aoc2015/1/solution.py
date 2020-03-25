"""Day 1"""

def floor_and_basement():
    """
    To what floor do the instructions take Santa?
    What is the position of the character that causes Santa to first enter \
    the basement?
    """

    filename = '/home/goddriver/Documents/exercises/aoc2015/1/input'
    with open(filename) as f_input:
        lines = f_input.readlines()

    floor = 0
    first_enter = 0
    i = 0

    for line in lines:
        for element in line:
            if element == '(':
                floor += 1
                first_enter += 1
            elif element == ')':
                floor -= 1
                first_enter += 1
            if floor == -1 and i == 0:
                print(f"First enter the basement was on {first_enter} step.")
                i += 1
    print(f"Floor in the instructions is {floor}.")
floor_and_basement()

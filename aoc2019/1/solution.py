import math

def the_tyranny_of_the_rocket_equation():
    """
    What is the sum of the fuel requirements for all of the modules on your
    spacecraft?
    What is the sum of the fuel requirements for all of the modules on your
    spacecraft when also taking into account the mass of the added fuel?
    """

    filename = '/home/goddriver/Documents/exercises/aoc2019/1/input'
    with open(filename) as f_input:
        lines = f_input.readlines()

    sum_of_the_fuel = 0
    sum_of_the_fuel_with_added = 0

    for line in lines:
        #part 1
        sum_of_the_fuel += math.floor(int(line)/3) - 2
        #part 2
        while int(line) > 5:
            line = math.floor(int(line)/3) - 2
            sum_of_the_fuel_with_added += int(line)

    print(f"The sum of the fuel requirements for all of the modules on your \
spacecraft is {sum_of_the_fuel}.")
    print(f"The sum of the fuel requirements for all of the modules on your \
spacecraft when also taking into account the mass of the added fuel is \
{sum_of_the_fuel_with_added}.")
the_tyranny_of_the_rocket_equation()

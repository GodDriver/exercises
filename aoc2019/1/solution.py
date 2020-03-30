"""Day 1"""

def the_tyranny_of_the_rocket_equation(filename: None) -> int:
    """
    What is the sum of the fuel requirements for all of the modules on your
    spacecraft?
    What is the sum of the fuel requirements for all of the modules on your
    spacecraft when also taking into account the mass of the added fuel?
    """

    with open(filename) as f_i:
        lines = f_i.readlines()

    sum_of_the_fuel = 0
    sum_of_the_fuel_with_added = 0

    for line in lines:
        #part 1
        sum_of_the_fuel += int(line)//3 - 2
        #part 2
        while int(line) > 5:
            line = int(line)//3 - 2
            sum_of_the_fuel_with_added += int(line)

    print(f"The sum of the fuel requirements for all of the modules on your \
spacecraft is {sum_of_the_fuel}.")
    print(f"The sum of the fuel requirements for all of the modules on your \
spacecraft when also taking into account the mass of the added fuel is \
{sum_of_the_fuel_with_added}.")

if __name__ == "__main__":
    FILE = '/home/goddriver/Documents/exercises/aoc2019/1/input'
    the_tyranny_of_the_rocket_equation(FILE)

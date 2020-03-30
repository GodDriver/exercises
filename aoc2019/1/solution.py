"""Day 1"""

def get_fuel_one_module(mass: int) -> int:
    """The fuel for one module."""
    fuel_one_module = mass // 3 - 2
    return fuel_one_module

def get_fuel_one_module_with_added(mass: int) -> int:
    """The fuel for one module with the added fuel."""
    fuel_one_module_with_added = 0
    while mass > 5:
        mass = mass // 3 - 2
        fuel_one_module_with_added += mass
    return fuel_one_module_with_added

if __name__ == "__main__":
    filename = '/home/goddriver/Documents/exercises/aoc2019/1/input'
    with open(filename) as f_i:
        lines = f_i.readlines()

    sum_of_the_fuel = 0
    sum_of_the_fuel_with_added = 0

    for line in lines:
        line = int(line)
        #part 1
        sum_of_the_fuel += get_fuel_one_module(line)
        #part 2
        sum_of_the_fuel_with_added += get_fuel_one_module_with_added(line)

    print(f"The sum of the fuel requirements for all of the modules on your \
spacecraft is {sum_of_the_fuel}.")
    print(f"The sum of the fuel requirements for all of the modules on your \
spacecraft when also taking into account the mass of the added fuel is \
{sum_of_the_fuel_with_added}.")

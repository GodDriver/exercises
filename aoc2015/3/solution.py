"""Day 3"""

def number_of_houses():
    """
    How many houses receive at least one present?
    This year, how many houses receive at least one present?
    """

    filename = '/home/goddriver/Documents/exercises/aoc2015/3/input'
    with open(filename) as f_input:
        lines = f_input.readlines()
    # previous year
    x_int = 0
    y_int = 0
    coordinates_of_houses_prev_year = []
    coordinates_of_houses_prev_year.append((x_int, y_int))
    for line in lines:
        for element in line:
            if element == '^':
                y_int += 1
                coordinates_of_houses_prev_year.append((x_int, y_int))
            elif element == 'v':
                y_int -= 1
                coordinates_of_houses_prev_year.append((x_int, y_int))
            elif element == '>':
                x_int += 1
                coordinates_of_houses_prev_year.append((x_int, y_int))
            elif element == '<':
                x_int -= 1
                coordinates_of_houses_prev_year.append((x_int, y_int))
    print(f"Number of houses is \
{len(list(set(coordinates_of_houses_prev_year)))}.")
    # next year
    x_int = 0
    y_int = 0
    xx_int = 0
    yy_int = 0
    i = 0
    coordinates_of_houses_santa = []
    coordinates_of_houses_robo_santa = []
    coordinates_of_houses_next_year = []
    coordinates_of_houses_santa.append((x_int, y_int))
    coordinates_of_houses_robo_santa.append((xx_int, yy_int))

    for line in lines:
        for element in line:
            if element == '^':
                if i % 2 == 0:
                    y_int += 1
                    coordinates_of_houses_santa.append((x_int, y_int))
                    i += 1
                else:
                    yy_int += 1
                    coordinates_of_houses_robo_santa.append((xx_int, yy_int))
                    i += 1
            elif element == 'v':
                if i % 2 == 0:
                    y_int -= 1
                    coordinates_of_houses_santa.append((x_int, y_int))
                    i += 1
                else:
                    yy_int -= 1
                    coordinates_of_houses_robo_santa.append((xx_int, yy_int))
                    i += 1
            elif element == '>':
                if i % 2 == 0:
                    x_int += 1
                    coordinates_of_houses_santa.append((x_int, y_int))
                    i += 1
                else:
                    xx_int += 1
                    coordinates_of_houses_robo_santa.append((xx_int, yy_int))
                    i += 1
            elif element == '<':
                if i % 2 == 0:
                    x_int -= 1
                    coordinates_of_houses_santa.append((x_int, y_int))
                    i += 1
                else:
                    xx_int -= 1
                    coordinates_of_houses_robo_santa.append((xx_int, yy_int))
                    i += 1

    coordinates_of_houses_next_year = (coordinates_of_houses_santa
                                       + coordinates_of_houses_robo_santa)
    print(f"Number of houses next year is \
{len(list(set(coordinates_of_houses_next_year)))}.")
number_of_houses()

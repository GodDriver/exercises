"""Day 3"""

def get_number_of_houses(moves: str) -> int:
    """Calculation number of houses."""

    x_int, y_int = 0, 0
    coordinates_of_houses = []
    coordinates_of_houses.append((x_int, y_int))
    for move in moves:
        if move == '^':
            y_int += 1
        elif move == 'v':
            y_int -= 1
        elif move == '>':
            x_int += 1
        elif move == '<':
            x_int -= 1
        coordinates_of_houses.append((x_int, y_int))
    return len(list(set(coordinates_of_houses)))

def get_number_of_houses_next_year(moves: str) -> int:
    """Calculation number of houses next year."""

    xs_int, ys_int = 0, 0
    xr_int, yr_int = 0, 0
    i = 0
    coordinates_of_houses_santa = []
    coordinates_of_houses_robo_santa = []
    coordinates_of_houses_santa.append((xs_int, ys_int))
    coordinates_of_houses_robo_santa.append((xr_int, yr_int))

    for move in moves:
        if move == '^':
            if i % 2 == 0:
                ys_int += 1
                coordinates_of_houses_santa.append((xs_int, ys_int))
            else:
                yr_int += 1
                coordinates_of_houses_robo_santa.append((xr_int, yr_int))
            i += 1
        elif move == 'v':
            if i % 2 == 0:
                ys_int -= 1
                coordinates_of_houses_santa.append((xs_int, ys_int))
            else:
                yr_int -= 1
                coordinates_of_houses_robo_santa.append((xr_int, yr_int))
            i += 1
        elif move == '>':
            if i % 2 == 0:
                xs_int += 1
                coordinates_of_houses_santa.append((xs_int, ys_int))
            else:
                xr_int += 1
                coordinates_of_houses_robo_santa.append((xr_int, yr_int))
            i += 1
        elif move == '<':
            if i % 2 == 0:
                xs_int -= 1
                coordinates_of_houses_santa.append((xs_int, ys_int))
            else:
                xr_int -= 1
                coordinates_of_houses_robo_santa.append((xr_int, yr_int))
            i += 1

    return len(list(set(coordinates_of_houses_santa
                        + coordinates_of_houses_robo_santa)))

if __name__ == "__main__":
    filename = '/home/goddriver/Documents/exercises/aoc2015/3/input'

    with open(filename) as f_input:
        instructions = f_input.read()
    # year
    print(f"Number of houses is {get_number_of_houses(instructions)}.")
    # next year
    print(f"Number of houses next year is \
{get_number_of_houses_next_year(instructions)}.")

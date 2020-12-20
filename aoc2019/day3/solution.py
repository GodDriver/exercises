"""Day 3"""

def crossed_wires():
    """
    What is the Manhattan distance from the central port to the closest
    intersection?
    What is the fewest combined steps the wires must take to reach an
    intersection?
    """
    filename = '/home/goddriver/Documents/exercises/aoc2019/3/input'

    coord_1 = {}
    coord_2 = {}
    sum_distances = []
    sum_steps = []
    with open(filename, 'r') as f_i:
        lines = f_i.readlines()
    for line in lines:
        x_int, y_int = 0, 0
        steps = 0
        line = line.strip().split(',')
        for element in line:
            element = element.lower()
            i = int(element[1:])
            if element.startswith('r'):
                while i > 0:
                    i -= 1
                    x_int += 1
                    steps += 1
                    if line == lines[0].strip().split(','):
                        coord_1[x_int, y_int] = steps
                    elif line == lines[1].strip().split(','):
                        coord_2[x_int, y_int] = steps
            elif element.startswith('l'):
                while i > 0:
                    i -= 1
                    x_int -= 1
                    steps += 1
                    if line == lines[0].strip().split(','):
                        coord_1[x_int, y_int] = steps
                    elif line == lines[1].strip().split(','):
                        coord_2[x_int, y_int] = steps
            elif element.startswith('u'):
                while i > 0:
                    i -= 1
                    y_int += 1
                    steps += 1
                    if line == lines[0].strip().split(','):
                        coord_1[x_int, y_int] = steps
                    elif line == lines[1].strip().split(','):
                        coord_2[x_int, y_int] = steps
            elif element.startswith('d'):
                while i > 0:
                    i -= 1
                    y_int -= 1
                    steps += 1
                    if line == lines[0].strip().split(','):
                        coord_1[x_int, y_int] = steps
                    elif line == lines[1].strip().split(','):
                        coord_2[x_int, y_int] = steps
    coord = set(coord_1.keys() & coord_2.keys())
    for key in coord:
        dist_x, dist_y = key
        sum_distances.append(abs(int(dist_x)) + abs(int(dist_y)))
        sum_steps.append(int(coord_1.get(key)) + int(coord_2.get(key)))
    print(f"Manhattan distance from the central port to the closest \
intersection is {min(sum_distances)}.")
    print(f"The fewest combined steps the wires must take to reach an \
intersection is {min(sum_steps)}.")
crossed_wires()

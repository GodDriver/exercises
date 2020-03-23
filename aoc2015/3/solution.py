def number_of_houses():
    """Вычисление числа домов, которые получат хотя бы один подарок."""

    filename = '/home/goddriver/Documents/python/AOC2015/3/input'
    
    with open(filename) as f:
        lines = f.readlines()
    # previous year
    x = 0
    y = 0
    coordinates_of_houses_prev_year = []
    coordinates_of_houses_prev_year.append((x,y))
    
    for line in lines:
        for el in line:
            if el == '^':
                y += 1
                coordinates_of_houses_prev_year.append((x,y))
            elif el == 'v':
                y -= 1
                coordinates_of_houses_prev_year.append((x,y))
            elif el == '>':
                x += 1
                coordinates_of_houses_prev_year.append((x,y))
            elif el == '<':
                x -= 1
                coordinates_of_houses_prev_year.append((x,y))
    
    print(f"Number of houses is \
{len(list(set(coordinates_of_houses_prev_year)))}.")
    # next year
    x = 0
    y = 0
    xx = 0
    yy = 0
    i = 0
    coordinates_of_houses_santa = []
    coordinates_of_houses_robo_santa = []
    coordinates_of_houses_next_year = []
    coordinates_of_houses_santa.append((x,y))
    coordinates_of_houses_robo_santa.append((xx,yy))

    for line in lines:
        for el in line:
            if el == '^':
                if i % 2 == 0:
                    y += 1
                    coordinates_of_houses_santa.append((x,y))
                    i += 1
                else:
                    yy += 1
                    coordinates_of_houses_robo_santa.append((xx,yy))
                    i += 1
            elif el == 'v':
                if i % 2 == 0:
                    y -= 1
                    coordinates_of_houses_santa.append((x,y))
                    i += 1
                else:
                    yy -= 1
                    coordinates_of_houses_robo_santa.append((xx,yy))
                    i += 1
            elif el == '>':
                if i % 2 == 0:
                    x += 1
                    coordinates_of_houses_santa.append((x,y))
                    i += 1
                else:
                    xx += 1
                    coordinates_of_houses_robo_santa.append((xx,yy))
                    i += 1
            elif el == '<':
                if i % 2 == 0:
                    x -= 1
                    coordinates_of_houses_santa.append((x,y))
                    i += 1
                else:
                    xx -= 1
                    coordinates_of_houses_robo_santa.append((xx,yy))
                    i += 1

    coordinates_of_houses_next_year = (coordinates_of_houses_santa
                                       + coordinates_of_houses_robo_santa)
    
    print(f"Number of houses next year is \
{len(list(set(coordinates_of_houses_next_year)))}.")
number_of_houses()            

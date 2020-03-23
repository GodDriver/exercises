def floor_and_basement():
    """
    Вычисление этажа из инструкции, взятую Сантой.
    Вычисление первого входа в подвал.
    """
    filename = '/home/goddriver/Documents/python/AOC2015/1/input'
    with open(filename) as f:
        lines = f.readlines()

    floor = 0
    first_enter = 0
    i = 0

    for line in lines:
        for el in line:
            if el == '(':
                floor += 1
                first_enter += 1
                if floor == -1 and i == 0:
                    print(f"First enter on the basement was on "
                          + str(first_enter) + " step.")
                    i += 1
            elif el == ')':
                floor -= 1
                first_enter += 1
                if floor == -1 and i == 0:
                    print(f"First enter on the basement was on "
                          + str(first_enter) + " step.")
                    i += 1
    print(f"Floor in the instructions is " + str(floor) + ".")

floor_and_basement()

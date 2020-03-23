def calculation_square_feet_of_wrapping_paper_and_feet_of_ribbon():
    """
    Вычисление необходимого количества оберточной бумаги и ленты.
    """
    filename = '/home/goddriver/Documents/python/AOC2015/2/input'
    with open(filename) as f:
        lines = f.readlines()

    square_feet = 0
    feet_of_ribbon = 0

    for line in lines:
        line = line.rstrip()
        numbers = line.split("x")
        numbers = list(map(int, numbers))
        (length, width, height) = numbers
        if ((min(numbers) == width and max(numbers) == height)
            or (min(numbers) == height and max(numbers) == width)):
            average_of_numbers = length
        elif ((min(numbers) == length and max(numbers) == height)
              or (min(numbers) == height and max(numbers) == length)):
            average_of_numbers = width
        else:
            average_of_numbers = height
        square_feet_of_slack = (min(length, width, height)
                                * average_of_numbers)
        square_feet_one_box = (2 * ((length * width)
                                    + (width * height)
                                    + (length * height))
                               + square_feet_of_slack)
        square_feet += square_feet_one_box
        feet_of_ribbon_one_box = (2 * (min(length, width, height)
                                       + average_of_numbers)
                                  + length * width * height)
        feet_of_ribbon += feet_of_ribbon_one_box
    print(f"Total square feet of wrapping paper is {square_feet}.")
    print(f"Total feet of ribbon is {feet_of_ribbon}.")

calculation_square_feet_of_wrapping_paper_and_feet_of_ribbon()

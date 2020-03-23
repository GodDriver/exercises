def calculation_square_feet_of_wrapping_paper_and_feet_of_ribbon():
    """
    How many total square feet of wrapping paper should they order?
    How many total feet of ribbon should they order?
    """
    filename = '/home/goddriver/Documents/exercises/aoc2015/2/input'
    with open(filename) as f:
        lines = f.readlines()

    square_feet = 0
    feet_of_ribbon = 0

    for line in lines:
        line = line.rstrip()
        numbers = line.split("x")
        numbers = list(map(int, numbers))
        # l - length, w - width, h - height
        (l, w, h) = numbers
        if ((min(l, w, h) == w and max(l, w, h) == h)
            or (min(l, w, h) == h and max(l, w, h) == w)):
            average_of_numbers = l
        elif ((min(l, w, h) == l and max(l, w ,h) == h)
              or (min(l, w, h) == h and max(l, w, h) == l)):
            average_of_numbers = w
        else:
            average_of_numbers = h
        square_feet_of_slack = (min(l, w, h)
                                * average_of_numbers)
        square_feet_one_box = (2 * ((l * w)
                                    + (w * h)
                                    + (l * h))
                               + square_feet_of_slack)
        square_feet += square_feet_one_box
        feet_of_ribbon_one_box = (2 * (min(l, w, h)
                                       + average_of_numbers)
                                  + l * w * h)
        feet_of_ribbon += feet_of_ribbon_one_box
    print(f"Total square feet of wrapping paper is {square_feet}.")
    print(f"Total feet of ribbon is {feet_of_ribbon}.")

calculation_square_feet_of_wrapping_paper_and_feet_of_ribbon()

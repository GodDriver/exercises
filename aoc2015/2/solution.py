"""Day 2"""

def get_square_feet_of_wrapping_paper(sizes: str) -> int:
    """Calculation square feet of wrapping paper for one box."""
    sizes = sizes.strip().split("x")
    sizes = list(map(int, sizes))
    l, w, h = sizes
    # l - length, w - width, h - height
    if ((min(l, w, h) == w and max(l, w, h) == h)
            or (min(l, w, h) == h and max(l, w, h) == w)):
        average_of_sizes = l
    elif ((min(l, w, h) == l and max(l, w, h) == h)
          or (min(l, w, h) == h and max(l, w, h) == l)):
        average_of_sizes = w
    else:
        average_of_sizes = h
    square_feet_of_slack = (min(l, w, h) * average_of_sizes)
    square_feet_one_box = (2 * ((l * w) + (w * h) + (l * h))
                           + square_feet_of_slack)
    return square_feet_one_box

def get_feet_of_ribbon(sizes: str) -> int:
    """Calculation feet of ribbon for one box."""
    sizes = sizes.strip().split("x")
    sizes = list(map(int, sizes))
    l, w, h = sizes
    # l - length, w - width, h - height
    if ((min(l, w, h) == w and max(l, w, h) == h)
            or (min(l, w, h) == h and max(l, w, h) == w)):
        average_of_sizes = l
    elif ((min(l, w, h) == l and max(l, w, h) == h)
          or (min(l, w, h) == h and max(l, w, h) == l)):
        average_of_sizes = w
    else:
        average_of_sizes = h
    feet_of_ribbon_one_box = (2 * (min(l, w, h) + average_of_sizes)
                              + l * w * h)
    return feet_of_ribbon_one_box

def main():
    """Main."""
    filename = '/home/goddriver/Documents/exercises/aoc2015/2/input'
    with open(filename) as f_input:
        lines = f_input.readlines()

    square_feet = 0
    feet_of_ribbon = 0

    for line in lines:
        square_feet += get_square_feet_of_wrapping_paper(line)
        feet_of_ribbon += get_feet_of_ribbon(line)
    print(f"They should order {square_feet} square feets of wrapping paper.")
    print(f"They should order {feet_of_ribbon} feets of ribbon.")

if __name__ == "__main__":
    main()

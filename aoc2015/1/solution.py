"""Day 1"""

def get_floor(instructions: str) -> int:
    """Calculation one instruction."""

    floor = 0

    for instruction in instructions:
        if instruction == '(':
            floor += 1
        elif instruction == ')':
            floor -= 1
    return floor

def get_basement(instructions: str) -> int:
    """Calculation first enter the basement."""

    floor = 0
    position = 0
    i = 0

    for instruction in instructions:
        if instruction == '(':
            floor += 1
        elif instruction == ')':
            floor -= 1
        position += 1
        if floor == -1 and i == 0:
            i += 1
            return position

def main():
    """Main."""
    filename = '/home/goddriver/Documents/exercises/aoc2015/1/input'

    with open(filename) as f_i:
        elements = f_i.read()

    print(f"In floor {get_floor(elements)}.")
    print(f"First enter the basement is at character position \
{get_basement(elements)}.")

if __name__ == "__main__":
    main()

"""Day 10"""

from itertools import groupby


def get_look_and_say(sequence: str) -> str:
    """Calculation Look-and-say sequence."""
    return ''.join(str(len(list(grouper))) + element for element, grouper \
                   in groupby(sequence))

if __name__ == "__main__":
    puzzle_input = '1113222113'
    for _ in range(40):
        puzzle_input = get_look_and_say(puzzle_input)
    print(f"The length of the result is {len(puzzle_input)}.")
    puzzle_input = '1113222113'
    for _ in range(50):
        puzzle_input = get_look_and_say(puzzle_input)
    print(f"The length of the result in Part Two is {len(puzzle_input)}.")

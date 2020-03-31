"""Day 4"""

import hashlib


def get_answer(secret_key: str, start_with: str) -> int:
    """
    Calculation answer for secret key, when MD5 hash starts with some number.
    """

    answer = 0

    while True:
        md5_hash = hashlib.md5((secret_key
                                + str(answer)).encode()).hexdigest()
        if md5_hash.startswith(start_with) == 0:
            answer += 1
        else:
            return answer

if __name__ == "__main__":
    puzzle_input = 'bgvyzdsv'
    print(f"The lowest number it combines with to make an MD5 hash starting \
with five zeroes is {get_answer(puzzle_input, '0' * 5)}.")
    print(f"The lowest number it combines with to make an MD5 hash starting \
with six zeroes is {get_answer(puzzle_input, '0' * 6)}.")

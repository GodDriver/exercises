"""Tests for day 4"""

import unittest
from solution import get_answer


class SolutionTestCase(unittest.TestCase):
    """Tests for 'solution.py'."""

    def test_get_answer(self):
        """
        Расчет минимального значения, при котором MD5 hash начинается с пяти
        нолей работает правильно?
        """
        answer = get_answer('abcdef', '0' * 5)
        self.assertEqual(answer, 609043)
        answer = get_answer('pqrstuv', '0' * 5)
        self.assertEqual(answer, 1048970)

if __name__ == "__main__":
    unittest.main()

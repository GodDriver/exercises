"""Tests for day 1"""

import unittest
from solution import get_floor, get_basement


class SolutionTestCase(unittest.TestCase):
    """Tests for 'solution.py'."""

    def test_get_floor(self):
        """Расчет этажа в инструкции работает правильно?"""
        floor_1 = get_floor('(())')
        floor_2 = get_floor('()()')
        self.assertEqual(floor_1, floor_2, 0)
        floor_1 = get_floor('(((')
        floor_2 = get_floor('(()(()(')
        self.assertEqual(floor_1, floor_2, 3)
        floor_3 = get_floor('))(((((')
        self.assertEqual(floor_1, floor_3, 3)
        floor_1 = get_floor('())')
        floor_2 = get_floor('))(')
        self.assertEqual(floor_1, floor_2, -1)
        floor_1 = get_floor(')))')
        floor_2 = get_floor(')())())')
        self.assertEqual(floor_1, floor_2, -3)

    def test_get_basement(self):
        """Расчет первого входа в подвал работает правильно?"""
        position = get_basement(')')
        self.assertEqual(position, 1)
        position = get_basement('()())')
        self.assertEqual(position, 5)

if __name__ == "__main__":
    unittest.main()

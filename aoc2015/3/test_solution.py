"""Tests for day 3"""

import unittest
from solution import get_number_of_houses, get_number_of_houses_next_year


class SolutionTestCase(unittest.TestCase):
    """Tests for 'solution.py'."""

    def test_get_number_of_houses(self):
        """Расчет количества домов работает правильно?"""
        number_of_houses = get_number_of_houses('>')
        self.assertEqual(number_of_houses, 2)
        number_of_houses = get_number_of_houses('^>v<')
        self.assertEqual(number_of_houses, 4)
        number_of_houses = get_number_of_houses('^v^v^v^v^v')
        self.assertEqual(number_of_houses, 2)

    def test_get_number_of_houses_next_year(self):
        """Расчет количества домов для следующего года работает правильно?"""
        number_of_houses_next_year = get_number_of_houses_next_year('^v')
        self.assertEqual(number_of_houses_next_year, 3)
        number_of_houses_next_year = get_number_of_houses_next_year('^>v<')
        self.assertEqual(number_of_houses_next_year, 3)
        number_of_houses_next_year \
            = get_number_of_houses_next_year('^v^v^v^v^v')
        self.assertEqual(number_of_houses_next_year, 11)

if __name__ == "__main__":
    unittest.main()

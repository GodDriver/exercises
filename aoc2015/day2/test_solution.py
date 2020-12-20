"""Tests for day 2"""

import unittest
from solution import get_square_feet_of_wrapping_paper, get_feet_of_ribbon


class SolutionTestCase(unittest.TestCase):
    """Tests for 'solution.py'."""

    def test_get_square_feet_of_wrapping_paper(self):
        """
        Расчет количества оберточной бумаги для одной коробки работает
        правильно?
        """
        square_feet_one_box = get_square_feet_of_wrapping_paper('2x3x4')
        self.assertEqual(square_feet_one_box, 58)
        square_feet_one_box = get_square_feet_of_wrapping_paper('1x1x10')
        self.assertEqual(square_feet_one_box, 43)

    def test_get_feet_of_ribbon(self):
        """
        Расчет количества оберточной ленты для одной коробки работает
        правильно?
        """
        feet_of_ribbon_one_box = get_feet_of_ribbon('2x3x4')
        self.assertEqual(feet_of_ribbon_one_box, 34)
        feet_of_ribbon_one_box = get_feet_of_ribbon('1x1x10')
        self.assertEqual(feet_of_ribbon_one_box, 14)

if __name__ == "__main__":
    unittest.main()

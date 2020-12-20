"""Tests for day 10"""

import unittest
from solution import get_look_and_say


class SolutionTestCase(unittest.TestCase):
    """Tests for 'solution.py'."""

    def test_get_look_and_say_sequence(self):
        """Вычисление Look-and-say последовательности работает правильно?"""
        look_and_say_sequence = get_look_and_say('1')
        self.assertEqual(look_and_say_sequence, '11')
        look_and_say_sequence = get_look_and_say('11')
        self.assertEqual(look_and_say_sequence, '21')
        look_and_say_sequence = get_look_and_say('21')
        self.assertEqual(look_and_say_sequence, '1211')
        look_and_say_sequence = get_look_and_say('1211')
        self.assertEqual(look_and_say_sequence, '111221')
        look_and_say_sequence = get_look_and_say('111221')
        self.assertEqual(look_and_say_sequence, '312211')

if __name__ == "__main__":
    unittest.main()

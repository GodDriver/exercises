"""Tests for day 5"""

import unittest
from solution import get_nice_string, get_nice_string_new_rules


class SolutionTestCase(unittest.TestCase):
    """Tests for 'solution.py'."""

    def test_get_nice_string(self):
        """Является ли строка хорошей?"""
        nice_string = get_nice_string('ugknbfddgicrmopn')
        self.assertEqual(nice_string, True)
        nice_string = get_nice_string('aaa')
        self.assertEqual(nice_string, True)
        nice_string = get_nice_string('jchzalrnumimnmhp')
        self.assertEqual(nice_string, False)
        nice_string = get_nice_string('haegwjzuvuyypxyu')
        self.assertEqual(nice_string, False)
        nice_string = get_nice_string('dvszwmarrgswjxmb')
        self.assertEqual(nice_string, False)

    def test_get_nice_string_new_rules(self):
        """Является ли строка хорошей при новых правилах?"""
        nice_string_new_rules = get_nice_string_new_rules('qjhvhtzxzqqjkmpb')
        self.assertEqual(nice_string_new_rules, True)
        nice_string_new_rules = get_nice_string_new_rules('xxyxx')
        self.assertEqual(nice_string_new_rules, True)
        nice_string_new_rules = get_nice_string_new_rules('uurcxstgmygtbstg')
        self.assertEqual(nice_string_new_rules, False)
        nice_string_new_rules = get_nice_string_new_rules('ieodomkazucvgmuy')
        self.assertEqual(nice_string_new_rules, False)

if __name__ == "__main__":
    unittest.main()

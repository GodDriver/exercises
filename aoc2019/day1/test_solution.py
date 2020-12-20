"""Tests for day 1"""

import unittest
from solution import get_fuel_one_module, get_fuel_one_module_with_added


class SolutionTestCase(unittest.TestCase):
    """Tests for 'solution.py'."""

    def test_get_fuel_one_module(self):
        """Расчет топлива для одного модуля работает правильно?"""
        fuel_one_module = get_fuel_one_module(12)
        self.assertEqual(fuel_one_module, 2)
        fuel_one_module = get_fuel_one_module(14)
        self.assertEqual(fuel_one_module, 2)
        fuel_one_module = get_fuel_one_module(1969)
        self.assertEqual(fuel_one_module, 654)
        fuel_one_module = get_fuel_one_module(100756)
        self.assertEqual(fuel_one_module, 33583)

    def test_get_fuel_one_module_with_added(self):
        """
        Расчет топлива для одного модуля с добавленным работает правильно?
        """
        fuel_one_module_with_added = get_fuel_one_module_with_added(14)
        self.assertEqual(fuel_one_module_with_added, 2)
        fuel_one_module_with_added = get_fuel_one_module_with_added(1969)
        self.assertEqual(fuel_one_module_with_added, 966)
        fuel_one_module_with_added = get_fuel_one_module_with_added(100756)
        self.assertEqual(fuel_one_module_with_added, 50346)

if __name__ == "__main__":
    unittest.main()

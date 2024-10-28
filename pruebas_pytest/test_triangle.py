from unittest import TestCase
from triangle import area_of_a_triangle

class TestAreaOfTriangle(TestCase):

    def test_float_values(self):
        """Prueba áreas cuando los valores son flotantes"""
        # Arrange
        base = 3.4556
        height = 8.3567
        expected_area = 14.43870626

        # Act
        result = area_of_a_triangle(base, height)

        # Assert
        self.assertAlmostEqual(result, expected_area)

    def test_integer_values(self):
        """Prueba áreas cuando los valores son enteros"""
        # Arrange
        base, height = 2, 5
        expected_area = 5.0

        # Act
        result = area_of_a_triangle(base, height)

        # Assert
        self.assertEqual(result, expected_area)

        # Arrange
        base, height = 4, 6
        expected_area = 12.0

        # Act
        result = area_of_a_triangle(base, height)

        # Assert
        self.assertEqual(result, expected_area)

    def test_zero_base(self):
        """Prueba áreas cuando la base es cero"""
        # Arrange
        base, height = 0, 5
        expected_area = 0.0

        # Act
        result = area_of_a_triangle(base, height)

        # Assert
        self.assertEqual(result, expected_area)

    def test_zero_height(self):
        """Prueba áreas cuando la altura es cero"""
        # Arrange
        base, height = 2, 0
        expected_area = 0.0

        # Act
        result = area_of_a_triangle(base, height)

        # Assert
        self.assertEqual(result, expected_area)

    def test_zero_values(self):
        """Prueba áreas cuando la base y la altura son cero"""
        # Arrange
        base, height = 0, 0
        expected_area = 0.0

        # Act
        result = area_of_a_triangle(base, height)

        # Assert
        self.assertEqual(result, expected_area)

    def test_negative_base(self):
        """Prueba que se lance ValueError cuando la base es negativa"""
        # Arrange
        base, height = -2, 5

        # Act & Assert
        self.assertRaises(ValueError, area_of_a_triangle, base, height)

    def test_negative_height(self):
        """Prueba que se lance ValueError cuando la altura es negativa"""
        # Arrange
        base, height = 2, -5

        # Act & Assert
        self.assertRaises(ValueError, area_of_a_triangle, base, height)

    def test_negative_values(self):
        """Prueba que se lance ValueError cuando ambos son negativos"""
        # Arrange
        base, height = -2, -5

        # Act & Assert
        self.assertRaises(ValueError, area_of_a_triangle, base, height)

    def test_with_boolean(self):
        """Prueba que se lance TypeError con tipos booleanos"""
        # Arrange
        base, height = True, 5

        # Act & Assert
        self.assertRaises(TypeError, area_of_a_triangle, base, height)

        # Arrange
        base, height = 2, True

        # Act & Assert
        self.assertRaises(TypeError, area_of_a_triangle, base, height)

    def test_with_string(self):
        """Prueba que se lance TypeError con tipos string"""
        # Arrange
        base, height = "base", 5

        # Act & Assert
        self.assertRaises(TypeError, area_of_a_triangle, base, height)

        # Arrange
        base, height = 2, "altura"

        # Act & Assert
        self.assertRaises(TypeError, area_of_a_triangle, base, height)

    def test_with_nulls(self):
        """Prueba que se lance TypeError con tipos nulos"""
        # Arrange
        base, height = None, 5

        # Act & Assert
        self.assertRaises(TypeError, area_of_a_triangle, base, height)

        # Arrange
        base, height = 2, None

        # Act & Assert
        self.assertRaises(TypeError, area_of_a_triangle, base, height)

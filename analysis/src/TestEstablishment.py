import unittest
from Establishment import Establishment

class TestEstablishment(unittest.TestCase):
    def test_proper_fields(self):
        restaurantInfo = {
          'name': 'Restaurant',
          'city': 'Newark',
          'address': '3194 Fashion Center Boulevard',
          'zip': '19702'
        }
        establishment = Establishment()
        establishment.builder(restaurantInfo)
        self.assertEqual(establishment.city(), 'Newark')

    def test_empty_fields(self):
        restaurantInfo = {
          'name': 'Restaurant',
          'city': '',
          'address': '3194 Fashion Center Boulevard',
          'zip': ''
        }
        establishment = Establishment()
        establishment.builder(restaurantInfo)
        self.assertEqual(establishment.city(), None)

if __name__ == '__main__':
    unittest.main()
        
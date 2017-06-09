import unittest
from Establishment import Establishment

class test_Establishment(unittest.TestCase):
    def test_assert_fieldsself_name(self):
        restaurantInfo = {
          'name': 'Restaurant',
          'city': 'Newark',
          'address': '3194 Fashion Center Boulevard',
          'zip': '19702'
        }
        establishment = Establishment()
        establishment.builder(restaurantInfo)
        self.assertEqual(establishment.name(), 'Restaurant')

    def test_assert_fieldsself_name_missing(self):
        restaurantInfo = {
          'name': '',
          'city': 'Newark',
          'address': '3194 Fashion Center Boulevard',
          'zip': '19702'
        }
        establishment = Establishment()
        establishment.builder(restaurantInfo)
        self.assertEqual(establishment.name(), None)

    def test_assert_fieldsself_city(self):
        restaurantInfo = {
          'name': 'Restaurant',
          'city': 'Newark',
          'address': '3194 Fashion Center Boulevard',
          'zip': '19702'
        }
        establishment = Establishment()
        establishment.builder(restaurantInfo)
        self.assertEqual(establishment.city(), 'Newark')

    def test_assert_fieldsself_city_missing(self):
        restaurantInfo = {
          'name': 'Restaurant',
          'city': '',
          'address': '3194 Fashion Center Boulevard',
          'zip': '19702'
        }
        establishment = Establishment()
        establishment.builder(restaurantInfo)
        self.assertEqual(establishment.city(), None)

    def test_assert_fieldsself_address(self):
        restaurantInfo = {
          'name': 'Restaurant',
          'city': 'Newark',
          'address': '3194 Fashion Center Boulevard',
          'zip': '19702'
        }
        establishment = Establishment()
        establishment.builder(restaurantInfo)
        self.assertEqual(establishment.address(), '3194 Fashion Center Boulevard')

    def test_assert_fieldsself_address_missing(self):
        restaurantInfo = {
          'name': 'Restaurant',
          'city': 'Newark',
          'address': '',
          'zip': '19702'
        }
        establishment = Establishment()
        establishment.builder(restaurantInfo)
        establishment.builder(restaurantInfo)
        self.assertEqual(establishment.address(), None)

    def test_assert_fieldsself_zip(self):
        restaurantInfo = {
          'name': 'Restaurant',
          'city': 'Newark',
          'address': '3194 Fashion Center Boulevard',
          'zip': '19702'
        }
        establishment = Establishment()
        establishment.builder(restaurantInfo)
        self.assertEqual(establishment.zip(), '19702')

    def test_assert_fieldsself_zip_missing(self):
        restaurantInfo = {
          'name': 'Restaurant',
          'city': 'Newark',
          'address': '3194 Fashion Center Boulevard',
          'zip': ''
        }
        establishment = Establishment()
        establishment.builder(restaurantInfo)
        self.assertEqual(establishment.zip(), None)

###############################################

    def test_to_user_JSON(self):
        establishment = Establishment()
        establishment.builder({
        'name': 'EAGLES NEST MINISTRIES',
        'city': 'Milton',
        'address': 'PO Box 129',
        'zip': '19968'
        })
        expected = {
        'Name': 'EAGLES NEST MINISTRIES',
        'Type': 'Establishment',
        'Password': '1234',
        'Username': 'EAGLES NEST MINISTRIES'
        }
        for key in expected.keys():
            self.assertEqual(expected[key], establishment.to_user_JSON()[key])

    def test_to_user_JSON_incomplete(self):
        establishment = Establishment()
        establishment.builder({
        'name': '',
        'city': 'Milton',
        'address': 'PO Box 129',
        'zip': '19968'
        })
        expected = {
        'Name': None,
        'Type': 'Establishment',
        'Password': '1234',
        'Username': None
        }
        for key in expected.keys():
            self.assertEqual(expected[key], establishment.to_user_JSON()[key])

    def test_to_identification_JSON(self):
        establishment = Establishment()
        establishment.builder({
        'name': 'EAGLES NEST MINISTRIES',
        'city': 'Milton',
        'state': 'DE',
        'address': 'PO Box 129',
        'zip': '19968'
        })
        expected = {
        'Establishment': 'EAGLES NEST MINISTRIES',
        'Location': 'Milton, DE, 19968'
        }
        for key in expected.keys():
            self.assertEqual(expected[key], establishment.to_identification_JSON()[key])

    def test_to_identification_JSON(self):
        establishment = Establishment()
        establishment.builder({
        'name': '',
        'city': '',
        'state': '',
        'address': '',
        'zip': ''
        })
        expected = {
        'Establishment': None,
        'Location': 'None, None, None'
        }
        for key in expected.keys():
            self.assertEqual(expected[key], establishment.to_identification_JSON()[key])

if __name__ == '__main__':
    unittest.main()
        
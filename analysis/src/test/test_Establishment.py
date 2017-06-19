import unittest
from Establishment import Establishment

class test_Establishment(unittest.TestCase):
    def test_assert_fieldsself_name(self):
        restaurant_info = {
            'name': 'Restaurant',
            'city': 'Newark',
            'address': '3194 Fashion Center Boulevard',
            'zip': '19702'
        }
        establishment = Establishment()
        establishment.builder(restaurant_info)
        self.assertEqual(establishment.name(), 'Restaurant')

    def test_assert_fieldsself_name_missing(self):
        restaurant_info = {
            'name': '',
            'city': 'Newark',
            'address': '3194 Fashion Center Boulevard',
            'zip': '19702'
        }
        establishment = Establishment()
        establishment.builder(restaurant_info)
        self.assertEqual(establishment.name(), None)

    def test_assert_fieldsself_city(self):
        restaurant_info = {
            'name': 'Restaurant',
            'city': 'Newark',
            'address': '3194 Fashion Center Boulevard',
            'zip': '19702'
        }
        establishment = Establishment()
        establishment.builder(restaurant_info)
        self.assertEqual(establishment.city(), 'Newark')

    def test_assert_fieldsself_city_missing(self):
        restaurant_info = {
            'name': 'Restaurant',
            'city': '',
            'address': '3194 Fashion Center Boulevard',
            'zip': '19702'
        }
        establishment = Establishment()
        establishment.builder(restaurant_info)
        self.assertEqual(establishment.city(), None)

    def test_assert_fieldsself_address(self):
        restaurant_info = {
            'name': 'Restaurant',
            'city': 'Newark',
            'address': '3194 Fashion Center Boulevard',
            'zip': '19702'
        }
        establishment = Establishment()
        establishment.builder(restaurant_info)
        self.assertEqual(establishment.address(), '3194 Fashion Center Boulevard')

    def test_assert_fieldsself_address_missing(self):
        restaurant_info = {
            'name': 'Restaurant',
            'city': 'Newark',
            'address': '',
            'zip': '19702'
        }
        establishment = Establishment()
        establishment.builder(restaurant_info)
        establishment.builder(restaurant_info)
        self.assertEqual(establishment.address(), None)

    def test_assert_fieldsself_zip(self):
        restaurant_info = {
            'name': 'Restaurant',
            'city': 'Newark',
            'address': '3194 Fashion Center Boulevard',
            'zip': '19702'
        }
        establishment = Establishment()
        establishment.builder(restaurant_info)
        self.assertEqual(establishment.zip(), '19702')

    def test_assert_fieldsself_zip_missing(self):
        restaurant_info = {
            'name': 'Restaurant',
            'city': 'Newark',
            'address': '3194 Fashion Center Boulevard',
            'zip': ''
        }
        establishment = Establishment()
        establishment.builder(restaurant_info)
        self.assertEqual(establishment.zip(), None)

###############################################

    def test_to_user_json(self):
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
            self.assertEqual(expected[key], establishment.to_user_json()[key])

    def test_to_user_json_incomplete(self):
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
            self.assertEqual(expected[key], establishment.to_user_json()[key])

    def test_to_identification_json(self):
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
            self.assertEqual(expected[key], establishment.to_identification_json()[key])

    def test_to_identification_json_empty(self):
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
            self.assertEqual(expected[key], establishment.to_identification_json()[key])

if __name__ == '__main__':
    unittest.main()
        
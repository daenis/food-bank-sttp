import unittest
from Partner import Partner

class test_Partner(unittest.TestCase):
    def test_assert_fieldsself_agency_name(self):
        testDictionary = {
            'AgencyRef': '200191',
            'agency_name': 'EAGLES NEST MINISTRIES',
            'Addr1': 'PO Box 129', 'Addr2': '26633 Zion Church Rd',
            'City': 'Milton', 'State': 'DE', 'Zip': '19968',
            'Phone': '302684-4983', 'County': 'SUSSEX',
            'Group': 'FOOD CLOSET'
        }
        partner = Partner()
        partner.builder(testDictionary)
        self.assertEqual(partner.agency_name(), 'EAGLES NEST MINISTRIES')

    def test_assert_fieldsself_agency_name_missing(self):
        testDictionary = {
            'AgencyRef': '200191',
            'agency_name': '',
            'Addr1': 'PO Box 129', 'Addr2': '26633 Zion Church Rd',
            'City': 'Milton', 'State': 'DE', 'Zip': '19968',
            'Phone': '302684-4983', 'County': 'SUSSEX',
            'Group': 'FOOD CLOSET'
        }
        partner = Partner()
        partner.builder(testDictionary)
        self.assertEqual(partner.agency_name(), None)

    def test_assert_fieldsself_addr1(self):
        testDictionary = {
            'AgencyRef': '200191',
            'agency_name': 'EAGLES NEST MINISTRIES',
            'Addr1': 'PO Box 129', 'Addr2': '26633 Zion Church Rd',
            'City': 'Milton', 'State': 'DE', 'Zip': '19968',
            'Phone': '302684-4983', 'County': 'SUSSEX',
            'Group': 'FOOD CLOSET'
        }
        partner = Partner()
        partner.builder(testDictionary)
        self.assertEqual(partner.addr1(), 'PO Box 129')

    def test_assert_fieldsself_addr1_missing(self):
        testDictionary = {
            'AgencyRef': '200191',
            'agency_name': 'EAGLES NEST MINISTRIES',
            'Addr1': '', 'Addr2': '26633 Zion Church Rd',
            'City': 'Milton', 'State': 'DE', 'Zip': '19968',
            'Phone': '302684-4983', 'County': 'SUSSEX',
            'Group': 'FOOD CLOSET'
        }
        partner = Partner()
        partner.builder(testDictionary)
        self.assertEqual(partner.addr1(), None)

    def test_assert_fieldsself_city(self):
        testDictionary = {
            'AgencyRef': '200191',
            'agency_name': 'EAGLES NEST MINISTRIES',
            'Addr1': 'PO Box 129', 'Addr2': '26633 Zion Church Rd',
            'City': 'Milton', 'State': 'DE', 'Zip': '19968',
            'Phone': '302684-4983', 'County': 'SUSSEX',
            'Group': 'FOOD CLOSET'
        }
        partner = Partner()
        partner.builder(testDictionary)
        self.assertEqual(partner.city(), 'Milton')

    def test_assert_fieldsself_city_missing(self):
        testDictionary = {
            'AgencyRef': '200191',
            'agency_name': 'EAGLES NEST MINISTRIES',
            'Addr1': 'PO Box 129', 'Addr2': '26633 Zion Church Rd',
            'City': '', 'State': 'DE', 'Zip': '19968',
            'Phone': '302684-4983', 'County': 'SUSSEX',
            'Group': 'FOOD CLOSET'
        }
        partner = Partner()
        partner.builder(testDictionary)
        self.assertEqual(partner.city(), None)

    def test_assert_fieldsself_zip(self):
        testDictionary = {
            'AgencyRef': '200191',
            'agency_name': 'EAGLES NEST MINISTRIES',
            'Addr1': 'PO Box 129', 'Addr2': '26633 Zion Church Rd',
            'City': 'Milton', 'State': 'DE', 'Zip': '19968',
            'Phone': '302684-4983', 'County': 'SUSSEX',
            'Group': 'FOOD CLOSET'
        }
        partner = Partner()
        partner.builder(testDictionary)
        self.assertEqual(partner.zip(), '19968')

    def test_assert_fieldsself_zip_missing(self):
        testDictionary = {
            'AgencyRef': '200191',
            'agency_name': 'EAGLES NEST MINISTRIES',
            'Addr1': 'PO Box 129', 'Addr2': '26633 Zion Church Rd',
            'City': 'Milton', 'State': 'DE', 'Zip': '',
            'Phone': '302684-4983', 'County': 'SUSSEX',
            'Group': 'FOOD CLOSET'
        }
        partner = Partner()
        partner.builder(testDictionary)
        self.assertEqual(partner.zip(), None)

###############################################

    def test_to_user_json(self):
        partner = Partner()
        partner.builder({
            'agency_name': 'EAGLES NEST MINISTRIES',
            'Addr1': 'PO Box 129',
            'City': 'Milton',
            'State': 'DE',
            'Zip': '19968'
        })
        expected = {
            'Name': 'EAGLES NEST MINISTRIES',
            'Type': 'Partner',
            'Password': '1234',
            'Username': 'EAGLES NEST MINISTRIES'
        }
        for key in expected.keys():
            self.assertEqual(expected[key], partner.to_user_json()[key])

    def test_to_user_json_incomplete(self):
        partner = Partner()
        partner.builder({
            'agency_name': '',
            'Addr1': 'PO Box 129',
            'City': 'Milton',
            'State': 'DE',
            'Zip': '19968'
        })
        expected = {
            'Name': None,
            'Type': 'Partner',
            'Password': '1234',
            'Username': None
        }
        for key in expected.keys():
            self.assertEqual(expected[key], partner.to_user_json()[key])

    def test_to_identification_json(self):
        partner = Partner()
        partner.builder({
            'agency_name': 'EAGLES NEST MINISTRIES',
            'Addr1': 'PO Box 129',
            'City': 'Milton',
            'State': 'DE',
            'Zip': '19968'
        })
        expected = {
            'Organization': 'EAGLES NEST MINISTRIES',
            'Location': 'Milton, DE, 19968'
        }
        for key in expected.keys():
            self.assertEqual(expected[key], partner.to_identification_json()[key])

    def test_to_identification_json_incomplete(self):
        partner = Partner()
        partner.builder({
            'agency_name': '',
            'Addr1': 'PO Box 129',
            'City': '',
            'State': '',
            'Zip': ''
        })
        expected = {
            'Organization': None,
            'Location': 'None, None, None'
        }
        for key in expected.keys():
            self.assertEqual(expected[key], partner.to_identification_json()[key])

if __name__ == '__main__':
    unittest.main()

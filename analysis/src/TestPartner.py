import unittest
from Partner import Partner

class TestPartner(unittest.TestCase):

    def test_assert_fieldsself_agencyName(self):
        testDictionary = {
        'AgencyRef': '200191',
        'AgencyName': 'EAGLES NEST MINISTRIES',
        'Addr1': 'PO Box 129', 'Addr2': '26633 Zion Church Rd',
        'City': 'Milton', 'State': 'DE', 'Zip': '19968',
        'Phone': '302684-4983', 'County': 'SUSSEX',
        'Group': 'FOOD CLOSET'
        }
        partner = Partner()
        partner.builder(testDictionary)
        self.assertEqual(partner.agencyName(), 'EAGLES NEST MINISTRIES')

    def test_assert_fieldsself_agencyName_missing(self):
        testDictionary = {
        'AgencyRef': '200191',
        'AgencyName': '',
        'Addr1': 'PO Box 129', 'Addr2': '26633 Zion Church Rd',
        'City': 'Milton', 'State': 'DE', 'Zip': '19968',
        'Phone': '302684-4983', 'County': 'SUSSEX',
        'Group': 'FOOD CLOSET'
        }
        partner = Partner()
        partner.builder(testDictionary)
        self.assertEqual(partner.agencyName(), None)

    def test_assert_fieldsself_addr1(self):
        testDictionary = {
        'AgencyRef': '200191',
        'AgencyName': 'EAGLES NEST MINISTRIES',
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
        'AgencyName': 'EAGLES NEST MINISTRIES',
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
        'AgencyName': 'EAGLES NEST MINISTRIES',
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
        'AgencyName': 'EAGLES NEST MINISTRIES',
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
        'AgencyName': 'EAGLES NEST MINISTRIES',
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
        'AgencyName': 'EAGLES NEST MINISTRIES',
        'Addr1': 'PO Box 129', 'Addr2': '26633 Zion Church Rd',
        'City': 'Milton', 'State': 'DE', 'Zip': '',
        'Phone': '302684-4983', 'County': 'SUSSEX',
        'Group': 'FOOD CLOSET'
        }
        partner = Partner()
        partner.builder(testDictionary)
        self.assertEqual(partner.zip(), None)

    def test_to_user_JSON(self):
        partner = Partner()
        partner.builder({
        'AgencyName': 'EAGLES NEST MINISTRIES',
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
            self.assertEqual(expected[key], partner.to_user_JSON()[key])

    def test_to_partners_JSON(self):
        partner = Partner()
        partner.builder({
        'AgencyName': 'EAGLES NEST MINISTRIES',
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
            self.assertEqual(expected[key], partner.to_partners_JSON()[key])

if __name__ == '__main__':
    unittest.main()

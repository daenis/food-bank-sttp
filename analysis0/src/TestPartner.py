import unittest
from src.Partner import Partner

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

if __name__ == '__main__':
    unittest.main()

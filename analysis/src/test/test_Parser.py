import unittest
from Partner import Partner

class test_Parser(unittest.TestCase):
    def test_assert_parser(self):
        test_csv = {
            'AgencyRef': '200191',
            'agency_name': 'EAGLES NEST MINISTRIES',
            'Addr1': 'PO Box 129', 'Addr2': '26633 Zion Church Rd',
            'City': 'Milton', 'State': 'DE', 'Zip': '19968',
            'Phone': '302684-4983', 'County': 'SUSSEX',
            'Group': 'FOOD CLOSET'
        }
        partner = Partner()
        partner.builder(test_csv)

        self.assertEqual(partner.agency_name(), 'EAGLES NEST MINISTRIES')

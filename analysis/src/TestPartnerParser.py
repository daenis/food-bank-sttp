import unittest

class TestPartner(unittest.TestCase):

    def test_assert_partnerParser(self):
        testCSV = {
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

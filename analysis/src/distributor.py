import os
import requests
from Partner import Partner
from Establishment import Establishment
from dotenv import load_dotenv

dotenv_path = os.getcwd() + '/.env'
print(dotenv_path)
load_dotenv(dotenv_path)
GOOGLE_API = os.environ.get("GOOGLE_API")
GOOGLE_URL = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=restaurants+"

class GoogleRequest:
    def __init__(self, partner):
        self.url = GOOGLE_URL + "{}&key={}".format(partner.zip(), GOOGLE_API)
        self.json = requests.get(self.url).json()
        print(self.json)

    def make_distributors(self):
        establishments = []
        for data in self.json["results"]:
            print(data)
            establishments.append(self.extract(data))
        return establishments

    def extract(self, data):
        print(data)
        distributor = {}
        fields = ["formatted_address", "name"]
        address = data[fields[0]].split(',')
        distributor[fields[1]] = data[fields[1]]
        distributor["address"] = address[0]
        distributor["city"] = address[1]
        distributor["state"] = "DE"
        distributor["zip"] = address[2].split(" ")[2]
        supplier = Establishment()
        supplier.builder(distributor)
        return supplier

    @staticmethod
    def pull_restaurants(list_queue):
        for item in list_queue:
            restaurants = GoogleRequest(item)
            return restaurants.make_distributors()


if __name__ == '__main__':
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
    google = GoogleRequest(partner)
    print(google.make_distributors())

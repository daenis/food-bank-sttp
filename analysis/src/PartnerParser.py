import os
import csv
from Partner import Partner
import json

cwd = os.getcwd()

class PartnerParser:

    def parseCSV(self):
        arrayOfPartners = []
        with open(cwd + '/analysis/assets/partners.csv') as csv_file:
            reader = csv.DictReader(csv_file)
            for row in reader:
                partner = Partner()
                partner.builder(row)
                arrayOfPartners.append(partner)

        return arrayOfPartners



if __name__ == '__main__':
    print(cwd)
    PartnerParser().parseCSV()

import os
import csv
#import json
from analysis.src.Partner import Partner

CWD = os.getcwd()

class Parser:

    def parse_csv(self):
        """Convert a CSV file to a list of Partner objects
        Returns:
        An array of partner objects"""
        array_of_partners = []
        with open(CWD + '/analysis/assets/partners.csv') as csv_file:
            reader = csv.DictReader(csv_file)
            for row in reader:
                partner = Partner()
                partner.builder(row)
                array_of_partners.append(partner)

        return array_of_partners

if __name__ == '__main__':
    Parser().parse_csv()

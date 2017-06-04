from FileMaker import FileMaker
from PartnerParser import PartnerParser
from distributor import GoogleRequest

def main():
    # Create file named 'user' in '/output'
    user_json = FileMaker('user')
    # Create file named 'partner' in '/output'
    partner_json = FileMaker('partner')
    # Create file named 'distributor' in '/output'
    distributor_json = FileMaker('distributor')
    # Return an array of partners to this variable via the partners.csv
    partners_queue = PartnerParser().parseCSV()
    # Return array of distributors to this variable
    establishment_queue = [e for e in GoogleRequest.pull_restaurants(partners_queue)]
    #print(establishment_queue)
    # For every partner in the partners queue array
    for partner in partners_queue:
        # Generate a JSON file for the partner and add it to the existing partner file
        user_json.generate(partner.to_user_JSON())
        partner_json.generate(partner.to_partners_JSON())

    # Generate a file for the establishments
    for establishment in establishment_queue:
        user_json.generate(establishment.to_user_JSON())
        distributor_json.generate(establishment.to_partners_JSON())

    # Create a json using the array of partners
    #partner_json(partners_queue)

    # Create a json using the array of establishments
    #distributor_json(establishment_queue)

if __name__ == '__main__':
    main()

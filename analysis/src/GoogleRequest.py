import os
import requests
from Partner import Partner
from Establishment import Establishment
from dotenv import load_dotenv

DOTENV_PATH = os.getcwd() + '/.env'
#print(DOTENV_PATH)
load_dotenv(DOTENV_PATH)
GOOGLE_API = os.environ.get("GOOGLE_API")
GOOGLE_URL = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=restaurants+"

class GoogleRequest:
    def __init__(self, partner):
        self.url = GOOGLE_URL + "{}&key={}".format(partner.zip(), GOOGLE_API)
        #print(self.url)
        self.json = requests.get(self.url).json()
        #print(self.json)

    def make_distributors(self):
        """Converts JSON file to an array of objects
        Returns:
        A list of Establishment objects based on the information provided in the JSON file"""
        establishments = []
        for data in self.json["results"]:
            establishments.append(self.extract(data))
        return establishments

    def extract(self, data):
        """Creates an object from data provided via JSON
        Parameter:
        Data: A JSON representation of a Establishment
        Returns:
        An Establishment object based on the information provided"""

        distributor = {} #Create an empty dictionary

        fields = ["formatted_address", "name"] #Create an array of field names

        address = data[fields[0]].split(',') #Split the string in the first parameter of the JSON
                                             #file into an array of address information
                                             #[street, city, zip]

        distributor[fields[1]] = data[fields[1]] #Add "name" as a key in distributor and assign it
                                                 #the value of the "name" key in the JSON file

        distributor["address"] = address[0] #Add "address" as a key in distributor and assign
                                            #it the value of the first element of the address array

        distributor["city"] = address[1] #Add "city" as a key in distributor and assign it the value
                                         #of the second element of the address array

        distributor["state"] = "DE" #Add "state" as a key in distrubutor and assign it the value
                                    #of "DE"

        distributor["zip"] = address[2].split(" ")[2] #Add "zip" as a key in distributor and assign
                                                      #it the value of the third element of the
                                                      #third element of the address array split
                                                      #into an array of its own

        supplier = Establishment() #Create a new Establishment object

        supplier.builder(distributor) #Populate an Establishment object based on the values within
                                      #the distributor dictionary

        return supplier #Return the Establishment object

    @staticmethod
    def pull_restaurants(list_queue):
        """
        Create a list
        """
        for item in list_queue:
            restaurants = GoogleRequest(item)
            return restaurants.make_distributors()

#if __name__ == '__main__':
    #main()

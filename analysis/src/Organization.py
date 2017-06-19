from abc import ABCMeta, abstractmethod
import uuid

class Organization(metaclass=ABCMeta):

    def __init__(self):
        """Initialize the Object with an empty dictionary and a UUID as a string"""
        self._dict = None
        self.id = str(uuid.uuid4())

    def _assert_defined(self, field):
        """As long as the dictionary exists, return the value of the specified key"""
        if self._dict != None:
            return self._dict[field]

    def builder(self, dictionary):
        """If the dictionary contains valid key - value pairs, assign it to the _dict attribute"""
        if self._assert_fields(dictionary):
            self._dict = dictionary

    @abstractmethod
    def _assert_fields(self, dictionary):
        """Assert that all fields are defined"""
        pass

    @abstractmethod
    def to_user_json(self):
        """Convert the Object into a JSON file representing the Organization as a user"""
        pass

    @abstractmethod
    def to_identification_json(self):
        """Convert the Object into a JSON file representing the Organization's identification 
        information"""
        pass

# Confirm that zip code is valid
# Parse zipcode as a number, not a string
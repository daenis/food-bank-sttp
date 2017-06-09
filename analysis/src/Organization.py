from abc import ABCMeta, abstractmethod
import uuid

class Organization(metaclass=ABCMeta):
    def __init__(self):
        self._dict = None
        self.id = str(uuid.uuid4())

    def _assert_defined(self, field):
        if self._dict != None:
            return self._dict[field]

    def builder(self, dictionary):
        if self._assert_fields(dictionary):
            self._dict = dictionary
    
    @abstractmethod
    def _assert_fields(self, dictionary):
        pass

    @abstractmethod
    def to_user_JSON(self):
        pass

    @abstractmethod
    def to_identification_JSON(self):
        pass

# Confirm that zip code is valid
# Parse zipcode as a number, not a string
from Organization import Organization
import uuid

class Establishment(Organization):
    def _assert_fields(self, dictionary):
        requiredFields = ['name', 'address', 'city', 'zip']
        for field in requiredFields:
            if dictionary[field] == None or dictionary[field] == '':
                return False
        return True

    def name(self):
        return self._assert_defined('name')

    def address(self):
        return self._assert_defined('address')

    def city(self):
        return self._assert_defined('city')

    def state(self):
        return self._assert_defined('state')

    def zip(self):
        return self._assert_defined('zip')

    def to_user_JSON(self):
        return {
          'UUID': self.id,
          'Name': self.name(),
          'Type': 'Establishment',
          'Password': '1234',
          'Username': self.name()
        }

    def to_identification_JSON(self):
        return {
          'UUID': self.id,
          'Establishment': self.name(),
          'Location': "{}, {}, {}".format(self.city(), self.state(), self.zip())
        }

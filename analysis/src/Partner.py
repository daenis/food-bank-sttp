from Organization import Organization
import uuid

class Partner(Organization):

    def _assert_fields(self, dictionary):
        required_fields = ['agency_name', 'Addr1', 'City', 'Zip']
        for field in required_fields:
            if dictionary[field] is None or dictionary[field] == '':
                return False
        return True

    def agency_name(self):
        """Return the value of the 'agency_name' key if it exists"""
        return self._assert_defined('agency_name')

    def addr1(self):
        """Return the value of the 'Addr1' key if it exists"""
        return self._assert_defined('Addr1')

    def city(self):
        """Return the value of the 'City' key if it exists"""
        return self._assert_defined('City')

    def state(self):
        """Return the value of the 'State' key if it exists"""
        return self._assert_defined('State')

    def zip(self):
        """Return the value of the 'Zip' key if it exists"""
        return self._assert_defined('Zip')

    def to_user_json(self):
        """Return a dictionary representation of the Partner object's user information to be
        converted to JSON"""
        return {
            'UUID': self.id,
            'Name': self.agency_name(),
            'Type': 'Partner',
            'Password': '1234',
            'Username': self.agency_name()
        }

    def to_identification_json(self):
        """Return a dictionary representation of the Partner object's identification information
        to be converted to JSON"""
        return {
            'UUID': self.id,
            'Organization': self.agency_name(),
            'Location': "{}, {}, {}".format(self.city(), self.state(), self.zip())
        }

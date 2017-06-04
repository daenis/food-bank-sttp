import uuid

class Partner:
    def __init__(self):
        self._dict = None
        self.id = str(uuid.uuid4())

    def _assert_defined(self, field):
        if self._dict != None:
            return self._dict[field]

    def builder(self, dictionary):
        if self._assert_fields(dictionary):
            self._dict = dictionary

    def _assert_fields(self, dictionary):
        requiredFields = ['AgencyName', 'Addr1', 'City', 'Zip']
        for field in requiredFields:
            if dictionary[field] == '':
                return False
        return True

    def agencyName(self):
        return self._assert_defined('AgencyName')

    def addr1(self):
        return self._assert_defined('Addr1')

    def city(self):
        return self._assert_defined('City')

    def state(self):
        return self._assert_defined('State')

    def zip(self):
        return self._assert_defined('Zip')

    def to_user_JSON(self):
        return {
          'UUID': self.id,
          'Name': self.agencyName(),
          'Type': 'Partner',
          'Password': '1234',
          'Username': self.agencyName()
        }

    def to_partners_JSON(self):
        return {
          'UUID': self.id,
          'Organization': self.agencyName(),
          'Location': "{}, {}, {}".format(self.city(), self.state(), self.zip())
        }

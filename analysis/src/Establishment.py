import uuid

class Establishment:

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

    def to_partners_JSON(self):
        return {
          'UUID': self.id,
          'Establishment': self.name(),
          'Location': "{}, {}, {}".format(self.city(), self.state(), self.zip())
        }

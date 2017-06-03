class Partner:
    state: "DE"

    def __init__(self):
        self._dict = None

    def _assert_defined(self, field):
        if self._dict != None:
            return self._dict[field]

    def builder(self, dictionary):
        if self._assert_fields(dictionary):
            self._dict = dictionary

    def _assert_fields(self, dictionary):
        requiredFields = ['AgencyName', 'Addr1', 'City', 'Zip'];
        for field in requiredFields:
            if dictionary[field] == None:
                return False
        return True

    def agencyRef(self):
        return self._assert_defined('AgencyRef')

    def agencyName(self):
        return self._assert_defined('AgencyName')

    def addr1(self):
        return self._assert_defined('Addr1')

    def addr2(self):
        return self._assert_defined('Addr2')

    def city(self):
        return self._assert_defined('City')

    def state(self):
        return self._assert_defined('State')

    def zip(self):
        return self._assert_defined('Zip')

    def phone(self):
        return self._assert_defined('Phone')

    def county(self):
        return self._assert_defined('County')

    def group(self):
        return self._assert_defined('Group')

    def city(self):
        return self._assert_defined('City')

    def zip(self):
        return self._assert_defined('Zip')

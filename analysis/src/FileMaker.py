import os
import json
import shutil

class FileMaker:
    def __init__(self, file_name):
        #self.file = None
        self._dict = {}
        file_path = os.getcwd() + '/analysis/output'
        try:
            if not os.path.exists(file_path):
                os.makedirs(file_path)
            self.file_name = file_path + '/' + file_name + '.json'
            self.file = open(self.file_name, 'w+')
        except (OSError, IOError) as err:
            print(err)

    def __del__(self):
        self.write_json()
        self.file.close()

    def write_json(self):
        #
        # Convert to a string to write it?
        #print(json.dumps(self._dict))
        self.file.write(json.dumps(self._dict, separators=(',', ':'), indent=2))
        #self.file.write(json.dumps(self._dict)

    def add_to_dict(self, dictionary):
        self._dict[dictionary['UUID']] = dictionary
        #Maybe open file?
        #Convert to a string to write it?
        #self.file.write(json.dumps(prop, indent=2))

    def generate(self, dictionary):
        self.add_to_dict(dictionary)

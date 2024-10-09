#Author: Rohan Daivajna 
#roll number: 35
#Title: Goa Legislative Assembly
#Start Date: 22-07-2024
#Modified Date: 22-07-2024
#Description: MLA class for the Goa Legislative Assembly system.

from person import Person

class MLA(Person):
    def __init__(self, name, constituency):
        super().__init__(name)
        self.constituency = constituency

    def __str__(self):
        return f"{super().__str__()}\nConstituency: {self.constituency}"

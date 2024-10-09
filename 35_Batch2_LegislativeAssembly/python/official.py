#Author: Rohan Daivajna 
#roll number: 35
#Title: Goa Legislative Assembly
#Start Date: 22-07-2024
#Modified Date: 22-07-2024
#Description: Official class for the Goa Legislative Assembly system.

from person import Person

class Official(Person):
    def __init__(self, position, name):
        super().__init__(name)
        self.position = position

    def __str__(self):
        return f"Position: {self.position}\n{super().__str__()}"

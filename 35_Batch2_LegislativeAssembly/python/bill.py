#Author: Rohan Daivajna 
#roll number: 35
#Title: Goa Legislative Assembly
#Start Date: 22-07-2024
#Modified Date: 22-07-2024
#Description: Bill class for the Goa Legislative Assembly system.

class Bill:
    def __init__(self, title, description):
        self.title = title
        self.description = description
        self.is_passed = False

    def __str__(self):
        return f"Title: {self.title}\nDescription: {self.description}\nStatus: {'Passed' if self.is_passed else 'Not Passed'}"

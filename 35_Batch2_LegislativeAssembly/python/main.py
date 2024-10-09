#Author: Rohan Daivajna 
#roll number: 35
#Title: Goa Legislative Assembly
#Start Date: 22-07-2024
#Modified Date: 22-07-2024
#Description: Menu driven python program to introduce bills and add members to GLA using classes MLA, Person, Officials and Bill.

from bill import Bill
from official import Official
from mla import MLA

def introduce_bill(bills):
    print("\n--- Introduce a New Bill ---")
    title = input("Please enter the title of the bill: ")
    description = input("Please provide a brief description of the bill: ")
    bills.append(Bill(title, description))
    print(f"\n✅ The bill '{title}' has been successfully introduced!\n")

def pass_bill(bills):
    if not bills:
        print("\n⚠️ No bills available to pass. Please introduce a bill first.")
        return

    print("\n--- Pass a Bill ---")
    title = input("Enter the title of the bill you wish to pass: ")
    for bill in bills:
        if bill.title.lower() == title.lower():
            if bill.is_passed:
                print(f"\n⚠️ The bill '{title}' has already been passed.")
            else:
                bill.is_passed = True
                print(f"\n✅ The bill '{title}' has been passed successfully!\n")
            return
    print(f"\n❌ Bill titled '{title}' not found. Please try again.")

def display_bills(bills):
    if not bills:
        print("\n⚠️ No bills to display.")
        return

    print("\n--- List of Bills ---")
    for bill in bills:
        print(bill)
        print()

def add_official(officials):
    print("\n--- Add a New Official ---")
    position = input("Enter the position of the official (e.g., Speaker, Clerk): ")
    name = input("Enter the name of the official: ")
    officials.append(Official(position, name))
    print(f"\n✅ Official '{name}' holding the position of '{position}' has been elected successfully!\n")

def view_officials(officials):
    if not officials:
        print("\n⚠️ No officials to display.")
        return

    print("\n--- List of Officials ---")
    for official in officials:
        print(official)
        print()

def add_mla(mlas):
    print("\n--- Add a New MLA ---")
    name = input("Enter the name of the MLA: ")
    constituency = input("Enter the constituency of the MLA: ")
    mlas.append(MLA(name, constituency))
    print(f"\n✅ MLA '{name}' from constituency '{constituency}' has been elected successfully!\n")

def view_mlas(mlas):
    if not mlas:
        print("\n⚠️ No MLAs to display.")
        return

    print("\n--- List of MLAs ---")
    for mla in mlas:
        print(mla)
        print()

def main():
    bills = []
    officials = []
    mlas = []
    
    print("\n🌟 Welcome to the Goa Legislative Assembly System 🌟")
    
    while True:
        print("\n--- Main Menu ---")
        print("1. Introduce a Bill")
        print("2. Pass a Bill")
        print("3. Display Bills")
        print("4. Elect an Official")
        print("5. View Officials")
        print("6. Add an MLA")
        print("7. View MLAs")
        print("8. Exit")
        
        choice = input("\nPlease enter your choice (1-8): ")

        if choice == '1':
            introduce_bill(bills)
        elif choice == '2':
            pass_bill(bills)
        elif choice == '3':
            display_bills(bills)
        elif choice == '4':
            add_official(officials)
        elif choice == '5':
            view_officials(officials)
        elif choice == '6':
            add_mla(mlas)
        elif choice == '7':
            view_mlas(mlas)
        elif choice == '8':
            print("\nThank you for using the Goa Legislative Assembly System. Goodbye! 👋")
            break
        else:
            print("\n❌ Invalid choice. Please enter a number between 1 and 8.")

if __name__ == "__main__":
    main()

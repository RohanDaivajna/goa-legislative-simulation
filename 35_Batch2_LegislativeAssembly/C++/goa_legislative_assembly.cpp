// Author: Rohan Daivajna 
// Roll Number: 35
// Title: Goa Legislative Assembly
// Start Date: 22-07-2024
// Modified Date: 22-07-2024
/* Description: This C++ program provides a menu-driven interface for simulating the operations of the Goa Legislative Assembly.
   It allows users to introduce bills, pass them, and display their details. Additionally, users can add and view officials and Members of the 
   Legislative Assembly (MLAs). The program utilizes classes to encapsulate the properties and behaviors of bills, officials, and MLAs, 
   facilitating the management of legislative activities within the assembly. */

#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Bill {
public:
    string title;
    string description;
    bool isPassed;

    Bill(const string& t, const string& d) : title(t), description(d), isPassed(false) {}

    void display() const {
        cout << "Title: " << title << "\nDescription: " << description 
             << "\nStatus: " << (isPassed ? "Passed" : "Not Passed") << endl;
    }
};

class Official {
public:
    string position;
    string name;

    Official(const string& p, const string& n) : position(p), name(n) {}

    void display() const {
        cout << "Position: " << position << "\nName: " << name << endl;
    }
};

class MLA {
public:
    string name;
    string constituency;

    MLA(const string& n, const string& c) : name(n), constituency(c) {}

    void display() const {
        cout << "Name: " << name << "\nConstituency: " << constituency << endl;
    }
};

void introduceBill(vector<Bill>& bills) {
    string title, description;
    cout << "Enter the title of the bill: ";
    getline(cin, title);
    cout << "Enter the description of the bill: ";
    getline(cin, description);
    bills.emplace_back(title, description);
    cout << "The bill titled '" << title << "' has been successfully introduced!" << endl;
}

void passBill(vector<Bill>& bills) {
    if (bills.empty()) {
        cout << "There are no bills available to pass at the moment." << endl;
        return;
    }
    string title;
    cout << "Enter the title of the bill you would like to pass: ";
    getline(cin, title);
    for (auto& bill : bills) {
        if (bill.title == title) {
            bill.isPassed = true;
            cout << "The bill titled '" << title << "' has been successfully passed." << endl;
            return;
        }
    }
    cout << "No bill found with the title '" << title << "'. Please check the title and try again." << endl;
}

void displayBills(const vector<Bill>& bills) {
    if (bills.empty()) {
        cout << "No bills have been introduced yet." << endl;
        return;
    }
    for (const auto& bill : bills) {
        bill.display();
        cout << endl;
    }
}

void addOfficial(vector<Official>& officials) {
    string position, name;
    cout << "Enter the position of the official (e.g., Speaker, Secretary): ";
    getline(cin, position);
    cout << "Enter the name of the official: ";
    getline(cin, name);
    officials.emplace_back(position, name);
    cout << "Official '" << name << "' has been successfully elected to the position of " << position << "." << endl;
}

void viewOfficials(const vector<Official>& officials) {
    if (officials.empty()) {
        cout << "No officials have been elected yet." << endl;
        return;
    }
    cout << "List of Elected Officials:" << endl;
    for (const auto& official : officials) {
        official.display();
        cout << endl;
    }
}

void addMLA(vector<MLA>& mlas) {
    string name, constituency;
    cout << "Enter the name of the MLA: ";
    getline(cin, name);
    cout << "Enter the constituency of the MLA: ";
    getline(cin, constituency);
    mlas.emplace_back(name, constituency);
    cout << "MLA '" << name << "' from '" << constituency << "' has been successfully added." << endl;
}

void viewMLAs(const vector<MLA>& mlas) {
    if (mlas.empty()) {
        cout << "No MLAs have been added yet." << endl;
        return;
    }
    cout << "List of MLAs:" << endl;
    for (const auto& mla : mlas) {
        mla.display();
        cout << endl;
    }
}

int main() {
    vector<Bill> bills;
    vector<Official> officials;
    vector<MLA> mlas;

    int choice;
    do {
        cout << "\n===== Welcome to the Goa Legislative Assembly Menu =====" << endl;
        cout << "1. Introduce a Bill" << endl;
        cout << "2. Pass a Bill" << endl;
        cout << "3. Display Bills" << endl;
        cout << "4. Elect an Official" << endl;
        cout << "5. View Elected Officials" << endl;
        cout << "6. Add an MLA" << endl;
        cout << "7. View MLAs" << endl;
        cout << "8. Exit" << endl;
        cout << "Please select an option (1-8): ";
        cin >> choice;
        cin.ignore(); // Consume newline

        switch (choice) {
            case 1:
                introduceBill(bills);
                break;
            case 2:
                passBill(bills);
                break;
            case 3:
                displayBills(bills);
                break;
            case 4:
                addOfficial(officials);
                break;
            case 5:
                viewOfficials(officials);
                break;
            case 6:
                addMLA(mlas);
                break;
            case 7:
                viewMLAs(mlas);
                break;
            case 8:
                cout << "Thank you for using the Goa Legislative Assembly system! Goodbye!" << endl;
                break;
            default:
                cout << "Invalid choice. Please try again." << endl;
        }
    } while (choice != 8);

    return 0;
}

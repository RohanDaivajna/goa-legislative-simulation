// Author: Rohan Daivajna
// Roll Number: 35
// Title: Goa Legislative Assembly Simulation
// Start Date: 22-07-2024
// Modified Date: 09-10-2024
/* Description: This menu-driven program simulates the operations of the Goa Legislative Assembly. 
   It allows users to introduce and pass bills, and manage members by adding and viewing officials and MLAs (Members of Legislative Assembly).
   The program features classes for Bill, Official, and MLA, each encapsulating relevant attributes and methods. 
   Through a user-friendly interface, users can interact with the assembly's data in a welcoming and organized manner, ensuring an efficient workflow for legislative tasks.
*/
using System;
using System.Collections.Generic;

class Bill
{
    public string Title { get; set; }
    public string Description { get; set; }
    public bool IsPassed { get; set; }

    public Bill(string title, string description)
    {
        Title = title;
        Description = description;
        IsPassed = false;
    }

    public override string ToString()
    {
        return $"**Title:** {Title}\n**Description:** {Description}\n**Status:** {(IsPassed ? "Passed" : "Not Passed")}";
    }
}

class Official
{
    public string Position { get; set; }
    public string Name { get; set; }

    public Official(string position, string name)
    {
        Position = position;
        Name = name;
    }

    public override string ToString()
    {
        return $"**Position:** {Position}\n**Name:** {Name}";
    }
}

class MLA
{
    public string Name { get; set; }
    public string Constituency { get; set; }

    public MLA(string name, string constituency)
    {
        Name = name;
        Constituency = constituency;
    }

    public override string ToString()
    {
        return $"**Name:** {Name}\n**Constituency:** {Constituency}";
    }
}

class Program
{
    private static List<Bill> bills = new List<Bill>();
    private static List<Official> officials = new List<Official>();
    private static List<MLA> mlas = new List<MLA>();

    static void Main(string[] args)
    {
        int choice;
        Console.WriteLine("Welcome to the Goa Legislative Assembly Simulation!");
        Console.WriteLine("This program allows you to manage bills, officials, and MLAs effectively.");
        
        do
        {
            Console.WriteLine("\n--- Goa Legislative Assembly Menu ---");
            Console.WriteLine("1. Introduce a New Bill");
            Console.WriteLine("2. Pass a Bill");
            Console.WriteLine("3. Display All Bills");
            Console.WriteLine("4. Add a New Official");
            Console.WriteLine("5. View All Officials");
            Console.WriteLine("6. Add a New MLA");
            Console.WriteLine("7. View All MLAs");
            Console.WriteLine("8. Exit the Program");
            Console.Write("Please enter your choice (1-8): ");
            choice = int.Parse(Console.ReadLine());

            switch (choice)
            {
                case 1:
                    IntroduceBill();
                    break;
                case 2:
                    PassBill();
                    break;
                case 3:
                    DisplayBills();
                    break;
                case 4:
                    AddOfficial();
                    break;
                case 5:
                    ViewOfficials();
                    break;
                case 6:
                    AddMLA();
                    break;
                case 7:
                    ViewMLAs();
                    break;
                case 8:
                    Console.WriteLine("Thank you for using the program! Exiting now...");
                    break;
                default:
                    Console.WriteLine("Oops! That's an invalid choice. Please try again.");
                    break;
            }
        } while (choice != 8);
    }

    private static void IntroduceBill()
    {
        Console.Write("Please enter the title of the bill: ");
        string title = Console.ReadLine();
        Console.Write("Now, enter a brief description of the bill: ");
        string description = Console.ReadLine();
        bills.Add(new Bill(title, description));
        Console.WriteLine("The bill has been introduced successfully!");
    }

    private static void PassBill()
    {
        if (bills.Count == 0)
        {
            Console.WriteLine("Currently, there are no bills available to pass.");
            return;
        }
        Console.Write("Please enter the title of the bill you wish to pass: ");
        string title = Console.ReadLine();
        foreach (var bill in bills)
        {
            if (bill.Title.Equals(title, StringComparison.OrdinalIgnoreCase))
            {
                bill.IsPassed = true;
                Console.WriteLine("The bill has been passed successfully!");
                return;
            }
        }
        Console.WriteLine("Sorry, the bill titled '" + title + "' was not found.");
    }

    private static void DisplayBills()
    {
        if (bills.Count == 0)
        {
            Console.WriteLine("No bills are currently available to display.");
            return;
        }
        Console.WriteLine("\n--- List of Bills ---");
        foreach (var bill in bills)
        {
            Console.WriteLine(bill);
            Console.WriteLine();
        }
    }

    private static void AddOfficial()
    {
        Console.Write("Please enter the position of the official: ");
        string position = Console.ReadLine();
        Console.Write("Now, enter the name of the official: ");
        string name = Console.ReadLine();
        officials.Add(new Official(position, name));
        Console.WriteLine("The official has been added successfully!");
    }

    private static void ViewOfficials()
    {
        if (officials.Count == 0)
        {
            Console.WriteLine("Currently, there are no officials available to display.");
            return;
        }
        Console.WriteLine("\n--- List of Officials ---");
        foreach (var official in officials)
        {
            Console.WriteLine(official);
            Console.WriteLine();
        }
    }

    private static void AddMLA()
    {
        Console.Write("Please enter the name of the MLA: ");
        string name = Console.ReadLine();
        Console.Write("Now, enter the constituency of the MLA: ");
        string constituency = Console.ReadLine();
        mlas.Add(new MLA(name, constituency));
        Console.WriteLine("The MLA has been added successfully!");
    }

    private static void ViewMLAs()
    {
        if (mlas.Count == 0)
        {
            Console.WriteLine("Currently, there are no MLAs available to display.");
            return;
        }
        Console.WriteLine("\n--- List of MLAs ---");
        foreach (var mla in mlas)
        {
            Console.WriteLine(mla);
            Console.WriteLine();
        }
    }
}

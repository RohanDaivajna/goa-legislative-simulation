// Author: Rohan Daivajna 
// Roll Number: 35
// Title: Goa Legislative Assembly
// Start Date: 15-07-2024
// Modified Date: 22-07-2024
// Description: User-friendly menu-driven program to introduce bills and elect members to the GLA using classes MLA, Official, and Bill. It also contains an abstract class Entity.

import java.util.ArrayList;
import java.util.Scanner;

public class GoaLegislativeAssembly {
    private static ArrayList<Bill> bills = new ArrayList<>();
    private static ArrayList<Official> officials = new ArrayList<>();
    private static ArrayList<MLA> mlas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    private static void displayMenu() {
        System.out.println("\n================ Goa Legislative Assembly Menu ================");
        System.out.println("1. Introduce a Bill");
        System.out.println("2. Pass a Bill");
        System.out.println("3. Display Bills");
        System.out.println("4. Elect an Official");
        System.out.println("5. View Elected Officials");
        System.out.println("6. Add an MLA");
        System.out.println("7. View MLAs");
        System.out.println("8. Exit");
        System.out.println("===============================================================");
        System.out.print("Please select an option (1-8): ");
    }

    private static void introduceBill() {
        System.out.println("\n--- Introduce a New Bill ---");
        System.out.print("Enter the title of the bill: ");
        String title = scanner.nextLine().trim();
        System.out.print("Enter the description of the bill: ");
        String description = scanner.nextLine().trim();
        bills.add(new Bill(title, description));
        System.out.println("The bill titled '" + title + "' has been successfully introduced!");
    }

    private static void passBill() {
        if (bills.isEmpty()) {
            System.out.println("\nThere are no bills available to pass at the moment.");
            return;
        }
        System.out.println("\n--- Pass a Bill ---");
        displayBills();  // Show the list of bills before choosing
        System.out.print("Enter the title of the bill you would like to pass: ");
        String title = scanner.nextLine().trim();
        for (Bill bill : bills) {
            if (bill.toString().contains(title)) {
                bill.pass();
                System.out.println("The bill titled '" + title + "' has been successfully passed.");
                return;
            }
        }
        System.out.println("No bill found with the title '" + title + "'. Please check the title and try again.");
    }

    private static void displayBills() {
        if (bills.isEmpty()) {
            System.out.println("\nNo bills have been introduced yet.");
            return;
        }
        System.out.println("\n--- List of Bills ---");
        for (Bill bill : bills) {
            System.out.println(bill);
            System.out.println();
        }
    }

    private static void addOfficial() {
        System.out.println("\n--- Elect a New Official ---");
        System.out.print("Enter the position for the official (e.g., Speaker, Secretary): ");
        String position = scanner.nextLine().trim();
        System.out.print("Enter the name of the official: ");
        String name = scanner.nextLine().trim();
        officials.add(new Official(position, name));
        System.out.println("Official '" + name + "' has been successfully elected to the position of " + position + ".");
    }

    private static void viewOfficials() {
        if (officials.isEmpty()) {
            System.out.println("\nNo officials have been elected yet.");
            return;
        }
        System.out.println("\n--- Elected Officials ---");
        for (Official official : officials) {
            System.out.println(official);
            System.out.println();
        }
    }

    private static void addMLA() {
        System.out.println("\n--- Add a New MLA ---");
        System.out.print("Enter the name of the MLA: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter the constituency of the MLA: ");
        String constituency = scanner.nextLine().trim();
        mlas.add(new MLA(name, constituency));
        System.out.println("MLA '" + name + "' from '" + constituency + "' has been successfully added.");
    }

    private static void viewMLAs() {
        if (mlas.isEmpty()) {
            System.out.println("\nNo MLAs have been added yet.");
            return;
        }
        System.out.println("\n--- List of MLAs ---");
        for (MLA mla : mlas) {
            System.out.println(mla);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int choice;
        System.out.println("===== Welcome to the Goa Legislative Assembly System =====");
        do {
            displayMenu();
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 8.");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character after integer input

            switch (choice) {
                case 1:
                    introduceBill();
                    break;
                case 2:
                    passBill();
                    break;
                case 3:
                    displayBills();
                    break;
                case 4:
                    addOfficial();
                    break;
                case 5:
                    viewOfficials();
                    break;
                case 6:
                    addMLA();
                    break;
                case 7:
                    viewMLAs();
                    break;
                case 8:
                    System.out.println("Thank you for using the Goa Legislative Assembly system! Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option between 1 and 8.");
            }
        } while (choice != 8);
    }
}

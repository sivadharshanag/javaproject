import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MedicineManagementSystem system = new MedicineManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMedicine Management System");
            System.out.println("1. Add Medicine");
            System.out.println("2. Update Medicine");
            System.out.println("3. Delete Medicine");
            System.out.println("4. Search Medicine");
            System.out.println("5. Display Medicines");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1: // Add Medicine
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
                    String expiryDate = scanner.nextLine();

                    Medicine medicine = new Medicine(id, name, quantity, price, expiryDate);
                    system.addMedicine(medicine);
                    break;

                case 2: // Update Medicine
                    System.out.print("Enter ID to update: ");
                    id = scanner.nextInt();
                    System.out.print("Enter new Quantity: ");
                    quantity = scanner.nextInt();
                    System.out.print("Enter new Price: ");
                    price = scanner.nextDouble();
                    system.updateMedicine(id, quantity, price);
                    break;

                case 3: // Delete Medicine
                    System.out.print("Enter ID to delete: ");
                    id = scanner.nextInt();
                    system.deleteMedicine(id);
                    break;

                case 4: // Search Medicine
                    System.out.print("Enter ID to search: ");
                    id = scanner.nextInt();
                    Medicine searchedMedicine = system.searchMedicine(id);
                    if (searchedMedicine != null) {
                        System.out.println(searchedMedicine);
                    } else {
                        System.out.println("Medicine not found!");
                    }
                    break;

                case 5: // Display Medicines
                    system.displayMedicines();
                    break;

                case 6: // Exit
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

import java.util.ArrayList;
import java.util.List;

public class MedicineManagementSystem {
    private List<Medicine> medicines = new ArrayList<>();

    // Add a new medicine
    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
        System.out.println("Medicine added successfully!");
    }

    // Update a medicine
    public void updateMedicine(int id, int quantity, double price) {
        for (Medicine med : medicines) {
            if (med.getId() == id) {
                med.setQuantity(quantity);
                med.setPrice(price);
                System.out.println("Medicine updated successfully!");
                return;
            }
        }
        System.out.println("Medicine not found!");
    }

    // Delete a medicine
    public void deleteMedicine(int id) {
        medicines.removeIf(med -> med.getId() == id);
        System.out.println("Medicine deleted successfully!");
    }

    // Search for a medicine
    public Medicine searchMedicine(int id) {
        for (Medicine med : medicines) {
            if (med.getId() == id) {
                return med;
            }
        }
        return null;
    }

    // Display all medicines
    public void displayMedicines() {
        if (medicines.isEmpty()) {
            System.out.println("No medicines available.");
        } else {
            for (Medicine med : medicines) {
                System.out.println(med);
            }
        }
    }
}

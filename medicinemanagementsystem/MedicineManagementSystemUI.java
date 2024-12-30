import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class MedicineManagementSystemUI {

    // Main Frame
    private JFrame frame;

    // Medicine List
    private List<Medicine> medicines = new ArrayList<>();

    public MedicineManagementSystemUI() {
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Medicine Management System");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Header
        JLabel header = new JLabel("Medicine Management System", JLabel.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(header, BorderLayout.NORTH);

        // Button Panel
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] buttonLabels = {"Add Medicine", "Update Medicine", "Delete Medicine", "Search Medicine", "Display Medicines", "Exit"};
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 14));
            buttonPanel.add(button);

            // Add Action Listeners for Buttons
            button.addActionListener(e -> handleButtonClick(label));
        }

        frame.add(buttonPanel, BorderLayout.CENTER);

        // Footer
        JLabel footer = new JLabel("© 2024 Medicine Management System", JLabel.CENTER);
        footer.setFont(new Font("Arial", Font.ITALIC, 12));
        frame.add(footer, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void handleButtonClick(String action) {
        switch (action) {
            case "Add Medicine":
                addMedicine();
                break;
            case "Update Medicine":
                updateMedicine();
                break;
            case "Delete Medicine":
                deleteMedicine();
                break;
            case "Search Medicine":
                searchMedicine();
                break;
            case "Display Medicines":
                displayMedicines();
                break;
            case "Exit":
                System.exit(0);
                break;
        }
    }

    private void addMedicine() {
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField quantityField = new JTextField();
        JTextField priceField = new JTextField();
        JTextField expiryField = new JTextField();

        Object[] message = {
                "ID:", idField,
                "Name:", nameField,
                "Quantity:", quantityField,
                "Price:", priceField,
                "Expiry Date (YYYY-MM-DD):", expiryField
        };

        int option = JOptionPane.showConfirmDialog(frame, message, "Add Medicine", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                int quantity = Integer.parseInt(quantityField.getText());
                double price = Double.parseDouble(priceField.getText());
                String expiryDate = expiryField.getText();

                medicines.add(new Medicine(id, name, quantity, price, expiryDate));
                JOptionPane.showMessageDialog(frame, "Medicine added successfully!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updateMedicine() {
        String idInput = JOptionPane.showInputDialog(frame, "Enter Medicine ID to update:");
        if (idInput != null) {
            int id = Integer.parseInt(idInput);
            for (Medicine med : medicines) {
                if (med.getId() == id) {
                    JTextField quantityField = new JTextField(String.valueOf(med.getQuantity()));
                    JTextField priceField = new JTextField(String.valueOf(med.getPrice()));

                    Object[] message = {
                            "New Quantity:", quantityField,
                            "New Price:", priceField
                    };

                    int option = JOptionPane.showConfirmDialog(frame, message, "Update Medicine", JOptionPane.OK_CANCEL_OPTION);
                    if (option == JOptionPane.OK_OPTION) {
                        med.setQuantity(Integer.parseInt(quantityField.getText()));
                        med.setPrice(Double.parseDouble(priceField.getText()));
                        JOptionPane.showMessageDialog(frame, "Medicine updated successfully!");
                    }
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "Medicine not found!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteMedicine() {
        String idInput = JOptionPane.showInputDialog(frame, "Enter Medicine ID to delete:");
        if (idInput != null) {
            int id = Integer.parseInt(idInput);
            medicines.removeIf(med -> med.getId() == id);
            JOptionPane.showMessageDialog(frame, "Medicine deleted successfully!");
        }
    }

    private void searchMedicine() {
        String idInput = JOptionPane.showInputDialog(frame, "Enter Medicine ID to search:");
        if (idInput != null) {
            int id = Integer.parseInt(idInput);
            for (Medicine med : medicines) {
                if (med.getId() == id) {
                    JOptionPane.showMessageDialog(frame, med.toString());
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "Medicine not found!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayMedicines() {
        if (medicines.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No medicines available.", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder sb = new StringBuilder();
            for (Medicine med : medicines) {
                sb.append(med).append("\n");
            }
            JOptionPane.showMessageDialog(frame, sb.toString(), "Medicines List", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Medicine Class
    static class Medicine {
        private int id;
        private String name;
        private int quantity;
        private double price;
        private String expiryDate;

        public Medicine(int id, String name, int quantity, double price, String expiryDate) {
            this.id = id;
            this.name = name;
            this.quantity = quantity;
            this.price = price;
            this.expiryDate = expiryDate;
        }

        public int getId() {
            return id;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Medicine ID: " + id + ", Name: " + name + ", Quantity: " + quantity +
                    ", Price: $" + price + ", Expiry Date: " + expiryDate;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MedicineManagementSystemUI::new);
    }
}

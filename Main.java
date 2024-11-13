import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Student> students = new ArrayList<>();
    private static List<Staff> staffMembers = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            String[] options = {"Student", "Staff", "Finish"};
            int choice = JOptionPane.showOptionDialog(null, "Select Student or Staff", "Accounting App",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == 0) {
                addStudent();
            } else if (choice == 1) {
                addStaff();
            } else {
                showReport();
                break;
            }
        }
    }

    private static void addStudent() {
        String name = getInput("Enter Student Name");
        if (name == null) return;

        String address = getInput("Enter Student Address");
        if (address == null) return;

        int year;
        while (true) {
            String yearStr = getInput("Enter Student Year (1-4)");
            if (yearStr == null) return;
            try {
                year = Integer.parseInt(yearStr);
                if (year >= 1 && year <= 4) break;
                else showMessage("Please enter a year between 1 and 4");
            } catch (NumberFormatException e) {
                showMessage("Please enter a number");
            }
        }

        students.add(new Student(name, address, year));
    }

    private static void addStaff() {
        String name = getInput("Enter Staff Name");
        if (name == null) return;

        String address = getInput("Enter Staff Address");
        if (address == null) return;

        int yearsOfService;
        while (true) {
            String yearsStr = getInput("Enter Years of Service");
            if (yearsStr == null) return;
            try {
                yearsOfService = Integer.parseInt(yearsStr);
                if (yearsOfService > 0 && yearsOfService < 30) break;
                else showMessage("Please enter years between 1 and 29");
            } catch (NumberFormatException e) {
                showMessage("Please enter a number");
            }
        }

        staffMembers.add(new Staff(name, address, yearsOfService));
    }

    private static String getInput(String message) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, message, "Input", JOptionPane.QUESTION_MESSAGE);
            if (input == null || input.trim().isEmpty()) {
                showMessage("Please enter valid information");
            } else {
                return input;
            }
        }
    }

    private static void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.ERROR_MESSAGE);
    }

    private static void showReport() {
        StringBuilder report = new StringBuilder("Student Report:\n");
        double totalIncoming = 0;
        for (int i = 0; i < students.size(); i++) {
            report.append((i + 1)).append(". ").append(students.get(i)).append("\n");
            totalIncoming += students.get(i).getInvoiceAmount();
        }

        report.append("\nStaff Report:\n");
        double totalOutgoing = 0;
        for (int i = 0; i < staffMembers.size(); i++) {
            report.append((i + 1)).append(". ").append(staffMembers.get(i)).append("\n");
            totalOutgoing += staffMembers.get(i).getBiWeeklySalary();
        }

        double netBalance = totalIncoming - totalOutgoing;
        report.append("\nTotal Incoming: $").append(String.format("%.2f", totalIncoming));
        report.append("\nTotal Outgoing: $").append(String.format("%.2f", totalOutgoing));
        report.append("\nNet Balance: $").append(String.format("%.2f", netBalance));

        JOptionPane.showMessageDialog(null, report.toString(), "Report", JOptionPane.INFORMATION_MESSAGE);
    }
}

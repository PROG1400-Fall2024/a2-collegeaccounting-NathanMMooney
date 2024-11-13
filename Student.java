public class Student {
    private String name;
    private String address;
    private int year;
    private double fee;

    public Student(String name, String address, int year) {
        this.name = name;
        this.address = address;
        this.year = year;
        this.fee = calculateFee();
    }

    private double calculateFee() {
        int baseFee = 3000;
        return baseFee + (year - 1) * 100;
    }

    public double getInvoiceAmount() {
        return fee / 2;
    }

    @Override
    public String toString() {
        return "Student: " + name + ", Address: " + address + ", Year: " + year + ", Fee: $" + String.format("%.2f", getInvoiceAmount());
    }
}

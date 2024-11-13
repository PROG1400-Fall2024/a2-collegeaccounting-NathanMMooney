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
        int baseFee = 2900;
        return baseFee + (year * 100);
    }

    public double getInvoiceAmount() {
        return calculateFee();
    }

    @Override
    public String toString() {
        return "name = " + name + ", address = " + address + ", year =  " + year + ", fee = $" + String.format("%.2f", getInvoiceAmount());
    }
}

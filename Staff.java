public class Staff {
    private String name;
    private String address;
    private int yearsOfService;
    private double salary;

    public Staff(String name, String address, int yearsOfService) {
        this.name = name;
        this.address = address;
        this.yearsOfService = yearsOfService;
        this.salary = calculateSalary();
    }

    private double calculateSalary() {
        int baseSalary = 50000;
        int stepIncrease = 500;
        return baseSalary + (yearsOfService * stepIncrease);
    }

    public double getInvoiceAmount() {
        return calculateSalary();
    }

    @Override
    public String toString() {
        return "name =  " + name + ", address =  " + address + ", years =  " + yearsOfService + ", pay = $" + String.format("%.2f", getInvoiceAmount());
    }
}

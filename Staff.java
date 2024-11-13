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

    public double getBiWeeklySalary() {
        return salary / 26;
    }

    @Override
    public String toString() {
        return "Staff: " + name + ", Address: " + address + ", Years of Service: " + yearsOfService + ", Salary: $" + String.format("%.2f", getBiWeeklySalary());
    }
}

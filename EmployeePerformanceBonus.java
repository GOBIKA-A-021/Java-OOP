import java.util.Scanner;

class Employee {
    protected String employeeName;

    Employee(String employeeName) {
        this.employeeName = employeeName;
    }

    double calculateBonus() {
        return 0.0;
    }

    double calculateBonus(double amount) {
        return 0.0;
    }
}

class TechnicalEmployee extends Employee {
    private double basicSalary;
    private int rating;

    TechnicalEmployee(String employeeName, double basicSalary, int rating) {
        super(employeeName);
        this.basicSalary = basicSalary;
        this.rating = rating;
    }

    @Override
    double calculateBonus() {
        return basicSalary * rating * 2 / 100;
    }

    double calculateBonus(double salary, int employeeRating) {
        return salary * employeeRating * 2 / 100;
    }

    double getTotalEarnings() {
        return basicSalary + calculateBonus();
    }
}

class SalesEmployee extends Employee {
    private double salesAmount;

    SalesEmployee(String employeeName, double salesAmount) {
        super(employeeName);
        this.salesAmount = salesAmount;
    }

    @Override
    double calculateBonus() {
        return salesAmount * 3 / 100;
    }

    @Override
    double calculateBonus(double amount) {
        return amount * 3 / 100;
    }

    double getTotalEarnings() {
        return salesAmount + calculateBonus();
    }
}

public class EmployeePerformanceBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int employeeType = sc.nextInt();
        String employeeName = sc.next();

        Employee employee;
        double totalEarnings;

        if (employeeType == 1) {
            double basicSalary = sc.nextDouble();
            int rating = sc.nextInt();

            TechnicalEmployee technical = new TechnicalEmployee(
                    employeeName, basicSalary, rating);
            employee = technical;
            totalEarnings = basicSalary + employee.calculateBonus();
        } else {
            double salesAmount = sc.nextDouble();

            SalesEmployee sales = new SalesEmployee(employeeName, salesAmount);
            employee = sales;
            totalEarnings = salesAmount + employee.calculateBonus();
        }

        System.out.println("Employee Name: " + employee.employeeName);
        System.out.printf("Bonus: %.2f%n", employee.calculateBonus());
        System.out.printf("Total Earnings: %.2f%n", totalEarnings);
        sc.close();
    }
}

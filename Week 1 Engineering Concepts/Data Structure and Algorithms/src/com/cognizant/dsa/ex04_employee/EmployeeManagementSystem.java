package com.cognizant.dsa.ex04_employee;

// ==========================================================
// 1. EMPLOYEE DATA MODEL
// ==========================================================
class Employee {
    private String employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "ID: " + employeeId + " | Name: " + name + " | Role: " + position + " | Salary: $" + salary;
    }
}

// ==========================================================
// 2. EMPLOYEE REPOSITORY (Using Fixed-Size Array)
// ==========================================================
class EmployeeRepository {
    private Employee[] employees;
    private int size; // Tracks the actual number of employees added

    public EmployeeRepository(int capacity) {
        this.employees = new Employee[capacity];
        this.size = 0;
    }

    // Add Employee - O(1) if capacity exists
    public void addEmployee(Employee employee) {
        if (size >= employees.length) {
            System.out.println("[ERROR]: Cannot add " + employee.getName() + ". System capacity reached!");
            return;
        }
        employees[size] = employee;
        size++;
        System.out.println("[ADDED]: Employee recorded -> " + employee.getName());
    }

    // Search Employee by ID - O(n) Time Complexity
    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equalsIgnoreCase(employeeId)) {
                return employees[i];
            }
        }
        return null; // Not found
    }

    // Traverse and print all employees - O(n) Time Complexity
    public void traverseEmployees() {
        System.out.println("\n--- Current Active Employee Directory ---");
        if (size == 0) {
            System.out.println("No records found.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
        System.out.println("-----------------------------------------");
    }

    // Delete Employee by ID - O(n) Time Complexity
    public void deleteEmployee(String employeeId) {
        int indexToDelete = -1;

        // Locate the target index
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equalsIgnoreCase(employeeId)) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete == -1) {
            System.out.println("[ERROR]: Delete failed. Employee ID " + employeeId + " not found.");
            return;
        }

        String targetName = employees[indexToDelete].getName();

        // Shift remaining elements left to plug the memory gap
        for (int i = indexToDelete; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[size - 1] = null; // Clear the duplicated last reference
        size--;
        System.out.println("[DELETED]: Successfully removed records for " + targetName);
    }
}

// ==========================================================
// 3. MAIN TEST APPLICATION
// ==========================================================
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        System.out.println("=== Testing Exercise 4: Employee Management System ===");

        // Create a repository with a fixed cap of 5 elements
        EmployeeRepository hrSystem = new EmployeeRepository(5);

        // 1. Add Employees
        hrSystem.addEmployee(new Employee("EMP101", "Raushan Kumar", "Software Engineer", 85000));
        hrSystem.addEmployee(new Employee("EMP102", "Anjali Singh", "Data Analyst", 78000));
        hrSystem.addEmployee(new Employee("EMP103", "Vikram Malhotra", "HR Manager", 92000));

        // 2. Display Directory
        hrSystem.traverseEmployees();

        // 3. Search Records
        System.out.println("Searching for EMP101...");
        Employee found = hrSystem.searchEmployee("EMP101");
        if (found != null) {
            System.out.println("Match Found -> " + found);
        } else {
            System.out.println("Employee missing.");
        }

        // 4. Delete Records
        System.out.println("\nExecuting deletion protocol...");
        hrSystem.deleteEmployee("EMP102");

        // 5. Verify Directory After Shifts
        hrSystem.traverseEmployees();
    }
}
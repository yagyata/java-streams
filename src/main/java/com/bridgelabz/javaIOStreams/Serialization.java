package com.bridgelabz.javaIOStreams;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: $" + salary);
    }
}

public class Serialization {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Alice", "IT", 75000));
        employees.add(new Employee(102, "Bob", "HR", 60000));
        employees.add(new Employee(103, "Charlie", "Finance", 85000));

        saveEmployees(employees);

        List<Employee> loadedEmployees = loadEmployees();
        for (Employee emp : loadedEmployees) {
            emp.display();
        }
    }

    private static final String FILE_NAME = "employees.txt";

    public static void saveEmployees(List<Employee> employees) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(employees);
            System.out.println("Employees saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }

    public static List<Employee> loadEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<Employee>) in.readObject();
            System.out.println("Employees loaded successfully!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading employees: " + e.getMessage());
        }
        return employees;
    }
}


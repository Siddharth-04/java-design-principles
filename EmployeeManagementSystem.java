import java.util.ArrayList;

// Employee class (Exists only within a Department)
class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Department class (Exists only within a Company)
class Department {
    private String name;
    private ArrayList<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String employeeName) {
        employees.add(new Employee(employeeName));
    }

    public void displayEmployees() {
        System.out.println("Department: " + name);
        for (Employee e : employees) {
            System.out.println(" - Employee: " + e.getName());
        }
    }
}

// Company class (Owns Departments and indirectly Employees)
class Company {
    private String name;
    private ArrayList<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public Department getDepartment(String departmentName) {
        for (Department d : departments) {
            if (d.getClass().getSimpleName().equals(departmentName)) {
                return d;
            }
        }
        return null;
    }

    public void displayCompany() {
        System.out.println("Company: " + name);
        for (Department d : departments) {
            d.displayEmployees();
        }
    }
}

// Main class to demonstrate composition
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Creating a company
        Company company = new Company("TechCorp");

        // Adding departments
        company.addDepartment("IT");
        company.addDepartment("HR");

        // Adding employees to departments
        Department itDept = company.getDepartment("IT");
        Department hrDept = company.getDepartment("HR");

        if (itDept != null) {
            itDept.addEmployee("Alice");
            itDept.addEmployee("Bob");
        }
        if (hrDept != null) {
            hrDept.addEmployee("Charlie");
        }

        // Display company structure
        company.displayCompany();
    }
}
//Company: TechCorp
//Department: IT
//Department: HR

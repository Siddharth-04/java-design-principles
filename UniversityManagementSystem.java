import java.util.ArrayList;

class University {
    public String name;
    ArrayList<Department> departments;
    ArrayList<Faculty> faculties;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList();
        this.faculties = new ArrayList();
    }

    public void addDepartment(Department department) {
        this.departments.add(department);
    }

    public void addFaculty(Faculty faculty) {
        this.faculties.add(faculty);
    }

    public void showUniversityDetails() {
        System.out.println("University name: " + this.name);
        System.out.print("\nDepartments: ");
        for (Department department : this.departments) {
            System.out.print(department.getName() + " ");
        }

        System.out.print("\nFaculties: ");
        for (Faculty faculty : this.faculties) {
            System.out.print(faculty.getName() + " ");
        }
    }
}
class Department {
    String name;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
class Faculty{
    String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
public class UniversityManagementSystem {
    public static void main(String[] args) {
        Faculty faculty1 = new Faculty("Anand");
        Faculty faculty2 = new Faculty("Abhinav");
        Department department1 = new Department("CSE");
        Department department2 = new Department("Law");


        University university = new University("Chitkara University");
        university.addDepartment(department1);
        university.addDepartment(department2);
        university.addFaculty(faculty1);
        university.addFaculty(faculty2);

        university.showUniversityDetails();
    }
}

//University name: Chitkara University
//
//Departments: CSE Law
//Faculties: Anand Abhinav

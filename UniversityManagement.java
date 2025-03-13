import java.util.ArrayList;
class Courses{
    String courseName;
    ArrayList<Students> students;
    Professor professor;

    public Courses(String courseName){
        this.courseName = courseName;
        this.students = new ArrayList();
    }

    public void enrollStudent(Students student){
        if(!students.contains(student)){
            students.add(student);
        }
    }

    public void assignProfessor(Professor professor){
        this.professor = professor;
        System.out.println(professor.getName() + " is assigned to teach " + courseName);
    }

    public void showCourseDetails(){
        System.out.println("\nCourse : " + courseName);
        System.out.println("Enrolled students : ");
        for(Students student : students){
            System.out.print(student.getName() + " ");
        }
        System.out.println();
    }
}
class Students{
    String name;
    ArrayList<Courses> coursesEnrolled;
    ArrayList<Professor> professors;

    public Students(String name) {
        this.name = name;
        this.coursesEnrolled = new ArrayList();
    }

    public String getName(){
        return name;
    }

    public void enrollCourse(Courses course) {
        if(!coursesEnrolled.contains(course)){
            coursesEnrolled.add(course);
            course.enrollStudent(this);
        }
    }

    public void viewCourses() {
        System.out.println("\n Courses Enrolled: ");

        for(Courses course: coursesEnrolled){
            System.out.print(course.courseName + " ");
        }

        System.out.println();
    }
}
class Professor{
    String name;
    ArrayList<Course> courses;

    public Professor(String name){
        this.name = name;
        this.courses = new ArrayList();
    }

    public String getName(){
        return this.name;
    }

}

class UniversityDetails {
    String name;
    ArrayList<Students> students;
    ArrayList<Professor> professors;

    public UniversityDetails(String name) {
        this.name = name;
        this.students = new ArrayList();
        this.professors = new ArrayList();
    }

    public void addStudent(Students student) {
        if (!this.students.contains(student)) {
            students.add(student);
        }
    }

    public void addProfessor(Professor professor) {
        if (!this.professors.contains(professor)) {
            professors.add(professor);
        }
    }

    public void showUniversityDetails() {
        System.out.println("\nUniversity: " + name);
        System.out.println("Professors:");

        for (Professor prof : professors) {
            System.out.println(" - " + prof.getName());
        }

        System.out.println("Students:");
        for (Students stu : students) {
            System.out.println(" - " + stu.getName());
        }

    }
}
public class UniversityManagement{
    public static void main(String[] args) {
        UniversityDetails university= new UniversityDetails("Chitkara University");

        Professor p1 = new Professor("Alakh Pandey");
        Professor p2 = new Professor("Vedantu");

        university.addProfessor(p1);
        university.addProfessor(p2);

        Students s1 = new Students("Siddharth");
        Students s2 = new Students("Abhiraj");

        university.addStudent(s1);
        university.addStudent(s2);

        Courses c1 = new Courses("Math");
        Courses c2 = new Courses("Physics");

        c1.assignProfessor(p1);
        c2.assignProfessor(p2);

        s1.enrollCourse(c1);
        s2.enrollCourse(c2);
        s1.enrollCourse(c2);

        university.showUniversityDetails();

        c1.showCourseDetails();

        s1.viewCourses();
        s2.viewCourses();

    }
}

//Alakh Pandey is assigned to teach Math
//Vedantu is assigned to teach Physics
//
//University: Chitkara University
//Professors:
//        - Alakh Pandey
// - Vedantu
//Students:
//        - Siddharth
// - Abhiraj
//
//Course : Math
//Enrolled students :
//Siddharth
//
//Courses Enrolled:
//Math Physics
//
//Courses Enrolled:
//Physics


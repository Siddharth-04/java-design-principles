import java.util.ArrayList;

class School{
    String schoolName;
     ArrayList<Student> students;

    public School(String schoolName){
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public void showStudents(){
        for(Student student : students){
            System.out.print( " Name : " + student.getName() + "\n Address : " +  student.address + "\n Id : "+ student.getId() + "\n");
            System.out.println();
        }
    }
}
class Student{
    String name;
    String address;
    int id;
    ArrayList<Course> coursesEnrolled;

    public Student(String name, String address, int id){
        this.name = name;
        this.address = address;
        this.id = id;
        this.coursesEnrolled=new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }
    public String getAddress() {
        return this.address;
    }
    public int getId() {
        return this.id;
    }

    public void addCourse(Course course){

        if(!coursesEnrolled.contains(course)) {
            coursesEnrolled.add(course);
        }
    }

    public void showCourses(){
        for(Course course : coursesEnrolled){
            System.out.println("\n" + "Course Enrolled : " + course.name);
        }
    }
}
class Course{
    String name;
    ArrayList<Student> enrolledStudents;

    public Course(String name){
        this.name = name;
        this.enrolledStudents = new ArrayList<>();
    }

    public void addStudent(Student student){
        if(!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            student.addCourse(this);
        }
    }
    public void showStudents(){
        for(Student student : enrolledStudents){
            System.out.println("Student name : " +student.name + "Course Enrolled : " + this.name + "\n");
        }
    }

}
public class SchoolManagementSystem {
    public static void main(String[] args) {
        School school = new School("Angels Public School");
        Student student1 = new Student("Siddharth","Mayur Vihar,Delhi",101);
        Student student2 = new Student("Abhiraj","Mayur Vihar,Delhi",102);
        school.addStudent(student1);
        school.addStudent(student2);

        school.showStudents(); //showing students

        Course course1 = new Course("Physics");
        Course course2 = new Course("Computer Science");

        course1.addStudent(student1);
        course2.addStudent(student1);
        course2.addStudent(student2);

        System.out.println(student1.getName());
        student1.showCourses(); //students can see their courses
        System.out.println("\n" + student2.getName());
        student2.showCourses();

    }
}

//Name : Siddharth
//Address : Mayur Vihar,Delhi
//Id : 101
//
//Name : Abhiraj
//Address : Mayur Vihar,Delhi
//Id : 102
//
//Siddharth
//
//Course Enrolled : Physics
//
//Course Enrolled : Computer Science
//
//Abhiraj
//
//Course Enrolled : Computer Science

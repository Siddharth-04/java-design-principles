import java.util.ArrayList;

class Hospital{
    String name;
    ArrayList<Patient> patients;
    ArrayList<Doctor> doctors;

    public Hospital(String name){
        this.name = name;
        this.patients = new ArrayList();
        this.doctors = new ArrayList();
    }

    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
    }

    public void showHospitalInfo() {
        System.out.println("Hospital: " + name);
        System.out.println("Doctors:");
        for (Doctor d : doctors) {
            System.out.println(" - " + d.getName());
        }
        System.out.println("Patients:");
        for (Patient p : patients) {
            System.out.println(" - " + p.getName());
        }
    }
}

class Doctor{
    String name;
    ArrayList<Patient> patients;

    public Doctor(String name){
        this.name = name;
        this.patients = new ArrayList();
    }

    public void addPatient(Patient patient){
        this.patients.add(patient);
    }

    public void consult(Patient patient){
        if(!this.patients.contains(patient)){
            this.patients.add(patient);
            patient.addDoctor(this);
        }
        System.out.println("Patient " + patient.getName() + " consulting " + this.name);
    }

    public void viewPatients(){
        System.out.print("Doctor " + this.name + " viewing patients -> ");

        for(Patient patient : patients){
            System.out.print(patient.getName() + " ");
        }
        System.out.println();
    }

    public String getName(){
        return this.name;
    }
}

class Patient{
    String name;
    ArrayList<Doctor> doctors;

    public Patient(String name){
        this.name = name;
        this.doctors = new ArrayList();
    }

    public void addDoctor(Doctor doctor){
        if(!this.doctors.contains(doctor)){
            this.doctors.add(doctor);
        }
    }


    public String getName(){
        return this.name;
    }

    public void viewDoctors() {
        System.out.println("Patient: " + this.name + " Consulting Doctors:");

        for (Doctor doctor : doctors) {
            System.out.println(" - " + doctor.getName());
        }
    }

}
public class HospitalManagementSystem {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");

        Doctor doctor1 = new Doctor("Anjana");
        Doctor doctor2 = new Doctor("Himanshu");

        Patient patient1 = new Patient("Chirag");
        Patient patient2 = new Patient("Dhruv");

        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
        hospital.addPatient(patient1);
        hospital.addPatient(patient2);

        doctor1.consult(patient1);
        doctor2.consult(patient2);

        hospital.showHospitalInfo();
    }
}

//Patient Chirag consulting Anjana
//Patient Dhruv consulting Himanshu
//Hospital: City Hospital
//Doctors:
// - Anjana
// - Himanshu
//Patients:
// - Chirag
// - Dhruv


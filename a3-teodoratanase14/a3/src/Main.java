import domain.Patient;
import exceptions.Duplicate;
import exceptions.NotFound;
import repository.*;
import service.Service;
import domain.Appointment;
import ui.UI;

import java.time.LocalDate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Duplicate, NotFound {
        /*
        PatientRepo patientsRepository = new PatientRepo();
        AppointmentRepo appointmentsRepository = new AppointmentRepo();
        Service patientsDentalService = new Service(patientsRepository, appointmentsRepository);
        UI patientsUi = new UI(patientsDentalService);
        patientsUi.run();
        */
        //text file

        IRepo<Appointment, Integer> AppointmentRepo = new AppointmentRepoTextFile("appointments.txt");
        for (Appointment a : AppointmentRepo.getAll()) {
            System.out.println(a);
        }
        Patient patient_1 = new Patient("Ioana", 1, "Cluj", 7181);
        LocalDate date = LocalDate.now();
        AppointmentRepo.addItem(new Appointment(5, patient_1, date));

        Patient patient_2 = new Patient("Ariana", 2, "Cluj", 3678);
        LocalDate date2 = LocalDate.now().plusDays(1);
        AppointmentRepo.addItem(new Appointment(1, patient_2, date2));

        Patient patient_3 = new Patient("Viorel", 3, "Cluj", 2891);
        LocalDate date3 = LocalDate.now().plusDays(2);
        AppointmentRepo.addItem(new Appointment(2, patient_3, date3));

        Patient patient_4 = new Patient("Naomi", 4, "Cluj", 2738911);
        LocalDate date4 = LocalDate.now().plusDays(4);
        AppointmentRepo.addItem(new Appointment(3, patient_4, date4));

        Patient patient_5 = new Patient("Noemi", 5, "Cluj", 478392);
        LocalDate date5 = LocalDate.now().plusDays(8);
        AppointmentRepo.addItem(new Appointment(4, patient_5, date5));


        //BINARY FILE
        /*
        IRepo<Appointment, Integer> AppointmentRepo = new AppointmentRepoBinaryFile("appointments.bin");
        for (Appointment appointment : AppointmentRepo.getAll())
            System.out.println(appointment);
*/

        // test binary file for patients
        //IRepo<Patient, Integer> patients = new PatientRepoBinaryFile("C:\\Users\\teodo\\iJ_projects\\a3-teodoratanase14\\a3\\patients.bin");
        //patients.addItem(new Patient("Teodora", 1, "Cluj", 76159));
        //patients.addItem(new Patient("Diana", 2, "Timisoara", 65893));

        //for (Patient patient: patients.getAll())

        //    System.out.println(patient);


    }
}


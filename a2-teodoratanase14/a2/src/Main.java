import exceptions.Duplicate;
import exceptions.NotFound;
import repository.AppointmentRepo;
import repository.PatientRepo;
import service.Service;
import ui.UI;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Duplicate, NotFound {
        PatientRepo patientsRepository = new PatientRepo();
        AppointmentRepo appointmentsRepository = new AppointmentRepo();
        Service patientsDentalService = new Service(patientsRepository, appointmentsRepository);
        UI patientsUi = new UI(patientsDentalService);
        patientsUi.run();

    }
}

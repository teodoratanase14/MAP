package test;

import domain.Appointment;
import domain.Patient;
import exceptions.Duplicate;
import exceptions.NotFound;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.AppointmentRepo;
import repository.PatientRepo;
import service.Service;

import java.time.LocalDate;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ServiceTest {

    private PatientRepo patients_test;
    private AppointmentRepo appointments_test;
    private Service service_test;

    @Before
    public void setUp()
    {
        patients_test = new PatientRepo();
        appointments_test = new AppointmentRepo();
        service_test = new Service(patients_test,appointments_test);

    }


    //TEST FOR PATIENT
    @Test
    public void testAddAndGetPatient() throws Duplicate, NotFound
    {
        service_test.addPatient("Mihaela",65,"Cluj",123456789);
        Patient patient = service_test.get_by_id(65);

        Assert.assertNotNull(patient);
        Assert.assertEquals("Mihaela",patient.getName());
        Assert.assertEquals(65,patient.getId().intValue());
        Assert.assertEquals("Cluj",patient.getCity());
        Assert.assertEquals(123456789,patient.getPhone_nr());
    }

    @Test(expected = NotFound.class)
    public void testGetNonExistingPatient() throws NotFound
    {
        service_test.get_by_id(3);
    }

    @Test
    public void testUpdatePatient() throws NotFound, Duplicate {
        service_test.addPatient("Anne",1,"Alba",123);
        service_test.updatePatient("Ana",1,"Cluj",321);

        Patient updated_p = service_test.get_by_id(1);
        Assert.assertEquals("Ana",updated_p.getName());
        Assert.assertEquals("Cluj",updated_p.getCity());
        Assert.assertEquals(321, updated_p.getPhone_nr());

    }

    @Test(expected = NotFound.class)
    public void testUpdateNonExistingPatient() throws NotFound
    {
        service_test.updatePatient("Anne",8,"Cluj",321);
    }

    @Test
    public void testDeletePatient() throws NotFound, Duplicate {
        service_test.addPatient("Joe",2,"Turda",12345);
        service_test.deletePatient(2);

        try
        {
            service_test.get_by_id(2);
            fail("Expected NotFound exception");
        }catch(NotFound e)
        {
            assertEquals("Not found", e.getMessage());
        }
    }

    //TESTS FOR APPOINTMENT
    @Test
    public void testAddAndGetAppointment() throws Duplicate, NotFound
    {
        Patient patient = new Patient("Mihaela",65,"Cluj",123456789);
        service_test.addPatient("Mihaela",65,"Cluj",123456789);

        LocalDate date = LocalDate.now();
        service_test.addAppointment(1,patient,date);

        Appointment appointment = service_test.get_appointment_by_id(1);

        Assert.assertNotNull(appointment);
        Assert.assertEquals(1,appointment.getId().intValue());
        Assert.assertEquals(patient,appointment.getPatient());
        Assert.assertEquals(date,appointment.getDate());

    }

    @Test(expected = NotFound.class)
    public void testGetNonExistingAppointment() throws NotFound
    {
        service_test.get_appointment_by_id(1);
    }

    @Test
    public void testUpdateAppointment() throws NotFound, Duplicate {
        Patient patient = new Patient("Mihaela",65,"Cluj",123456789);
        service_test.addPatient("Mihaela",65,"Cluj",123456789);

        LocalDate date = LocalDate.now();
        LocalDate new_date = date.plusDays(1);
        service_test.addAppointment(1,patient,date);

        service_test.updateAppointment(1,new_date);
        Appointment updated_app = service_test.get_appointment_by_id(1);

        Assert.assertEquals(new_date, updated_app.getDate());
    }

    @Test(expected = NotFound.class)
    public void testUpdateNonExistingAppointment() throws NotFound
    {
        service_test.updateAppointment(1,LocalDate.now());
    }

    @Test
    public void testDeleteAppointment() throws NotFound, Duplicate {
        Patient patient = new Patient("Joe",2,"Turda",12345);
        service_test.addPatient("Joe",2,"Turda",12345);

        LocalDate date = LocalDate.now();
        service_test.addAppointment(1,patient,date);

        service_test.deleteAppointment(1);

        try
        {
            service_test.get_by_id(1);
            fail("Expected NotFound exception");
        }catch(NotFound e)
        {
            assertEquals("Not found", e.getMessage());
           // assertEquals("No appointment was found", e.getMessage());
        }
    }
}

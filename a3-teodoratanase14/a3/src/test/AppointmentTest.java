package test;

import org.testng.*;
import org.testng.annotations.Test;
import domain.Appointment;
import domain.Patient;
import org.junit.Assert.*;
import org.junit.Before;

import java.time.LocalDate;

public class AppointmentTest {

    @Test
    public void test_getters_and_setters()
    {

        Patient patient = new Patient("Gheorghe", 9, "Cluj",999);
        LocalDate date = LocalDate.now();
        Appointment appointment = new Appointment(4,patient,date);

        Assert.assertEquals(4,appointment.getAppointment_number());
        Assert.assertEquals(patient,appointment.getPatient());
        Assert.assertEquals(date, appointment.getDate());


        //test setters
        appointment.setAppointment_number(2);
        Assert.assertEquals(2,appointment.getAppointment_number());

        Patient newPatient = new Patient("Maria", 20 , "Alba", 7654);
        appointment.setPatient(newPatient);
        Assert.assertEquals(newPatient, appointment.getPatient());

        LocalDate new_date = LocalDate.now().plusDays(1);
        appointment.setDate(new_date);
        Assert.assertEquals(new_date,appointment.getDate());
    }

    @Test
    public void testEquals()
    {
        Patient patient1 = new Patient("Monica",88,"Aiud",77);
        LocalDate date1 = LocalDate.now();
        Appointment appointment1 = new Appointment(3,patient1,date1);

        Patient patient2 = new Patient("Monica",88,"Aiud",77);
        LocalDate date2 = LocalDate.now().plusDays(1);
        Appointment appointment2 = new Appointment(3,patient2,date2);

        Assert.assertTrue(appointment1.equals(appointment2));
    }

    @Test
    public void testToString()
    {
        Patient patient = new Patient("Ioana",23,"Bucuresti",654793);
        LocalDate date = LocalDate.now();
        Appointment appointment = new Appointment(23,patient,date);

        String expected = "Appointment ID: 23\n" +
                "Patient: Ioana\n" +
                "Date: " + date + "\n";

        Assert.assertEquals(expected,appointment.toString());
    }


}

package test;
import org.testng.*;
import org.testng.annotations.Test;
import domain.Appointment;
import domain.Patient;
import org.junit.Assert.*;
import org.junit.Before;

import java.util.Optional;

public class PatientTest {

    //TEST GETTERS AND SETTERS
    @Test
    public void test_getters_and_setters()
    {
        int id = 7;
        int phone_nr=999;
        String name="Sofia";
        String city="Timisoara";

        Patient patient = new Patient(name,7,city,phone_nr);

        Assert.assertEquals("Sofia",patient.getName());
        Assert.assertEquals(7, patient.getId().intValue());
        Assert.assertEquals("Timisoara",patient.getCity());
        Assert.assertEquals(999,patient.getPhone_nr());


        //TEST SETTERS
        patient.setId(8);
        Assert.assertEquals(8,patient.getId().intValue());

        patient.setName("Sorana");
        Assert.assertEquals("Sorana",patient.getName());

        patient.setPhone_nr(761587613);
        Assert.assertEquals(761587613,patient.getPhone_nr());

        patient.setCity("Cluj");
        Assert.assertEquals("Cluj",patient.getCity());

    }

    //EQUALS
    @Test
    public void testEquals()
    {
        Patient patient1 = new Patient("Ana",1,"Alba",77);
        Patient patient2 = new Patient("Ana",1,"Alba",78);
        Assert.assertTrue(patient1.equals(patient2));
    }

    //TO STRING
    @Test
    public void testToString()
    {
        Patient patient = new Patient("Ion",4,"Cluj",66);
        String expected = "Patient { name = 'Ion\'" +
                ", id = 4, city = Cluj, phone number = 66" + " }";

            Assert.assertEquals(expected, patient.toString());

}

}

package domain;

import java.io.Serializable;
import java.time.LocalDate;

public class Appointment implements Identifiable<Integer>, Serializable
{
    private int appointment_number;
    private Patient patient;
    private LocalDate date;
    public Appointment(int appointment_number, Patient patient, LocalDate date)
    {
        this.appointment_number = appointment_number;
        this.patient = patient;
        this.date = date;
    }
    @Override
    public Integer getId()
    {
        return appointment_number;
    }
    @Override
    public void setId(Integer appointment_number)
    {
        this.appointment_number = appointment_number;
    }
    public int getAppointment_number()
    {
        return appointment_number;
    }
    public void setAppointment_number(int appointment_number)
    {
        this.appointment_number = appointment_number;
    }
    public Patient getPatient()
    {
        return patient;
    }

    public void setPatient(Patient patient)
    {
        this.patient = patient;
    }
    public LocalDate getDate()
    {
        return this.date;
    }
    public void setDate(LocalDate date)
    {
        this.date = date;
    }



    @Override
    public String toString() {


        return "Appointment ID: " + appointment_number + "\n" +
                "Patient: " + patient.getName() + "\n" +
                "Date: " + date + "\n";

    }

    @Override
    public boolean equals(Object objectToCompare)
    {
        if (this == objectToCompare)
            return true;
        if (objectToCompare.getClass() != Appointment.class)
            return false;
        Appointment d = (Appointment) objectToCompare;
        return d.appointment_number == this.appointment_number;
    }

}


/*
Design and implement a Java solution for managing
the appointments to a dentist. The program should
allow CRUD operations for patients, adding a new
appointment, cancelling an appointment,
creating different reports, etc.
*/

package domain;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Appointment {

    private double appointment_number;
    private String patient_name;
    private LocalDateTime date;

    public Appointment(double appointment_number, String patient_name, LocalDateTime date)
    {
        this.appointment_number = appointment_number;
        this.patient_name = patient_name;
        this.date = date;
    }

    public double getAppointment_number() {
        return appointment_number;
    }

    public void setAppointment_number(double appointment_number) {
        this.appointment_number = appointment_number;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString()
    {
        return "Appointment{" +
                "number='" + appointment_number + '\'' +
                ", patient name='" + patient_name + '\'' +
                '}';
    }

    public boolean equals(Object n)
    {
        if(!(n instanceof Appointment))
            return false;
        Appointment a = (Appointment) n;
        if(a.appointment_number == this.appointment_number &&
           a.patient_name.equals(this.patient_name))
                return true;
        return false;
    }
}

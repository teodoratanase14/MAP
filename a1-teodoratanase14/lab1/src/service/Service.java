package service;

import domain.Appointment;
import repository.Repository;

import javax.print.Doc;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Service
{
    private Repository repo;

    public Service(Repository r){this.repo = r;}
    //add(Appointment a)
    public void addAppointment(double appointment_number, String patient_name, LocalDateTime date)
    {
        Appointment a = new Appointment(appointment_number,  patient_name, date);
        this.repo.addAppointment(a);
    }

    public void cancelAppointment(double appointment_number)
    {
        this.repo.cancelAppointment(appointment_number);
    }

    public void updateAppointment(double appointment_number, String new_name, LocalDateTime new_date)
    {
        this.repo.updateAppointment(appointment_number, new_name, new_date);
    }

    public ArrayList<Appointment> getAll(){return this.repo.getAll();}
}

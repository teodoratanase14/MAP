package repository;

import domain.Appointment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
public class Repository
{
    private ArrayList<Appointment> appointments = new ArrayList<>();

    public void addAppointment(Appointment a)
    {
        appointments.add(a);
    }
    public void updateAppointment(double id, String new_name, LocalDateTime new_date)
    {
        Appointment a = get_by_id(id);
        a.setPatient_name(new_name);
        a.setDate(new_date);
    }
    public void cancelAppointment(double id)
    {
        //Appointment app = get_by_id(id);
        //appointments.removeIf(get_by_id(id) -> appointments);
        Appointment appointment1;
        appointment1 = get_by_id(id);
        appointments.remove(appointment1);
    }
    public ArrayList<Appointment> getAll()
    {
        return this.appointments;
    }

    public Appointment get_by_id(double id)
    {
        for(Appointment appointment: appointments)
        {
            if(appointment.getAppointment_number() == id)
                return appointment;
        }
        return null;
    }
}

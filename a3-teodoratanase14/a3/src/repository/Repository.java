package repository;

import domain.Appointment;

import java.util.ArrayList;

public class Repository {
    private ArrayList<Appointment> elements = new ArrayList<>();
    public void addAppointment(Appointment a)
    {
        this.elements.add(a);
    }

    public ArrayList<Appointment> getAll()
    {
        return this.elements;
    }
}

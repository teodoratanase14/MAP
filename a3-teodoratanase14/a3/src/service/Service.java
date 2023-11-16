package service;

import domain.Appointment;
import domain.Patient;

import exceptions.Duplicate;
import exceptions.NotFound;

import repository.AppointmentRepo;
import repository.PatientRepo;

import java.time.LocalDate;

public class Service {
    private PatientRepo patients;
    private  AppointmentRepo appointments;

    public Service(PatientRepo patients, AppointmentRepo appointments)
    {
        this.patients = patients;
        this.appointments = appointments;
    }

    //crud for patients
    public void addPatient(String name, int id, String city, int phone_nr) throws Duplicate
    {
        this.patients.addItem(new Patient(name, id, city, phone_nr));
    }
    public Patient get_by_id(int id) throws NotFound
    {
        return patients.get_by_id(id);
    }

    public Iterable<Patient> get_all_from_repo()
    {
        return  this.patients.getAll();
    }
    public void updatePatient(String new_name, int id, String new_city, int new_phone_nr) throws NotFound
    {
        Patient patient_to_update = patients.get_by_id(id);
        if(!new_name.equals(patient_to_update.getName()))
        {
            patient_to_update.setName(new_name);
        }

        if(new_phone_nr != patient_to_update.getPhone_nr())
        {
            patient_to_update.setPhone_nr(new_phone_nr);
        }

        if(!new_city.equals(patient_to_update.getCity()))
        {
            patient_to_update.setCity(new_city);
        }
        this.patients.updateItem(id,patient_to_update);

    }

    public void deletePatient(int id) throws NotFound
    {
        Patient patient_to_delete = patients.get_by_id(id);
        this.patients.deleteItem(id);

    }

    //crud for appointments
    public void addAppointment(Integer appointment_nr, Patient patient, LocalDate date) throws Duplicate
    {
        this.appointments.addItem(new Appointment(appointment_nr,patient,date));
    }
    public Appointment get_appointment_by_id(int id) throws NotFound
    {
        return appointments.get_by_id(id);
    }
    public Iterable<Appointment> get_all_appointments_from_repo()
    {
        return this.appointments.getAll();
    }
    public void updateAppointment(Integer appointment_nr, LocalDate new_date) throws NotFound
    {
        Appointment a_to_update = get_appointment_by_id(appointment_nr);
        if(!new_date.equals(a_to_update.getDate()))
            a_to_update.setDate(new_date);
    }
    public void deleteAppointment(int id) throws NotFound
    {
        Appointment a_to_delete = appointments.get_by_id(id);
        this.appointments.deleteItem(id);
    }
}

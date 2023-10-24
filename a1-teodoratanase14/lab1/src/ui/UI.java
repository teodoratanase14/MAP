package ui;

import domain.Appointment;
import service.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class UI
{
    private Service serv;
    public UI(Service serv){this.serv = serv;}
    public void listAppointments()
    {
        ArrayList<Appointment> appointments = this.serv.getAll();
        for(Appointment a: appointments)
            System.out.println(a);
    }

    public void printMenu()
    {
        System.out.println("1. List all appointments.");
        System.out.println("2. Add new appointment.");
        System.out.println("3. Cancel appointment.");
        System.out.println("4. Update appointment.");
        System.out.println("0. Exit.");
    }

    public void add_appointment(double new_appointment_number, String new_patient_name, LocalDateTime new_date)
    {
        Appointment appointment = new Appointment(new_appointment_number,new_patient_name, new_date);
        serv.addAppointment(new_appointment_number,new_patient_name, new_date);

    }

    public void cancel_appointment(double appointment_number)
    {
        serv.cancelAppointment(appointment_number);

    }

    public void update_appointment(double id, String new_name, LocalDateTime new_date)
    {
        serv.updateAppointment(id,new_name, new_date);
    }

    public void run()
    {
        while(true)
        {
            printMenu();
            System.out.println("Please input your option: ");
            Scanner scan = new Scanner(System.in);
            int command = scan.nextInt();
            switch(command)
            {
                case 0:
                    return;
                case 1:
                    listAppointments();
                    break;
                case 2:
                    System.out.println("Enter appointment number:");
                    double new_appointment_number = scan.nextDouble();

                    System.out.println("Enter patient name:");
                    String new_patient_name = scan.next();

                    System.out.println("Enter the appointment date:");
                    String dateString = scan.next();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm");
                    LocalDateTime new_date = LocalDateTime.parse(dateString, formatter);

                    add_appointment(new_appointment_number,new_patient_name, new_date);
                    break;

                case 3:
                    System.out.println("Enter appointment number:");
                    double appointment_number = scan.nextDouble();
                    cancel_appointment(appointment_number);
                    break;

                case 4:
                    System.out.println("Enter appointment number:");
                    double a_number = scan.nextDouble();

                    System.out.println("Enter the new name:");
                    String new_name = scan.next();

                    System.out.println("Enter the new appointment date:");
                    String d = scan.next();
                    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm");
                    LocalDateTime new_date2 = LocalDateTime.parse(d, formatter2);

                    update_appointment(a_number,new_name, new_date2);

            }
        }
    }
}

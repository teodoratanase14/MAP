import domain.Appointment;
import repository.Repository;
import service.Service;
import ui.UI;

import java.util.ArrayList;


public class Main
{
    public static void main(String[] args)
    {
        Repository repo = new Repository();
        Service serv = new Service(repo);
        UI ui = new UI(serv);

        //Appointment newAppointment = new Appointment(/*some data*/);
        //serv.addAppointment(1,"Tanase","01 Aug 2023 11:11");
        //serv.addAppointment(5,"Petrean", "05 Nov 2023 12:30");
        //serv.addAppointment(7,"Spatar", "20 Dec 2023 14:00");
        //serv.addAppointment(12,"Croitoru", "03 Jan 2024 10:00");
        //serv.addAppointment(2,"Bordea", "09 Feb 2024 09:15");
        //serv.addAppointment(3,"Danila", "10 Jan 2024 08:30");
        //serv.cancelAppointment(3);
        //serv.addAppointment(20,"Istrate", "13 Nov 2023 12:00");
        //serv.cancelAppointment(7);
        //serv.cancelAppointment(20);
        //get all app.
       // ArrayList<Appointment> allAppointments = Service.getAll();
        ui.run();











        //Write a Java program that prints the prime numbers
        // among the integers numbers given as command-line parameters.
        // int n = ILnteger.parseInt(args[0]);
        /*
        for (int i = 0; i < args.length; i++) {
            int ok = 1;
            int n = Integer.parseInt(String.valueOf(args[i]));
            if (n == 0 || n == 1)
                ok = 0;
            else {
                for (int j = 2; j < n; j++)
                    if (n % j == 0)
                        ok = 0;
            }
            if (ok == 1)
                System.out.p
        rintln(n);

        }*/
    }
}

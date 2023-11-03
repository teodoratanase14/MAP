package ui;

import domain.Appointment;
import domain.Patient;

import exceptions.Duplicate;
import exceptions.NotFound;

import service.Service;


import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UI 
{
    private Service serv;
    public UI(Service serv)
    {
        this.serv = serv;
    }
    public void list_all_patients()
    {
        Iterable<Patient> patients = this.serv.get_all_from_repo();
        System.out.println("\nList of patients:\n");
        for(Patient patient: patients)
            System.out.println(patient);
    }
    
    public void list_all_appointments()
    {
        Iterable<Appointment> appointments = this.serv.get_all_appointments_from_repo();
        System.out.println("\nList of appointments:\n");
        for(Appointment appointment: appointments)
            System.out.println(appointment);
    }
    
    public void addPatient() throws Duplicate
    {
        Scanner addScanner = new Scanner(System.in);
        System.out.println("Enter patient name:");
        String addName = addScanner.nextLine();
        
        int addId;
        System.out.println("Enter patient id: ");
        addId = addScanner.nextInt();
        addScanner.nextLine();




        System.out.println("Enter patient city: ");
        String addCity = addScanner.nextLine();


        int addPhoneNumber;
        System.out.println("Enter patient phone number: ");
        addPhoneNumber = addScanner.nextInt();
        addScanner.nextLine();


        try {
            serv.addPatient(addName, addId, addCity, addPhoneNumber);
        }catch (Duplicate e)
        {
            System.out.printf(" already exists");
        }
    }



    public void addAppointment() throws Duplicate, NotFound {
            Scanner addScanner = new Scanner(System.in);
            System.out.println("Enter patient name: ");
            String addName = addScanner.nextLine();

            int addId;
            while (true) {
                System.out.println("Enter patient id: ");
                if (addScanner.hasNextInt()) {
                    addId = addScanner.nextInt();
                    addScanner.nextLine();
                    break;
                } else {
                    System.out.println("Invalid input.");
                    addScanner.nextLine();
                }
            }

            System.out.println("Enter patient city: ");
            String addCity = addScanner.nextLine();


            int addPhoneNumber;
            while (true) {
                System.out.println("Enter patient phone number: ");
                if (addScanner.hasNextInt()) {
                    addPhoneNumber = addScanner.nextInt();
                    addScanner.nextLine();
                    break;
                } else {
                    System.out.println("Invalid input.");
                    addScanner.nextLine();
                }
            }
            try {
                serv.addPatient(addName, addId, addCity, addPhoneNumber);
            } catch (Duplicate e) {
                System.out.printf(" already exists");
                return;
            }
            Patient patientToAdd = new Patient(addName, addId, addCity, addPhoneNumber);

            int appointmentNumberToAdd;
            while (true) {
                System.out.println("Enter appointment number: ");
                if (addScanner.hasNextInt()) {
                    appointmentNumberToAdd = addScanner.nextInt();
                    addScanner.nextLine();
                    break;
                } else {
                    System.out.println("Invalid input.");
                    addScanner.nextLine();
                }
            }

            Scanner scannerDate = new Scanner(System.in);
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            System.out.print("Please enter a date (YYYY-MM-DD): ");
            LocalDate dateOfAppointmentToAdd = null;
            while (dateOfAppointmentToAdd == null) {
                System.out.print("Please enter a date (YYYY-MM-DD): ");
                String userInputDate = scannerDate.nextLine();
                if (userInputDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
                    dateOfAppointmentToAdd = LocalDate.parse(userInputDate, dateFormatter);
                } else {
                    System.out.println("Invalid date format. Please enter a date in the format YYYY-MM-DD.");
                }
            }

            try {
                serv.addAppointment(appointmentNumberToAdd, patientToAdd, dateOfAppointmentToAdd);
            } catch (java.time.format.DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter a date in the format YYYY-MM-DD.");
            }catch (Duplicate e) {
                System.out.println("An appointment with the same id already exists");
            }
        }



    public void getPatientById() throws NotFound {
        Scanner searchScanner = new Scanner(System.in);
        int searchId;
        while (true) {
            System.out.println("Enter patient id: ");
            if (searchScanner.hasNextInt()) {
                searchId = searchScanner.nextInt();
                searchScanner.nextLine();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                searchScanner.nextLine();
            }
        }
        try {
            Patient patientFound = serv.get_by_id(searchId);
            System.out.printf(patientFound.toString());
        }catch (NotFound e)
        {
            System.out.println("No patient found with id " + searchId);
        }
    }

    public void getAppointmentById() throws NotFound {
        Scanner searchScanner = new Scanner(System.in);
        int searchId;
        while (true) {
            System.out.println("Enter appointment number: ");
            if (searchScanner.hasNextInt()) {
                searchId = searchScanner.nextInt();
                searchScanner.nextLine();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                searchScanner.nextLine();
            }
        }
        try {
            Appointment appointmentToSearchById = serv.get_appointment_by_id(searchId);
            System.out.println(appointmentToSearchById);
        }catch (NotFound e)
        {
            System.out.println("No appointment found with id " + searchId);
        }


    }
    public void updatePatient() throws NotFound {
        System.out.println("List of patients: ");
        list_all_patients();
        Scanner updateScanner = new Scanner(System.in);
        int updateById;
        while (true) {
            System.out.println("Enter patient id: ");
            if (updateScanner.hasNextInt()) {
                updateById = updateScanner.nextInt();
                updateScanner.nextLine();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                updateScanner.nextLine();
            }
        }
        System.out.println("Enter the new patient name: ");
        String updateName = updateScanner.nextLine();

        System.out.println("Enter the new patient city: ");
        String updateCity = updateScanner.nextLine();

        int updatePhoneNumber;
        while (true) {
            System.out.println("Enter patient phone number: ");
            if (updateScanner.hasNextInt()) {
                updatePhoneNumber = updateScanner.nextInt();
                updateScanner.nextLine();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid phone number.");
                updateScanner.nextLine();
            }
        }
        try{
            serv.updatePatient(updateName, updateById, updateCity, updatePhoneNumber);
        }catch (NotFound e)
        {
            System.out.println("Patient with id " + updateById + " not found");
        }
    }

    public void updateAppointment() throws NotFound {
        Scanner updateScanner = new Scanner(System.in);
        int updateByAppointmentNumber;
        while (true) {
            System.out.println("Enter appointment number: ");
            if (updateScanner.hasNextInt()) {
                updateByAppointmentNumber = updateScanner.nextInt();
                updateScanner.nextLine();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                updateScanner.nextLine();
            }
        }
        System.out.println("Enter the new date: ");
        LocalDate updateDateOfAppointmentToAdd = null;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        while (updateDateOfAppointmentToAdd == null) {
            System.out.print("Please enter a date (YYYY-MM-DD): ");
            String userInputDate = updateScanner.nextLine();
            updateDateOfAppointmentToAdd = LocalDate.parse(userInputDate, dateFormatter);

        }

    }


    public void deletePatientByID() throws NotFound {
        Scanner deleteScanner = new Scanner(System.in);
        int deleteId;
        while (true) {
            System.out.println("Enter patient id: ");
            if (deleteScanner.hasNextInt()) {
                deleteId = deleteScanner.nextInt();
                deleteScanner.nextLine();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                deleteScanner.nextLine();
            }
        }
        try {
            serv.deletePatient(deleteId);
            System.out.printf("Patient deleted");
        }catch (NotFound e)
        {
            System.out.println("No patient found");
        }
    }

    public void deleteAppointmentByID() throws NotFound {
        Scanner deleteScanner = new Scanner(System.in);
        int deleteAppointmentNumber;
        while (true) {
            System.out.println("Enter appointment number: ");
            if (deleteScanner.hasNextInt()) {
                deleteAppointmentNumber = deleteScanner.nextInt();
                deleteScanner.nextLine();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                deleteScanner.nextLine();
            }
        }
        try {
            serv.deleteAppointment(deleteAppointmentNumber);
            System.out.printf("Appointment canceled");
        }catch (NotFound e)
        {
            System.out.println("No appointment was found");
        }
    }

    public void printMenu() {

        System.out.println("0 - Exit");
        System.out.println("1 - List all the patients");
        System.out.println("2 - Add a patient");
        System.out.println("3 - Delete a patient");
        System.out.println("4 - Update a patient");
        System.out.println("5 - Search a patient");
        System.out.println("6 - List all appointments");
        System.out.println("7 - Add an appointment");
        System.out.println("8 - Cancel an appointment");
        System.out.println("9 - Update an appointment");
        System.out.println("10 - Search an appointment");
    }

    public void run() throws Duplicate, NotFound {
        while(true)
        {
            printMenu();
            System.out.print("Please input your option: ");
            Scanner scanCommand = new Scanner(System.in);
            int command = scanCommand.nextInt();
            switch (command)
            {
                case 0:
                    System.out.println("Exiting the program.");
                    return;
                case 1:
                    System.out.println("\nList of patients:\n");
                    list_all_patients();
                    break;
                case 2:
                    addPatient();
                    break;
                case 3:
                    deletePatientByID();
                    break;
                case 4:
                    updatePatient();
                    break;
                case 5:
                    getPatientById();
                    break;
                case 6:
                    list_all_appointments();
                    break;
                case 7:
                    addAppointment();
                    break;
                case 8:
                    deleteAppointmentByID();
                    break;
                case 9:
                    updateAppointment();
                    break;
                case 10:
                    getAppointmentById();
                    break;
            }

        }
    }
}

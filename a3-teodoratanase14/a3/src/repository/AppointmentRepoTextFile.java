package repository;

import domain.Identifiable;
import domain.Appointment;
import domain.Patient;

import java.io.*;
import java.time.LocalDate;

public class AppointmentRepoTextFile extends FileRepo<Appointment, Integer>{
    @Override
    protected void readFromFile()
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(file_name)))
        {
            String line = null;
            while((line = reader.readLine())!=null)
            {
                String[] stringArray = line.split(",");
                if(stringArray.length != 3)
                {
                    continue;
                }else {
                    int appointment_nr = Integer.parseInt(stringArray[0].trim());
                    String patient_name = stringArray[1].trim();
                    int patient_id = Integer.parseInt(stringArray[2].trim());
                    String patient_city = stringArray[3].trim();
                    String phone_nr_str = stringArray[4].trim();
                    int patient_phone_nr = Integer.parseInt(phone_nr_str);
                    LocalDate date = LocalDate.parse(stringArray[5].trim());

                    Appointment appointment = new Appointment(
                            appointment_nr,
                            new Patient(patient_name,patient_id,patient_city,patient_phone_nr),
                            date
                    );
                    this.items.put(appointment.getId(),appointment);
                }
            }
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void writeToFile()
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file_name)))
        {
            for(Appointment a: getAll())
            {
                writer.write(a.getId()+","+ a.getPatient()+","+a.getDate()+"\n");
            }
        }catch (IOException e)
        {
            throw  new RuntimeException(e);
        }
    }

    public AppointmentRepoTextFile(String file_name)
    {
        super(file_name);
    }
}

package repository;

import domain.Patient;
import domain.Identifiable;

import java.io.*;
import java.time.LocalDate;

public class PatientRepoTextFile extends FileRepo<Patient,Integer>{
    @Override
    protected void readFromFile()
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(file_name)))
        {
            String line = null;
            while((line = reader.readLine())!=null)
            {
                String[] stringArray = line.split(",");
                if(stringArray.length != 4)
                {
                    continue;
                }else {
                    Patient patient = new Patient(stringArray[0].trim(), Integer.parseInt(stringArray[1].trim()),stringArray[2].trim(),Integer.parseInt(stringArray[3].trim()));
                    this.items.put(patient.getId(),patient);
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
            for(Patient p: getAll())
            {
                writer.write(p.getId()+","+ p.getName()+","+p.getPhone_nr()+","+p.getCity()+"\n");
            }
        }catch (IOException e)
        {
            throw  new RuntimeException(e);
        }
    }

    public PatientRepoTextFile(String file_name)
    {
        super(file_name);
    }
}

package repository;

import domain.Patient;

import java.io.*;
import java.util.Map;
import repository.MemooryRepo;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map;

public class PatientRepoBinaryFile extends FileRepo<Patient, Integer> {

    public PatientRepoBinaryFile(String file_name)
    {
        super(file_name);
    }
    //@Override
    protected void readFromFile()
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file_name)))
        {
            this.items = (Map<Integer,Patient>) ois.readObject();
        }catch(IOException e){
            throw new RuntimeException(e);
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    //@Override
    protected void writeToFile()
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file_name)))
        {
            oos.writeObject(this.items);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}

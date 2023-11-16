package repository;

import domain.Appointment;
import repository.MemooryRepo;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map;

public class AppointmentRepoBinaryFile extends FileRepo<Appointment, Integer>{
    public AppointmentRepoBinaryFile(String file_name)
    {
        super(file_name);
    }

    //
    // @Override
    protected void readFromFile()
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file_name)))
        {
            this.items = (Map<Integer,Appointment>) ois.readObject();
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

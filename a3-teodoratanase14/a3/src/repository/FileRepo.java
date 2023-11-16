package repository;

import domain.Identifiable;
import exceptions.Duplicate;
import exceptions.NotFound;

import java.io.BufferedReader;
import java.io.FileReader;

public abstract class FileRepo<T extends Identifiable<U>, U>extends MemooryRepo<T,U> {
    protected String file_name;
    public FileRepo(String file_name)
    {
        this.file_name=file_name;
        readFromFile();
    }

    protected abstract void readFromFile();

    protected abstract void writeToFile();
    @Override
    public void addItem(T item) throws Duplicate {
        super.addItem(item);
        writeToFile();
    }
    //@Override
    public void removeItem(U id) throws NotFound {
        super.deleteItem(id);
        writeToFile();
        //return result;
    }
}

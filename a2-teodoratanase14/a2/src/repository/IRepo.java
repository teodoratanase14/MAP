package repository;

import domain.Identifiable;
import exceptions.NotFound;
import exceptions.Duplicate;

public interface IRepo <T extends Identifiable, U>
{
    public void addItem(T item) throws Duplicate;
    public void deleteItem(U id) throws NotFound;
    public T get_by_id(U id) throws NotFound;
    public void updateItem(U id, T new_item) throws NotFound;
    public Iterable<T> getAll();
}

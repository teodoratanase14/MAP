package repository;

import domain.Identifiable;

import exceptions.Duplicate;
import exceptions.NotFound;

import java.util.HashMap;
import java.util.Map;
public class MemooryRepo<T extends Identifiable<?>, U> implements IRepo<T,U>
{
    private Map<U, T> items = new HashMap<>();
    @Override
    public void addItem(T item) throws Duplicate
    {
        if(items.containsKey(item.getId()))
            throw new Duplicate("Already exists");
        items.put((U) item.getId(), item);
    }
    @Override
    public void deleteItem(U id) throws NotFound
    {
        if(items.containsKey(id))
        {
            items.remove(id);
            return;
        }
        throw new NotFound("Not found");
    }
    @Override
    public T get_by_id(U id) throws NotFound
    {
        if(!items.containsKey(id))
            throw new NotFound("Not found");
        return items.get(id);
    }

    @Override
    public void updateItem(U id, T newItem) throws NotFound
    {
        if(items.containsKey(id))
        {
            items.replace(id,newItem);
        }
        throw new NotFound("Not found");
    }

    @Override
    public Iterable<T> getAll()
    {
        return items.values();
    }
}

package test;

import domain.Identifiable;
import exceptions.Duplicate;
import exceptions.NotFound;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.MemooryRepo;

import java.util.Objects;

import static org.testng.Assert.*;

public class MemooryRepoTest {

    private MemooryRepo<IntegerIdentifiableEntity, Integer> repo;

    @Before
    public void setUp()
    {
        repo = new MemooryRepo<>();

    }

    @Test
    public void test_add_and_get_item() throws Duplicate, NotFound
    {
        IntegerIdentifiableEntity item = new IntegerIdentifiableEntity(1,"Item 1");
        repo.addItem(item);

        IntegerIdentifiableEntity item_get = repo.get_by_id(1);

        Assert.assertNotNull(item_get);
        Assert.assertEquals(item,item_get);
    }

    @Test(expected = NotFound.class)
    public void testGetNonExistingItem() throws NotFound
    {
        repo.get_by_id(1);
    }

    @Test
    public void testUpdeteItem() throws NotFound, Duplicate {
        IntegerIdentifiableEntity item = new IntegerIdentifiableEntity(1, "Item 1");
        repo.addItem(item);

        IntegerIdentifiableEntity newItem = new IntegerIdentifiableEntity(1, "Updated Item");
        repo.updateItem(item.id, newItem);

        IntegerIdentifiableEntity updatedItem = repo.get_by_id(1);

        assertNotNull(updatedItem);
        assertEquals(newItem, updatedItem);

    }

    @Test(expected = NotFound.class)
    public void testUpdateNonExistingItem() throws NotFound
    {
        IntegerIdentifiableEntity new_item = new IntegerIdentifiableEntity(1,"Updated Item");
        repo.updateItem(1, new_item);
    }

    @Test
    public void testDeleteItem() throws NotFound, Duplicate {
        IntegerIdentifiableEntity item = new IntegerIdentifiableEntity(1,"Item 1");
        repo.addItem(item);

        repo.deleteItem(1);

        try
        {
            repo.get_by_id(1);
            fail("Expected NotFound error");
        }catch(NotFound e){
            assertEquals("Not found", e.getMessage());
        }

    }

    //mock class for testing
    //
    private static class IntegerIdentifiableEntity implements Identifiable<Integer>
    {
        private Integer id;
        private String name;

        public IntegerIdentifiableEntity(Integer id, String name)
        {
            this.id = id;
            this.name = name;
        }

        @Override
        public Integer getId()
        {
            return id;
        }

        @Override
        public void setId(Integer id)
        {
            this.id=id;
        }

        @Override
        public  boolean equals(Object obj)
        {
            if(this == obj)
                return true;
            if(obj == null || getClass()!=obj.getClass())
                return false;
            IntegerIdentifiableEntity that = (IntegerIdentifiableEntity) obj;
            return id.equals(that.id) && name.equals(that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

    }
}

package domain;

import java.util.Objects;

public class Patient implements Identifiable<Integer>{
    private int id;
    private int phone_nr;
    private String name;
    private String city;

    public Patient(String name, int id, String city, int phone_nr)
    {
        this.id = id;
        this.phone_nr = phone_nr;
        this.name = name;
        this.city = city;
    }

    @Override
    public Integer getId()
    {
        return id;
    }
    @Override
    public void setId(Integer id)
    {
        this.id = id;
    }

    public int getPhone_nr()
    {
        return phone_nr;
    }
    public void setPhone_nr(int phone_nr)
    {
        this.phone_nr = phone_nr;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getCity()
    {
        return city;
    }
    public void setCity(String city)
    {
        this.city = city;
    }




    @Override
    public String toString() {
        return "Patient { name = '" + this.name + "\'" +
                ", id = " + id + ", city = " + city + ", phone number = " + phone_nr + " }";
    }

    @Override
    public boolean equals(Object objectToCompare)
    {
        if (this == objectToCompare)
            return true;
        if (objectToCompare.getClass() != Patient.class)
            return false;
        Patient patientToCompare = (Patient) objectToCompare;
        if (Objects.equals(patientToCompare.id, this.id))
            return true;
        return false;
    }

}

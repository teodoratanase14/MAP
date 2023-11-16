package filter;

import domain.Appointment;

import java.time.LocalDate;

public class FilterAppointmentByDate implements Filter<Appointment>{
    private LocalDate min_date;

    public FilterAppointmentByDate(LocalDate min_date)
    {
        this.min_date=min_date;
    }

    @Override
    public boolean accept(Appointment a)
    {
        return a.getDate().isAfter(min_date);
    }
}

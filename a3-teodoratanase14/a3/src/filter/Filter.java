package filter;

import domain.  Appointment;
import domain.Identifiable;

public interface Filter <T extends Identifiable>{
    boolean accept(T a);
}

package sem4.homework;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Employee {
    private int tabel;
    private int phone;
    private String name;
    private int experience;

    @Override
    public String toString(){
        return String.format("Employee name: %s, tabel: %s, phone: %s, experience: %s", getName(), getTabel(), getPhone(), getExperience());
    }
}

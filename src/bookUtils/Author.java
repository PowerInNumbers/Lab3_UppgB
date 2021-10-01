package bookUtils;

import java.time.LocalDate;

public class Author {
    private String name;
    private LocalDate dateOfBirth;


    public Author(String name, int year, int month, int day) {
        this.name = name;
        dateOfBirth = LocalDate.of(year, month, day);
    }
    public Author(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }


    @Override
    public String toString() {
        String tmpStr = "";
        tmpStr += "Author: Name = " + name;
        tmpStr += "Date of birth = " + dateOfBirth.toString();
        return tmpStr;
    }

    public String getName() {
        return name;
    }
}

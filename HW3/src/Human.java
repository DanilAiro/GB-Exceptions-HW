import java.text.SimpleDateFormat;
import java.util.Date;

public class Human {
    private String name;
    private String familyName;
    private String surname;

    private Date birthday;
    private long number;
    private Sex sex;

    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public Human(String familyName, String name, String surname,  Date birthday, long number, Sex sex) {
        this.familyName = familyName;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.number = number;
        this.sex = sex;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public long getNumber() {
        return number;
    }

    public Sex getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return familyName + " " + name + " " + surname + " " + sdf.format(birthday) + " " + number + " " + sex;
    }
}

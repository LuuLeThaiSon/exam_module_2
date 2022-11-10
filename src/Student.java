import java.io.Serializable;

public class Student implements Serializable {
    private String code;
    private String name;
    private int Age;
    private String gender;
    private String address;
    private float avg;

    public Student() {
    }

    public Student(String code, String name, int age, String gender, String address, float avg) {
        this.code = code;
        this.name = name;
        Age = age;
        this.gender = gender;
        this.address = address;
        this.avg = avg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String isGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    @Override
    public String toString() {
        return "Student{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", Age=" + Age +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", avg=" + avg +
                '}';
    }
}

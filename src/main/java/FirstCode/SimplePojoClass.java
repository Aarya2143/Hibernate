package FirstCode;

import jakarta.persistence.*;

@Entity
@Table(name = "Student_Record")
public class SimplePojoClass {

    @Id
    @GeneratedValue
    @Column(name = "Stud_Rollno")
    private int rollno;

    @Column(name = "Stud_name")
    private String name;

    @Column(name = "stud_age")
    private int age;

    @Column(name = "stud_percentage")
    private double percentage;

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge(int i) {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPercentage(double v) {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public SimplePojoClass(int rollno, String name, int age, double percentage) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
        this.percentage = percentage;
    }

    public SimplePojoClass() {
        super();
    }
}

package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;

    @Column(name = "student_name", length = 30)
    private String name;

    @Column(name = "student_college",length = 70)
    private String college;

    @Column(name = "student_phone",length = 10)
    private String phone;

    @Column(name = "student_fatherName", length = 20)
    private String fatherName;

    @Column(name = "student_status", length = 5)
    private boolean active = true;

    @Lob
    private String about;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "certificate_id")
    private Certificate certificate;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public Student(long studentId, String name, String college, String phone, String fatherName, boolean active, String about) {
        this.studentId = studentId;
        this.name = name;
        this.college = college;
        this.phone = phone;
        this.fatherName = fatherName;
        this.active = active;
        this.about = about;
    }

    public Student(long studentId) {
        this.studentId = studentId;
    }

    public Student() {
        super();
    }
}

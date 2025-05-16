package OneToOneExp1;

import jakarta.persistence.*;

@Entity
public class Passenger {

    @Id
    @GeneratedValue
    @Column(name = "passenger_id")
    private int passengerId;

    private String Name;

    @OneToOne(mappedBy = "passenger")
    @JoinColumn(name = "foreginkey")
    private Passport passport;

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Passenger(int passengerId, String name, Passport passport) {
        this.passengerId = passengerId;
        Name = name;
        this.passport = passport;
    }

    public Passenger() {
        super();
    }
}

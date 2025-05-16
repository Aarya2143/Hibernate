package OneToOneExp1;

import jakarta.persistence.*;

@Entity
public class Passport {

    @Id
    @GeneratedValue
    @Column(name = "passport_id")
    private int passportId;

    private String Country;

    @OneToOne
    @JoinColumn(name = "foreginkey")
    private Passenger passenger;

    public int getPassportId() {
        return passportId;
    }

    public void setPassportId(int passportId) {
        this.passportId = passportId;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Passport(int passportId, String country, Passenger passenger) {
        this.passportId = passportId;
        Country = country;
        this.passenger = passenger;
    }

    public Passport() {
        super();
    }
}

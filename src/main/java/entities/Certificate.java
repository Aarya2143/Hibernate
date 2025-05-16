package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "certificate")
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long certificateId;

    private String title;

    private String about;

    private String link;




    public long getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(long certificateId) {
        this.certificateId = certificateId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    public Certificate(long certificateId, String title, String about, String link) {
        this.certificateId = certificateId;
        this.title = title;
        this.about = about;
        this.link = link;
    }


    public Certificate() {
        super();
    }
}

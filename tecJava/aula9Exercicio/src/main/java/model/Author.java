package model;

import jakarta.persistence.*;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @Column(name = "AuthorID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AuthorID;

    @Column(name = "FirstName")
    private String FirstName;

    @Column(name = "LastName")
    private String LastName;

    public Author() {
    }

    public Author(String FirstName, String LastName) {
        this.FirstName = FirstName;
        this.LastName = LastName;
    }

    public Long getAuthorID() {
        return AuthorID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }
}

package model;

import jakarta.persistence.*;

@Entity
@Table(name = "authorisbn")
public class AuthorISBN {
    @Id
    @ManyToOne
    @JoinColumn(name = "AuthorID")
    private Author author;

    @Id
    @ManyToOne
    @JoinColumn(name = "ISBN")
    private Title title;

    public AuthorISBN() {}

    public AuthorISBN(Author author, Title title) {
        this.author = author;
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public Title getTitle() {
        return title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setTitle(Title title) {
        this.title = title;
    }
}

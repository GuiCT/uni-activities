package model;

import jakarta.persistence.*;

import java.util.List;

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

    /**
     * Retorna todos os livros desse autor
     * @return Lista de livros associados à essa instância de `Author`
     */
    public List<Title> getAllBooks() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        // Join AuthorISBN and Title tables, where AuthorISBN.AuthorID = this.AuthorID
        List<Title> titles = em.createQuery("SELECT t FROM AuthorISBN a, Title t WHERE a.title.ISBN = t.ISBN AND a.author.AuthorID = :AuthorID", Title.class)
                .setParameter("AuthorID", this.AuthorID)
                .getResultList();
        em.close();
        emf.close();

        return titles;
    }


    /**
     * Retorna todos os autores presentes no Banco de Dados
     * @return Lista de autores
     */
    public static List<Author> getAllAuthors() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        List<Author> authors = em.createQuery("SELECT a FROM Author a", Author.class).getResultList();
        em.close();
        emf.close();

        return authors;
    }
}

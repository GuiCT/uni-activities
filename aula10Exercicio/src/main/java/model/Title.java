package model;

import jakarta.persistence.*;

@Entity
@Table(name = "titles")
public class Title {
    @Id
    @Column(name = "ISBN")
    private String ISBN;

    @Column(name = "Title")
    private String Title;

    @Column(name = "EditionNumber")
    private Integer EditionNumber;

    @Column(name = "Copyright")
    private String Copyright;

    public Title() {}

    public Title(String ISBN, String Title, Integer EditionNumber, String CopyRight) {
        this.ISBN = ISBN;
        this.Title = Title;
        this.EditionNumber = EditionNumber;
        this.Copyright = CopyRight;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return Title;
    }

    public Integer getEditionNumber() {
        return EditionNumber;
    }

    public String getCopyright() {
        return Copyright;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setEditionNumber(Integer editionNumber) {
        EditionNumber = editionNumber;
    }

    public void setCopyright(String copyright) {
        Copyright = copyright;
    }

    /**
     * Insere essa instância de livro no banco de dados
     * @param author Autor do livro
     */
    public void insertBook(Author author) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(this);
        em.persist(new AuthorISBN(author, this));
        em.getTransaction().commit();
        em.close();
    }
}

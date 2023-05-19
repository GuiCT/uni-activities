import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import model.Author;
import model.AuthorISBN;
import model.Title;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = jakarta.persistence.Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        // Adicionando dois autores
        Author author1 = new Author("João", "Silva");
        Author author2 = new Author("Maria", "Silva");
        // Persistindo no Banco de Dados
        em.getTransaction().begin();
        em.persist(author1);
        em.persist(author2);
        em.getTransaction().commit();
        // Criando e persistindo um livro pertencente ao author1
        Title title1 = new Title("123456789", "Livro 1", 1, "2021");
        title1.insertBook(author1);
        // Criando e persistindo um livro pertencente ao author2
        Title title2 = new Title("987654321", "Livro 2", 2, "2021");
        title2.insertBook(author2);

        // Verificando se ambos os autores estão no Banco de Dados
        List<Author> authors = Author.getAllAuthors();
        authors.forEach(author -> System.out.println(author.getFirstName() + " " + author.getLastName()));
        // Verificando se os autores possuem autoria sobre os livros persistidos
        List<Title> titlesAuthor1 = author1.getAllBooks();
        List<Title> titlesAuthor2 = author2.getAllBooks();
        titlesAuthor1.forEach(title -> System.out.println(title.getTitle()));
        titlesAuthor2.forEach(title -> System.out.println(title.getTitle()));
        // Fim.
    }
}

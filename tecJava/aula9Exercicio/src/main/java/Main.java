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
        Author a1 = new Author("Fulano", "Silva");
        Author a2 = new Author("Beltrano", "Santos");
        Author a3 = new Author("Ciclano", "Souza");
        // Adicionando autores
        em.getTransaction().begin();
        em.persist(a1);
        em.persist(a2);
        em.persist(a3);
        em.getTransaction().commit();
        // Adicionando títulos (livros)
        Title t1 = new Title("123-456-789-0", "Java para iniciantes", 1, "Copyright 2023, Editora Ficticia");
        Title t2 = new Title("123-456-789-1", "Java para intermediários", 2, "Copyright 2023, Editora Ficticia");
        Title t3 = new Title("123-456-789-2", "Java para avançados", 3, "Copyright 2023, Editora Ficticia");
        em.getTransaction().begin();
        em.persist(t1);
        em.persist(t2);
        em.persist(t3);
        em.getTransaction().commit();
        // Adicionando relacionamento entre autores e títulos
        AuthorISBN a1t1 = new AuthorISBN(a1, t1);
        AuthorISBN a2t2 = new AuthorISBN(a2, t2);
        AuthorISBN a2t3 = new AuthorISBN(a2, t3);
        AuthorISBN a3t3 = new AuthorISBN(a3, t3);
        em.getTransaction().begin();
        em.persist(a1t1);
        em.persist(a2t2);
        em.persist(a2t3);
        em.persist(a3t3);
        em.getTransaction().commit();
        // Trocando nome do autor 1
        a1.setLastName("Santos");
        // Salvando alterações
        em.getTransaction().begin();
        em.merge(a1);
        em.getTransaction().commit();
        // Removendo relação entre autor 2 e título 3
        em.getTransaction().begin();
        em.remove(a2t3);
        em.getTransaction().commit();
        // Executando consulta para recuperar todos os autores e títulos relacionados
        List<AuthorISBN> authorRelations = em.createQuery("SELECT a FROM AuthorISBN a", AuthorISBN.class).getResultList();
        // Exibindo resultado
        System.out.println("Relações entre autores e títulos:");
        for (AuthorISBN authorRelation : authorRelations) {
            System.out.println(authorRelation.getAuthor().getFirstName() + " " + authorRelation.getAuthor().getLastName() + " - " + authorRelation.getTitle().getTitle());
        }
        // Fim.
    }
}

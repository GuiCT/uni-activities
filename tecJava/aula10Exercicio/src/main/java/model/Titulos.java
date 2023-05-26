/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;

/**
 *
 * @author guilherme
 */
@Entity
@Table(name = "titulos")
@NamedQueries({
    @NamedQuery(name = "Titulos.findAll", query = "SELECT t FROM Titulos t"),
    @NamedQuery(name = "Titulos.findByIsbn", query = "SELECT t FROM Titulos t WHERE t.isbn = :isbn"),
    @NamedQuery(name = "Titulos.findByTitulo", query = "SELECT t FROM Titulos t WHERE t.titulo = :titulo"),
    @NamedQuery(name = "Titulos.findByEdicao", query = "SELECT t FROM Titulos t WHERE t.edicao = :edicao"),
    @NamedQuery(name = "Titulos.findByAno", query = "SELECT t FROM Titulos t WHERE t.ano = :ano")})
    // Query utilizada para inserir livro no Banco de Dados
    @NamedQuery(name = "Titulo.add", query = "INSERT INTO Titulos (isbn, titulo, edicao, ano) VALUES (:isbn, :titulo, :edicao, :ano)")
public class Titulos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ISBN")
    private String isbn;
    @Basic(optional = false)
    @Column(name = "Titulo")
    private String titulo;
    @Column(name = "Edicao")
    private Integer edicao;
    @Column(name = "Ano")
    private String ano;
    @JoinTable(name = "autorisbn", joinColumns = {
        @JoinColumn(name = "ISBN", referencedColumnName = "ISBN")}, inverseJoinColumns = {
        @JoinColumn(name = "idAutor", referencedColumnName = "idAutor")})
    @ManyToMany
    private Collection<Autores> autoresCollection;

    public Titulos() {
    }

    public Titulos(String isbn) {
        this.isbn = isbn;
    }

    public Titulos(String isbn, String titulo) {
        this.isbn = isbn;
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getEdicao() {
        return edicao;
    }

    public void setEdicao(Integer edicao) {
        this.edicao = edicao;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Collection<Autores> getAutoresCollection() {
        return autoresCollection;
    }

    public void setAutoresCollection(Collection<Autores> autoresCollection) {
        this.autoresCollection = autoresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Titulos)) {
            return false;
        }
        Titulos other = (Titulos) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Titulos[ isbn=" + isbn + " ]";
    }

    /**
     * Função que adiciona um livro no Banco de Dados
     */
    public void addToDatabase() {
        EntityManager em = Persistence.createEntityManagerFactory("com_exercicioAula10_jar_1.0PU").createEntityManager();
        em.getTransaction().begin();
        // Executa NamedQuery definida no cabeçalho da classe
        // Insere os parâmetros necessários
        Query query = em.createNamedQuery("Titulo.add");
        query.setParameter("isbn", this.isbn);
        query.setParameter("titulo", this.titulo);
        query.setParameter("edicao", this.edicao);
        query.setParameter("ano", this.ano);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
    
}

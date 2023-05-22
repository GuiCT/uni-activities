/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.Query;

/**
 *
 * @author guilherme
 */
@Entity
@Table(name = "autores")
@NamedQueries({
    @NamedQuery(name = "Autores.findAll", query = "SELECT a FROM Autores a"),
    @NamedQuery(name = "Autores.findByIdAutor", query = "SELECT a FROM Autores a WHERE a.idAutor = :idAutor"),
    @NamedQuery(name = "Autores.findByNome", query = "SELECT a FROM Autores a WHERE a.nome = :nome"),
    @NamedQuery(name = "Autores.findBySobrenome", query = "SELECT a FROM Autores a WHERE a.sobrenome = :sobrenome")})
public class Autores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAutor")
    private Integer idAutor;
    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "Sobrenome")
    private String sobrenome;
    @ManyToMany(mappedBy = "autoresCollection")
    private Collection<Titulos> titulosCollection;

    public Autores() {
    }

    public Autores(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public Autores(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Collection<Titulos> getTitulosCollection() {
        return titulosCollection;
    }

    public void setTitulosCollection(Collection<Titulos> titulosCollection) {
        this.titulosCollection = titulosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAutor != null ? idAutor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autores)) {
            return false;
        }
        Autores other = (Autores) object;
        if ((this.idAutor == null && other.idAutor != null) || (this.idAutor != null && !this.idAutor.equals(other.idAutor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Autores[ idAutor=" + idAutor + " ]";
    }
    
    /**
     * Função que retorna todos os autores presentes no Banco de Dados
     * Utiliza a NamedQuery gerada pelo NetBeans
     * @return Coleção de Autores com todos os autores presentes no Banco de Dados
     */
    public static Collection<Autores> getAllAutores() {
        EntityManager em = Persistence.createEntityManagerFactory("com_exercicioAula10_jar_1.0PU").createEntityManager();
        Query query = em.createNamedQuery("Autores.findAll", Autores.class);
        List<Autores> resultList = query.getResultList();
        return resultList;
    }

    /**
     * Função que retorna todos os livros de um autor
     * Utiliza a NamedQuery gerada pelo NetBeans
     * @return Coleção de Títulos com todos os títulos da instância de Autor
     */
    public Collection<Titulos> getTitulos() {
        // Realizando cópia do Collection para uma lista
        return titulosCollection.stream().toList();
    }
}

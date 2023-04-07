package aula05.model;

import java.io.Serializable;

public class Livro implements Serializable {
  private String nome;
  private String descricao;
  private int quantidade;

  public String getNome() {
    return nome;
  }

  public Livro setNome(String nome) {
    this.nome = nome;
    return this;
  }

  public String getDescricao() {
    return descricao;
  }

  public Livro setDescricao(String descricao) {
    this.descricao = descricao;
    return this;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public Livro setQuantidade(int quantidade) {
    this.quantidade = quantidade;
    return this;
  }

  @Override
  public String toString() {
    return String.format("%s\n%s\nQuantidade: %d", this.nome, this.descricao, this.quantidade);
  }
}

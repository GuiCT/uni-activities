package aula05.model;

import java.io.Serializable;

public class Biblioteca implements Serializable {
  private String nome;
  private String local;

  public String getNome() {
    return nome;
  }

  public Biblioteca setNome(String nome) {
    this.nome = nome;
    return this;
  }

  public String getLocal() {
    return local;
  }

  public Biblioteca setLocal(String local) {
    this.local = local;
    return this;
  }

  @Override
  public String toString() {
    return String.format("%s\n%s", this.nome, this.local);
  }
}

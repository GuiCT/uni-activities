package aula05.controller;

import java.io.IOException;

import aula05.model.Livro;

public class ControllerLivro {
  public void cadastrarLivro(String nome, String descricao, int quantidade) throws ClassNotFoundException, IOException {
    // Cria um novo livro
    Livro livro = new Livro()
        .setNome(nome)
        .setDescricao(descricao)
        .setQuantidade(quantidade);

    // Adiciona o livro à lista de livros
    Storage.getInstance().livros.add(livro);
    // Salva a instância
    Storage.saveInstance();
  }

  public String listarLivros() throws ClassNotFoundException, IOException {
    // Cria uma string com todos os livros
    String livros = "";
    for (Livro livro : Storage.getInstance().livros) {
      livros += livro.toString() + "\n";
    }

    // Caso não haja livros
    if (livros == "")
      livros = "Não há livros cadastrados.";
    return livros;
  }
}

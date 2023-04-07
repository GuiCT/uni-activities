package aula05.controller;

import aula05.model.Biblioteca;
import java.io.IOException;

public class ControllerBiblioteca {
  public void cadastrarBiblioteca(String nome, String local) throws ClassNotFoundException, IOException {
    // Cria uma nova biblioteca
    Biblioteca biblioteca = new Biblioteca()
        .setNome(nome)
        .setLocal(local);

    // Adiciona o livro à lista de livros
    Storage.getInstance().bibliotecas.add(biblioteca);
    // Salva a instância
    Storage.saveInstance();
  }

  public String listarBibliotecas() throws ClassNotFoundException, IOException {
    // Cria uma string com todos os livros
    String bibliotecas = "";
    for (Biblioteca biblioteca : Storage.getInstance().bibliotecas) {
      bibliotecas += biblioteca.toString() + "\n";
    }

    // Caso não haja bibliotecas
    if (bibliotecas == "")
      bibliotecas = "Não há bibliotecas cadastradas.";
    return bibliotecas;
  }
}

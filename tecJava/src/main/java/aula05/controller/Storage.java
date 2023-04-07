package aula05.controller;

import aula05.model.Biblioteca;
import aula05.model.Livro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Storage implements Serializable {
  public static Storage instance;
  public List<Livro> livros;
  public List<Biblioteca> bibliotecas;

  public Storage() {
    this.livros = new ArrayList<>();
    this.bibliotecas = new ArrayList<>();
  }

  // Utiliza instância atual se existir
  // Caso contrário, lê do arquivo storage.ser
  public static Storage getInstance() throws IOException, ClassNotFoundException {
    if (instance == null) {
      // Abrindo arquivo
      File file = new File("storage.ser");
      // Caso existir, ler conteúdo
      if (file.exists()) {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        instance = (Storage) objectInputStream.readObject();
        objectInputStream.close();
      } else {
        // Caso não existir, criar nova instância
        instance = new Storage();
      }
    }
    return instance;
  }

  public static void saveInstance() throws IOException {
    File file = new File("storage.ser");
    // Caso arquivo não existir, crie
    if (!file.exists()) {
      file.createNewFile();
    }

    FileOutputStream fileOutputStream = new FileOutputStream(file);
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    objectOutputStream.writeObject(instance);
    objectOutputStream.close();
  }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.exercicioaula10;

import java.util.Collection;
import model.Autores;
import model.Titulos;


/**
 *
 * @author guilherme
 */
public class ExercicioAula10 {

    public static void main(String[] args) {
        // Funções criadas como pede o exercício
        // Listar todos autores presentes no Banco de Dados:
        Collection<Autores> todosAutores = Autores.getAllAutores();
        // Todos os títulos de um determinado autor
        Autores autor = new Autores(1); // Autor com ID 1 no Banco de Dados
        Collection<Titulos> titulosAutor = autor.getTitulos();
        // Inserção de um título no Banco de Dados
        Titulos titulo = new Titulos("123456", "Titulo de um autor");
        titulo.addToDatabase();
    }
}

package view;

import model.BookModel;

public class LibraryView {
    public void showMenu() {
        System.out.println("======== MENU ========");
        System.out.println("1 - Cadastrar livros");
        System.out.println("2 - Listar todos os livros");
        System.out.println("3 - Listar livros disponíveis");
        System.out.println("4 - Listar livros por autor");
        System.out.println("5 - Listar livros por ano");
        System.out.println("6 - Pegar livro emprestado");
        System.out.println("7 - Devolver livro");
        System.out.println("8 - sair");
    }

    public void showBook(BookModel book) {
        System.out.println("Nome: " + book.getName());
        System.out.println("ID: " + book.getId());
    }

    public void message(String message) {
        System.out.println(message);
    }

    public void erro() {
        System.out.println("ERRO");
    }

    public void erro(String message) {
        System.err.println(message);
    }
}

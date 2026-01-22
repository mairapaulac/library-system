package model;

public class Book {

    private String isbn;
    private String titulo;
    private String autor;
    private StatusLivro status = StatusLivro.DISPONIVEL;

    public boolean estaDisponivel() {
        return status == StatusLivro.DISPONIVEL;
    }

    public void emprestar() {
        if (!estaDisponivel()) {
            throw new IllegalStateException("Livro já emprestado");
        }
        status = StatusLivro.EMPRESTADO;
    }

    public void devolver() {
        status = StatusLivro.DISPONIVEL;
    }
}

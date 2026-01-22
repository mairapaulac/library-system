package model;

import java.time.LocalDate;

public class Emprestimo {

    private Book book;
    private User user;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean finalizado;

    public Emprestimo(Book book, User user, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.book = book;
        this.user = user;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.finalizado = false;
    }


    public boolean estaAtivo() {
        return !finalizado;
    }

    public boolean estaAtrasado() {
        return !finalizado && LocalDate.now().isAfter(dataDevolucao);
    }

    public void finalizar() {
        this.finalizado = true;
    }

    // Getters
    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}

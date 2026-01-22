package service;

import model.Book;
import model.Emprestimo;
import model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryService {

    private List<Book> books = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();


    public void adicionarLivro(Book book) {
        books.add(book);
    }

    public Emprestimo realizarEmprestimo(Book book, User user) {

        if (!book.estaDisponivel()) {
            throw new IllegalStateException("Livro indisponível");
        }

        if (!user.podePegarEmprestimo()) {
            throw new IllegalStateException("Usuário atingiu o limite");
        }

        book.emprestar();
        user.adicionarEmprestimo();

        Emprestimo emprestimo = new Emprestimo(
                book,
                user,
                LocalDate.now(),
                LocalDate.now().plusDays(7)
        );

        emprestimos.add(emprestimo);
        return emprestimo;
    }

    public void realizarDevolucao(Emprestimo emprestimo) {
        emprestimo.getBook().devolver();
        emprestimo.getUser().removerEmprestimo();
        emprestimo.finalizar();
    }


    public List<Book> listarTodosOsLivros() {
        return books;
    }


    public List<Book> listarLivrosDisponiveis() {
        return books.stream()
                .filter(Book::estaDisponivel)
                .collect(Collectors.toList());
    }

    public List<Book> listarLivrosEmprestados() {
        return books.stream()
                .filter(book -> !book.estaDisponivel())
                .collect(Collectors.toList());
    }

    public List<Emprestimo> listarEmprestimosAtivos() {
        return emprestimos.stream()
                .filter(Emprestimo::estaAtivo)
                .collect(Collectors.toList());
    }

    public List<Emprestimo> consultarEmprestimosPorUsuario(User user) {
        return emprestimos.stream()
                .filter(e -> e.getUser().equals(user))
                .collect(Collectors.toList());
    }
}

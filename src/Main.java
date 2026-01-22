import model.Book;
import model.Emprestimo;
import model.Student;
import model.User;
import service.LibraryService;

public class Main {

    public static void main(String[] args) {

        LibraryService service = new LibraryService();

        Book book1 = new Book();
        Book book2 = new Book();

        User student = new Student();

        service.adicionarLivro(book1);
        service.adicionarLivro(book2);

        // Empréstimo
        service.realizarEmprestimo(book1, student);

        // Consultas
        System.out.println("Todos os livros: " + service.listarTodosOsLivros().size());
        System.out.println("Disponíveis: " + service.listarLivrosDisponiveis().size());
        System.out.println("Emprestados: " + service.listarLivrosEmprestados().size());
        System.out.println("Empréstimos ativos: " + service.listarEmprestimosAtivos().size());
        System.out.println("Empréstimos do usuário: " +
                service.consultarEmprestimosPorUsuario(student).size());

    }
}

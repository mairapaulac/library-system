package model;

public abstract class User {

    private String nome;
    private int id;
    private int qtdEmprestimosAtuais;

    protected abstract int getLimiteEmprestimo();

    public void adicionarEmprestimo() {
        if (!podePegarEmprestimo()) {
            throw new IllegalStateException("Limite de empréstimos atingido");
        }
        qtdEmprestimosAtuais++;
    }

    public void removerEmprestimo() {
        if (qtdEmprestimosAtuais > 0) {
            qtdEmprestimosAtuais--;
        }
    }

    public boolean podePegarEmprestimo() {
        return qtdEmprestimosAtuais < getLimiteEmprestimo();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

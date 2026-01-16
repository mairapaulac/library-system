package model;

public abstract class User {
    private String nome;
    private String id;
    //emprestimos que o usuario tem

    //método abstrato --> limite de empréstimos

    public abstract int getLimiteEmprestimo();

}

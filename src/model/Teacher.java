package model;

public class Teacher extends User {

    @Override
    protected int getLimiteEmprestimo() {
        return 4;
    }

}

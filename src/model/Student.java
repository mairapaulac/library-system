package model;

public class Student extends User {

    @Override
    protected int getLimiteEmprestimo() {
        return 2;
    }


}

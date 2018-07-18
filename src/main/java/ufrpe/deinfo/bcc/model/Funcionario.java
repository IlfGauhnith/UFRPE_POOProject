package ufrpe.deinfo.bcc.model;

public class Funcionario {
    private String nome;
    private String cod;
    private Cargos cargo;
    private String login;
    private String senha;

    public enum Cargos { CHEFEOFICINA, MECANICOCHEFE, ASSISTENTEMECANICO} //É correto declarar o enum aqui?

    public Funcionario(String nome, String cod, Cargos cargo, String login, String senha) {
        this.nome = nome;
        this.cod = cod;
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Cargos getCargo() {
        return cargo;
    }

    public void setCargo(Cargos cargo) {
        this.cargo = cargo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Funcionario that = (Funcionario) o;

        if (!login.equals(that.login)) return false;
        return senha.equals(that.senha);
    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + senha.hashCode();
        return result;
    }
}

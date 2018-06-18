package ufrpe.deinfo.bcc.model;

public class ClienteFisico extends Cliente {
    private String nome;
    private String cpf;

    public ClienteFisico(Endereco endereco, String email, String telefone, String nome, String cpf) {
        super(endereco, email, telefone);
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClienteFisico)) return false;
        if (!super.equals(o)) return false; //Testa os atributos da classe mãe

        ClienteFisico that = (ClienteFisico) o;

        if (!getNome().equals(that.getNome())) return false;
        return getCpf().equals(that.getCpf());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getNome().hashCode();
        result = 31 * result + getCpf().hashCode();
        return result;
    }
}

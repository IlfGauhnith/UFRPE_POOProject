package ufrpe.deinfo.bcc.model;

public class ClienteJuridico extends Cliente {
    private String cnpj;
    private String razaoSocial;

    public ClienteJuridico(Endereco endereco, String email, String telefone, String cnpj, String razaoSocial) {
        super(endereco, email, telefone);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClienteJuridico)) return false;
        if (!super.equals(o)) return false;

        ClienteJuridico that = (ClienteJuridico) o;

        if (!getCnpj().equals(that.getCnpj())) return false;
        return getRazaoSocial().equals(that.getRazaoSocial());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getCnpj().hashCode();
        result = 31 * result + getRazaoSocial().hashCode();
        return result;
    }
}

package ufrpe.deinfo.bcc.model;

import java.util.LinkedHashSet;
import java.util.Set;

public abstract class Cliente {
    private Endereco endereco;
    private String email;
    private String telefone;
    private Set<Caminhao> frota;

    public Cliente(Endereco endereco, String email, String telefone) {
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        frota = new LinkedHashSet<>();
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;

        Cliente cliente = (Cliente) o;

        if (!getEmail().equals(cliente.getEmail())) return false;
        return getTelefone().equals(cliente.getTelefone());
    }

    @Override
    public int hashCode() {
        int result = getEmail().hashCode();
        result = 31 * result + getTelefone().hashCode();
        return result;
    }
}

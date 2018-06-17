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
}

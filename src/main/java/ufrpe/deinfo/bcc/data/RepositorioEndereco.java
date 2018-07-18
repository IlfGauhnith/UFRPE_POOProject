package ufrpe.deinfo.bcc.data;

import ufrpe.deinfo.bcc.model.Endereco;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RepositorioEndereco implements IRepositorio<Endereco> {
    private static RepositorioEndereco instance;
    private Set<Endereco> repositorio;

    private RepositorioEndereco() {
        repositorio = new HashSet<Endereco>();
    }

    public static RepositorioEndereco getInstance() {
        if(instance == null)
            instance = new RepositorioEndereco();

        return instance;
    }

    public void criar(Endereco o) throws IllegalArgumentException {
        if(o == null)
            throw new IllegalArgumentException("Argumento NULO");
        else if(repositorio.add(o))
            throw new IllegalArgumentException();
    }

    public void deletar(Endereco o) throws IllegalArgumentException {
        if(o == null)
            throw new IllegalArgumentException("Argumento NULO");
        else if(repositorio.remove(o))
            throw new IllegalArgumentException();
    }

    public Collection<Endereco> ler() {
        return repositorio;
    }

    public void persist() {

    }
}

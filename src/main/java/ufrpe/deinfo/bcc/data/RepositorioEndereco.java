package ufrpe.deinfo.bcc.data;

import ufrpe.deinfo.bcc.model.Endereco;

import java.util.*;

public class RepositorioEndereco implements IRepositorio<Endereco> {
    private static RepositorioEndereco instance;
    private List<Endereco> repositorio;

    private RepositorioEndereco() {
        repositorio = new ArrayList<>();
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

    public List<Endereco> ler() {
        return repositorio;
    }

    public void persist() {

    }
}

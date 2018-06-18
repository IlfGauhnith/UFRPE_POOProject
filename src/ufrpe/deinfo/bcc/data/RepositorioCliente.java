package ufrpe.deinfo.bcc.data;

import ufrpe.deinfo.bcc.model.Cliente;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RepositorioCliente implements IRepositorio<Cliente> {
    private static RepositorioCliente instance;
    private Set<Cliente> repositorio;

    private RepositorioCliente() {
        repositorio = new HashSet<Cliente>();
    }

    public static RepositorioCliente getInstance() {
        if(instance == null)
            instance = new RepositorioCliente();
        return instance;
    }


    @Override
    public void criar(Cliente o) throws IllegalArgumentException{
        if(o == null)
            throw new IllegalArgumentException("Argumento NULO");
        else if(!repositorio.add(o))
            throw new IllegalArgumentException("Cliente já consta no repositorio");
    }

    @Override
    public void deletar(Cliente o) throws IllegalArgumentException {
        if(o == null)
            throw new IllegalArgumentException("Argumento NULO");
        else if(!repositorio.remove(o))
            throw new IllegalArgumentException();
    }

    @Override
    public Collection<Cliente> ler() {
        return repositorio;
    }
}

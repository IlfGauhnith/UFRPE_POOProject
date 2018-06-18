package ufrpe.deinfo.bcc.data;

import ufrpe.deinfo.bcc.model.Servico;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RepositorioServico implements IRepositorio<Servico> {
    private static RepositorioServico instance;
    private Set<Servico> repositorio;

    private RepositorioServico() {
        repositorio = new HashSet<Servico>();
    }

    public static RepositorioServico getInstance() {
        if(instance == null)
            instance = new RepositorioServico();

        return instance;
    }

    @Override
    public void criar(Servico o) throws IllegalArgumentException {
        if(o == null)
            throw new IllegalArgumentException("Argumento NULO");
        else if(!(repositorio.add(o)))
            throw new IllegalArgumentException();
    }

    @Override
    public void deletar(Servico o) throws IllegalArgumentException {
        if(o == null)
            throw new IllegalArgumentException("Argumento NULO");
        else if(!(repositorio.remove(o)))
            throw new IllegalArgumentException();
    }

    @Override
    public Collection<Servico> ler() {
        return repositorio;
    }
}

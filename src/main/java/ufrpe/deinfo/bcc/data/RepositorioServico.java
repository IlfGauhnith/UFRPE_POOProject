package ufrpe.deinfo.bcc.data;

import ufrpe.deinfo.bcc.model.Servico;

import java.util.*;

public class RepositorioServico implements IRepositorio<Servico> {
    private static RepositorioServico instance;
    private List<Servico> repositorio;

    private RepositorioServico()
    {
        repositorio = new ArrayList<>();
    }

    public static RepositorioServico getInstance() {
        if(instance == null)
            instance = new RepositorioServico();

        return instance;
    }

    public void criar(Servico o) throws IllegalArgumentException {
        if(o == null)
            throw new IllegalArgumentException("Argumento NULO");
        else if(!(repositorio.add(o)))
            throw new IllegalArgumentException();
    }

    public void deletar(Servico o) throws IllegalArgumentException {
        if(o == null)
            throw new IllegalArgumentException("Argumento NULO");
        else if(!(repositorio.remove(o)))
            throw new IllegalArgumentException();
    }

    public List<Servico> ler() {
        return repositorio;
    }

}

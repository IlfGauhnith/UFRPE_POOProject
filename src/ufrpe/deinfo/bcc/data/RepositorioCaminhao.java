package ufrpe.deinfo.bcc.data;

import ufrpe.deinfo.bcc.model.Caminhao;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RepositorioCaminhao implements IRepositorio<Caminhao> {
    private static RepositorioCaminhao instance;
    private Set<Caminhao> repositorio;

    private RepositorioCaminhao() {
        repositorio = new HashSet<Caminhao>();
    }

    public static RepositorioCaminhao getinstance() {
        if(instance == null)
            instance = new RepositorioCaminhao();

        return instance;
    }

    @Override
    public void criar(Caminhao o) throws IllegalArgumentException {
        if(o == null)
            throw new IllegalArgumentException("Argumento NULO");
        else if(!repositorio.add(o))
            throw new IllegalArgumentException();
    }

    @Override
    public void deletar(Caminhao o) throws IllegalArgumentException {
        if(o == null)
            throw new IllegalArgumentException("Argumento NULO");
        else if(!repositorio.remove(o))
            throw new IllegalArgumentException();
    }

    @Override
    public Collection<Caminhao> ler() {
        return repositorio;
    }
}

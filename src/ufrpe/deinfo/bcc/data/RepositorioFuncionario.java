package ufrpe.deinfo.bcc.data;

import ufrpe.deinfo.bcc.model.Funcionario;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RepositorioFuncionario implements IRepositorio<Funcionario> {
    private static RepositorioFuncionario instance;
    private Set<Funcionario> repositorio;

    private RepositorioFuncionario() {
        repositorio = new HashSet<Funcionario>();
    }

    public static RepositorioFuncionario getinstance() {
        if(instance == null)
            instance = new RepositorioFuncionario();

        return instance;
    }


    @Override
    public void criar(Funcionario o) throws IllegalArgumentException {
        if(o == null)
            throw new IllegalArgumentException("Argumento NULO");
        else if(!repositorio.add(o))
            throw new IllegalArgumentException();
    }

    @Override
    public void deletar(Funcionario o) throws IllegalArgumentException {
        if(o == null)
            throw new IllegalArgumentException("Argumento NULO");
        else if(!repositorio.remove(o))
            throw new IllegalArgumentException();
    }

    @Override
    public Collection<Funcionario> ler() {
        return repositorio;
    }
}

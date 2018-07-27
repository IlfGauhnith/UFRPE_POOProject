package ufrpe.deinfo.bcc.data;

import ufrpe.deinfo.bcc.model.Funcionario;

import java.lang.reflect.Array;
import java.util.*;


public class RepositorioFuncionario implements IRepositorio<Funcionario> {
    private static RepositorioFuncionario instance;
    private List<Funcionario> repositorio;
    private PersistenceGSON gson;

    private RepositorioFuncionario() {
        gson = PersistenceGSON.getInstance();
        repositorio = new ArrayList<>();
        startData();
        persist();
    }

    public static RepositorioFuncionario getInstance() {
        if(instance == null)
            instance = new RepositorioFuncionario();

        return instance;
    }


    public void criar(Funcionario o) throws IllegalArgumentException {
        if(o == null)
            throw new IllegalArgumentException("Argumento NULO");
        else if(!repositorio.add(o))
            throw new IllegalArgumentException();
    }

    public void deletar(Funcionario o) throws IllegalArgumentException {
        if(o == null)
            throw new IllegalArgumentException("Argumento NULO");
        else if(!repositorio.remove(o))
            throw new IllegalArgumentException();
    }

    public List<Funcionario> ler() {
        return repositorio;
    }

    public void persist() {
        gson.persist(repositorio, "src/main/files/funcionario.txt");
    }

    @Override
    public void startData() {
        ArrayList<Funcionario> updatedRepo = (ArrayList<Funcionario>) gson.read("src/main/files/funcionario.txt");
        repositorio = updatedRepo;
    }
}

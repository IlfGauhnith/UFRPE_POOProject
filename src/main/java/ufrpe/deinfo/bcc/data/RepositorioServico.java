package ufrpe.deinfo.bcc.data;

import ufrpe.deinfo.bcc.model.Servico;

import java.util.*;

public class RepositorioServico implements IRepositorio<Servico> {
    private static RepositorioServico instance;
    private List<Servico> repositorio;
    private PersistenceGSON gson;

    private RepositorioServico()
    {
        gson = PersistenceGSON.getInstance();
        repositorio = new ArrayList<>();
        startData();
        persist();
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

    public void persist() {
        gson.persist(repositorio, "src/main/files/servico.txt");
    }

    @Override
    public void startData() {
        ArrayList<Servico> updatedRepo = (ArrayList<Servico>) gson.read("src/main/files/servico.txt");
        repositorio = updatedRepo;
    }
}

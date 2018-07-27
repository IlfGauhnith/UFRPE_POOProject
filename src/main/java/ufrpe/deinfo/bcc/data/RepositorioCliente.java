package ufrpe.deinfo.bcc.data;

import ufrpe.deinfo.bcc.model.Cliente;

import java.util.*;

public class RepositorioCliente implements IRepositorio<Cliente> {
    private static RepositorioCliente instance;
    private List<Cliente> repositorio;
    private PersistenceGSON gson;

    private RepositorioCliente() {
        repositorio = new ArrayList<Cliente>();
        gson = PersistenceGSON.getInstance();
        startData();
        persist();
    }

    public static RepositorioCliente getInstance() {
        if(instance == null)
            instance = new RepositorioCliente();
        return instance;
    }


    public void criar(Cliente o) throws IllegalArgumentException{
        if(o == null)
            throw new IllegalArgumentException("Argumento NULO");
        else if(!repositorio.add(o))
            throw new IllegalArgumentException("Cliente já consta no repositorio");
    }

    public void deletar(Cliente o) throws IllegalArgumentException {
        if(o == null)
            throw new IllegalArgumentException("Argumento NULO");
        else if(!repositorio.remove(o))
            throw new IllegalArgumentException();
    }

    public List<Cliente> ler() {
        return repositorio;
    }

    public void persist() {
        gson.persist(repositorio, "src/main/files/cliente.txt");
    }

    @Override
    public void startData() {
        ArrayList<Cliente> updatedRepo = (ArrayList<Cliente>) gson.read("src/main/files/cliente.txt");
        repositorio = updatedRepo;
    }
}

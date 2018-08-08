package ufrpe.deinfo.bcc.data;

import com.google.gson.Gson;
import ufrpe.deinfo.bcc.model.Caminhao;

import java.lang.reflect.Array;
import java.util.*;

public class RepositorioCaminhao implements IRepositorio<Caminhao> {
    private static RepositorioCaminhao instance;
    private List<Caminhao> repositorio;

    private RepositorioCaminhao() {
        repositorio = new ArrayList<Caminhao>();
    }

    public static RepositorioCaminhao getinstance() {
        if(instance == null)
            instance = new RepositorioCaminhao();

        return instance;
    }

    public void criar(Caminhao o) throws IllegalArgumentException {
        if(o == null)
            throw new IllegalArgumentException("Argumento NULO");
        else if(!repositorio.add(o))
            throw new IllegalArgumentException();
    }

    public void deletar(Caminhao o) throws IllegalArgumentException {
        if(o == null)
            throw new IllegalArgumentException("Argumento NULO");
        else if(!repositorio.remove(o))
            throw new IllegalArgumentException();
    }

    public List<Caminhao> ler() {
        return repositorio;

    }
}

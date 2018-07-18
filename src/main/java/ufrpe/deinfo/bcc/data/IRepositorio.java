package ufrpe.deinfo.bcc.data;

import java.util.Collection;

public interface IRepositorio<T> {
    void criar(T o);
    void deletar(T o);
    Collection<T> ler();
    void persist();
    }

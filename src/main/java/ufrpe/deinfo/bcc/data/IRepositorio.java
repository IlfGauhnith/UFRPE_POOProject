package ufrpe.deinfo.bcc.data;

import java.util.Collection;
import java.util.List;

public interface IRepositorio<T> {
    void criar(T o);
    void deletar(T o);
    List<T> ler();
    }

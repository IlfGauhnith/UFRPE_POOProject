package ufrpe.deinfo.bcc.controller;

import ufrpe.deinfo.bcc.data.EstoquePecas;
import ufrpe.deinfo.bcc.model.Peca;

import java.util.List;

public class ControladorPeca {
    private static ControladorPeca instance;
    private EstoquePecas estoque;

    private ControladorPeca() {
        estoque = EstoquePecas.getInstance();
    }

    public static ControladorPeca getInstance() {
        if(instance == null)
            instance = new ControladorPeca();

        return instance;
    }

    public void criar(String ref, String desc, double precoUnit, int qtd) throws IllegalArgumentException {
        if(ref == null)
            throw new IllegalArgumentException("Referência nula");
        else if(desc == null)
            throw new IllegalArgumentException("Descrição nula");
        else if(precoUnit <= 0)
            throw new IllegalArgumentException("Preço unitário não pode ser menor ou igual a 0");
        else if(qtd < 0)
            throw new IllegalArgumentException("Quantidade não pode ser negativa");

        Peca peca = new Peca(ref, desc, precoUnit, qtd);
        estoque.criarPeca(peca);
    }

    public List<Peca> buscarTodasPecas() {
        return estoque.ler();
    }

    public void removerDoEstoque(Peca p, int qtd) {
        p.removerDoEstoque(qtd);
    }
}

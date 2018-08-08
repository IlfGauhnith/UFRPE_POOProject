package ufrpe.deinfo.bcc.data;

import ufrpe.deinfo.bcc.model.Peca;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EstoquePecas {
    private List<Peca> estoquePecas;
    private static EstoquePecas instance;

    private EstoquePecas() {
        estoquePecas = new ArrayList<Peca>();
    }

    public static EstoquePecas getInstance() {
        if(instance == null)
            instance = new EstoquePecas();

        return instance;
    }

    private boolean existeNoEstoque(Peca peca) throws IllegalArgumentException {
        if(estoquePecas.contains(peca)) {
            return true;
        } else if(peca == null) {
            throw new IllegalArgumentException("Argumento NULO");
        }

        return false;
    }

    public void criarPeca(Peca peca) throws IllegalArgumentException {
        if(!estoquePecas.add(peca))
            throw new IllegalArgumentException();
    }

    public void deletarPeca(Peca peca) throws IllegalArgumentException {
        if(!estoquePecas.remove(peca))
            throw new IllegalArgumentException();
    }

    public void adicionarAoEstoque(Peca peca, int qtd) throws IllegalArgumentException {
        if(!(existeNoEstoque(peca))) {
            throw new IllegalArgumentException("Peça não consta no estoque");
        }

        peca.adicionarAoEstoque(qtd);
    }

    public void removerDoEstoque(Peca peca, int qtd) throws IllegalArgumentException {
        if(!(existeNoEstoque(peca))) {
            throw new IllegalArgumentException("Peça não consta no estoque");
        }

        peca.removerDoEstoque(qtd);
    }

    public void alterarPrecoPeca(Peca peca, double preco) throws IllegalArgumentException {
        if(!(existeNoEstoque(peca))) {
            throw new IllegalArgumentException("Peça não consta no estoque");
        }

        peca.setPrecoUnitario(preco);
    }

    public List<Peca> ler() {
        return estoquePecas;
    }
}

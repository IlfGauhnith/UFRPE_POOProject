package ufrpe.deinfo.bcc.model;

import java.util.HashSet;
import java.util.Set;

public class EstoquePecas {
    private Set<Peca> estoquePecas;
    private static EstoquePecas instance;

    private EstoquePecas() {
        estoquePecas = new HashSet<Peca>();
    }

    public static EstoquePecas getInstance() {
        if(instance == null)
            instance = new EstoquePecas();

        return instance;
    }

    public boolean existeNoEstoque(Peca peca) throws IllegalArgumentException {
        if(estoquePecas.contains(peca)) {
            return true;
        } else if(peca == null) {
            throw new IllegalArgumentException("Argumento NULO");
        }

        return false;
    }

    public void criarPeca(Peca peca) throws IllegalArgumentException {
        if(existeNoEstoque(peca)) {
            throw new IllegalArgumentException("Peça ja existente no estoque.");
        }

        estoquePecas.add(peca);
    }

    public void deletarPeca(Peca peca) throws IllegalArgumentException {
        if(!(existeNoEstoque(peca))) {
            throw new IllegalArgumentException("Peça não consta no estoque");
        }

        estoquePecas.remove(peca);
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
}

package ufrpe.deinfo.bcc.model;

public class Peca {
    private String ref;
    private String descricao;
    private double precoUnitario;
    private int quantidade;

    public Peca(String ref, String descricao, double precoUnitario, int quantidade) {
        this.ref = ref;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }

    public String getRef() {
        return ref;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPrecoUnitario(double precoUnitario) throws IllegalArgumentException {
        if(precoUnitario < 0) {
            throw new IllegalArgumentException();
        }

        this.precoUnitario = precoUnitario;
    }

    public void adicionarAoEstoque(int qtd) throws IllegalArgumentException {
        if(qtd < 0) {
            throw new IllegalArgumentException();
        }

        quantidade = quantidade + qtd;
    }

    public void removerDoEstoque(int qtd) throws IllegalArgumentException {
        if(qtd < 0) {
            throw new IllegalArgumentException();
        } else if(quantidade - qtd < 0) {
            throw new IllegalArgumentException("Quantidade solicitada excede o estoque");
        }

        quantidade = quantidade - qtd;
    }
}

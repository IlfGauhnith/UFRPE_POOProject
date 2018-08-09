package ufrpe.deinfo.bcc.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Servico {
    private LocalDate dataEntrada;
    private LocalDate dataSaidaEstimada;
    private LocalDate dataSaidaTecnica;
    private long kilometragem;
    private String descricaoServico;
    private List<Peca> relacaoPecas;
    private Caminhao caminhao;
    private double custoTotal = 0;
    private Cliente cliente;
    private Funcionario mecanicoResponsavel;

    public Servico(LocalDate dataEntrada, LocalDate dataSaidaEstimada, long kilometragem,
                   String descricaoServico, Caminhao caminhao, Cliente cliente,
                   Funcionario mecanicoResponsavel) {
        this.dataEntrada = dataEntrada;
        this.dataSaidaEstimada = dataSaidaEstimada;
        this.kilometragem = kilometragem;
        this.descricaoServico = descricaoServico;
        this.caminhao = caminhao;
        this.cliente = cliente;
        this.mecanicoResponsavel = mecanicoResponsavel;
        relacaoPecas = new ArrayList<Peca>();
    }

    public Servico(LocalDate dataSaidaEstimada, long kilometragem, String descricaoServico,
                   Caminhao caminhao, Cliente cliente, Funcionario mecanicoResponsavel) {
        this.dataEntrada = LocalDate.now();
        this.dataSaidaEstimada = dataSaidaEstimada;
        this.kilometragem = kilometragem;
        this.descricaoServico = descricaoServico;
        this.caminhao = caminhao;
        this.cliente = cliente;
        this.mecanicoResponsavel = mecanicoResponsavel;
        relacaoPecas = new ArrayList<Peca>();
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataSaidaEstimada() {
        return dataSaidaEstimada;
    }

    public LocalDate getDataSaidaTecnica() {
        return dataSaidaTecnica;
    }

    public long getKilometragem() {
        return kilometragem;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public List<Peca> getRelacaoPecas() {
        return relacaoPecas;
    }

    public Caminhao getCaminhao() {
        return caminhao;
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Funcionario getMecanicoResponsavel() {
        return mecanicoResponsavel;
    }

    public void setDataSaidaEstimada(LocalDate dataSaidaEstimada) {
        this.dataSaidaEstimada = dataSaidaEstimada;
    }

    public void setDataSaidaTecnica(LocalDate dataSaidaTecnica) {
        this.dataSaidaTecnica = dataSaidaTecnica;
    }

    public void setKilometragem(long kilometragem) {
        this.kilometragem = kilometragem;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public void setCaminhao(Caminhao caminhao) {
        this.caminhao = caminhao;
    }

    public void setCustoTotal(double custoTotal) {
        this.custoTotal = custoTotal;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setMecanicoResponsavel(Funcionario mecanicoResponsavel) {
        this.mecanicoResponsavel = mecanicoResponsavel;
    }

    public void adicionarPecas(List<Peca> pecas) {
        relacaoPecas.addAll(pecas);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Servico)) return false;

        Servico servico = (Servico) o;

        if (getKilometragem() != servico.getKilometragem()) return false;
        if (!getDataEntrada().equals(servico.getDataEntrada())) return false;
        if (!getCaminhao().equals(servico.getCaminhao())) return false;
        if (!getCliente().equals(servico.getCliente())) return false;
        return getMecanicoResponsavel().equals(servico.getMecanicoResponsavel());
    }

    @Override
    public int hashCode() {
        int result = getDataEntrada().hashCode();
        result = 31 * result + (int) (getKilometragem() ^ (getKilometragem() >>> 32));
        result = 31 * result + getCaminhao().hashCode();
        result = 31 * result + getCliente().hashCode();
        result = 31 * result + getMecanicoResponsavel().hashCode();
        return result;
    }

    public void adicionarPeca(Peca peca) {
        relacaoPecas.add(peca);
    }

    public void adicionarCusto(double custo) {
        custoTotal = custoTotal + custo;
    }
}

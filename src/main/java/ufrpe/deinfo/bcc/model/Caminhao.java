package ufrpe.deinfo.bcc.model;

import java.time.LocalDate;

public class Caminhao {
    private String chassi;
    private String placa;
    private String modelo;
    private int ano;
    private String fabricante;
    private LocalDate ultimaManutencao;
    private boolean emServico = false;
    private Cliente dono;
    private long kilometragem;

    public Caminhao(String chassi, String placa, String modelo, int ano, String fabricante,
                    Cliente dono, long kilometragem) throws IllegalArgumentException {
        this.chassi = chassi;
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
        this.fabricante = fabricante;
        this.dono = dono;
        this.kilometragem = kilometragem;
    }

    public Caminhao(String chassi, String placa, String modelo, int ano, String fabricante,
                    LocalDate ultimaManutencao, Cliente dono, long kilometragem) {
        this.chassi = chassi;
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
        this.fabricante = fabricante;
        this.ultimaManutencao = ultimaManutencao;
        this.dono = dono;
        this.kilometragem = kilometragem;
    }

    public Caminhao(String chassi, String placa) throws IllegalArgumentException {
        if(chassi == null || placa == null)
            throw new IllegalArgumentException();
        this.chassi = chassi;
        this.placa = placa;
    }

    public Caminhao(String chassi) {
        this.chassi = chassi;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public LocalDate getUltimaManutencao() {
        return ultimaManutencao;
    }

    public void setUltimaManutencao(LocalDate ultimaManutencao) {
        this.ultimaManutencao = ultimaManutencao;
    }

    public boolean isEmServico() {
        return emServico;
    }

    public void setEmServico(boolean emServico) {
        this.emServico = emServico;
    }

    public Cliente getDono() {
        return dono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Caminhao)) return false;

        Caminhao caminhao = (Caminhao) o;

        if (!getChassi().equals(caminhao.getChassi())) return false;
        return getPlaca().equals(caminhao.getPlaca());
    }

    @Override
    public int hashCode() {
        int result = getChassi().hashCode();
        result = 31 * result + getPlaca().hashCode();
        return result;
    }
}

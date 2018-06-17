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

    public Caminhao(String chassi, String placa, String modelo, int ano, String fabricante) {
        this.chassi = chassi;
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
        this.fabricante = fabricante;
    }
}

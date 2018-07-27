package ufrpe.deinfo.bcc.model;

public class Endereco {
    private String pais;
    private String uf;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;

    public Endereco(String pais, String uf, String cidade, String bairro, String logradouro, String numero, String complemento,
                    String cep) {
        this.pais = pais;
        this.uf = uf;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
    }

    public Endereco(String cep) {
        this.cep = cep;
    }

    //Faz sentido utilizar exceptions para botar em prática de fato o encapsulamento?

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) throws IllegalArgumentException {
        if(pais == null)
            throw new IllegalArgumentException();
        this.pais = pais;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) throws IllegalArgumentException {
        if(uf == null || uf.length() > 2)
            throw new IllegalArgumentException();
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) throws IllegalArgumentException {
        if(cidade == null)
            throw new IllegalArgumentException();
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) throws IllegalArgumentException {
        if(bairro == null)
            throw new IllegalArgumentException();
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) throws IllegalArgumentException {
        if(logradouro == null)
            throw new IllegalArgumentException();
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) throws IllegalArgumentException {
        if(numero == null || !numero.matches("[0-9]+"))
            throw new IllegalArgumentException();
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) throws IllegalArgumentException {
        if(complemento == null)
            throw new IllegalArgumentException();
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) throws IllegalArgumentException {
        if(!cep.matches("[0-9]+"))
            throw new IllegalArgumentException();

        this.cep = cep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endereco)) return false;

        Endereco endereco = (Endereco) o;

        return getCep().equals(endereco.getCep());
    }

    @Override
    public int hashCode() {
        return getCep().hashCode();
    }
}

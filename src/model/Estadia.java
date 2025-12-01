package model;

public class Estadia {

    private int idEstadia;
    private int qtdPessoas;
    private String dataChegada;
    private String dataSaida;
    
    public Estadia(){}
    
    public Estadia(int idEstadia, int qtdPessoas, String dataChegada, String dataSaida) {
        this.idEstadia = idEstadia;
        this.qtdPessoas = qtdPessoas;
        this.dataChegada = dataChegada;
        this.dataSaida = dataSaida;
    }
    
    public int getIdEstadia() { return idEstadia; }
    public void setIdEstadia(int idEstadia) { this.idEstadia = idEstadia; }

    public int getQtdPessoas() { return qtdPessoas; }
    public void setQtdPessoas(int qtdPessoas) { this.qtdPessoas = qtdPessoas; }

    public String getDataChegada() { return dataChegada; }
    public void setDataChegada(String dataChegada) { this.dataChegada = dataChegada; }

    public String getDataSaida() { return dataSaida; }
    public void setDataSaida(String dataSaida) { this.dataSaida = dataSaida; }

    @Override
    public String toString() {
        return idEstadia + " - " + dataChegada + " -> " + dataSaida + " (" + qtdPessoas + " pessoas)";
    }    
}

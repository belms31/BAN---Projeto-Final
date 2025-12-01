package model;

public class Reserva {
    
    private String cpf;
    private int idEstadia;
    private String dataReserva;
    
    public Reserva(){}
    
    public Reserva(String cpf, int idEstadia, String dataReserva) {
        this.cpf = cpf;
        this.idEstadia = idEstadia;
        this.dataReserva = dataReserva;
    }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public int getIdEstadia() { return idEstadia; }
    public void setIdEstadia(int idEstadia) { this.idEstadia = idEstadia; }

    public String getDataReserva() { return dataReserva; }
    public void setDataReserva(String dataReserva) { this.dataReserva = dataReserva; }

    @Override
    public String toString() {
        return cpf + " - estadia " + idEstadia + " (reserva: " + dataReserva + ")";
    }
}

package model;

public class Quarto {
    
    private int numero;
    private int andar;
    private int numCamas;

    public Quarto() {}

    /**
     *
     * @param numero
     * @param andar
     * @param numCamas
     */
    public Quarto(int numero, int andar, int numCamas) {
        this.numero = numero;
        this.andar = andar;
        this.numCamas = numCamas;
    }
    
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public int getAndar() { return andar; }
    public void setAndar(int andar) { this.andar = andar; }

    public int getNumCamas() { return numCamas; }
    public void setNumCamas(int numCamas) { this.numCamas = numCamas; }

    @Override
    public String toString() {
        return "Quarto " + numero + " (andar " + andar + ", camas: " + numCamas + ")";
    }       
}

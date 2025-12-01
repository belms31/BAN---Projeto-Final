package model;

public class Hospede {
    private String cpf;
    private String telefone;
    private String nome;
    private String rua;
    private String bairro;
    private String cidade;
    
    public Hospede(){}
    public Hospede(String cpf, String nome, String telefone, String rua, String bairro, String cidade){
        this.cpf = cpf; 
        this.nome = nome; 
        this.telefone = telefone;
        this.rua = rua; 
        this.bairro = bairro; 
        this.cidade = cidade;
    }
    
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getRua() { return rua; }
    public void setRua(String rua) { this.rua = rua; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    @Override
    public String toString() {
        return cpf + " - " + nome + " - " + telefone + " - " + cidade;
    }
}

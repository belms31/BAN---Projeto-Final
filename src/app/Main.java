package app;

import dao.*;
import java.util.List;
import model.*;
import java.util.Scanner;


public class Main {
    
    private static final Scanner sc = new Scanner (System.in);
    
    private static final FuncionarioDAO funcDAO = new FuncionarioDAO();
    private static final HospedeDAO hospDAO = new HospedeDAO();
    private static final QuartoDAO quartoDAO = new QuartoDAO();
    private static final EstadiaDAO estadiaDAO = new EstadiaDAO();
    private static final ReservaDAO reservaDAO = new ReservaDAO();
    
    public static void main (String[] args){
        
        int op;
        do {
            op = menuPrincipal();
            try {
                switch (op){
                    case 1 -> menuFuncionarios();
                    case 2 -> menuHospedes();
                    case 3 -> menuQuartos();
                    case 4 -> menuEstadias();
                    case 5 -> menuReservas();
                    case 6 -> menuConsultasEspeciais();
                    case 0 -> System.out.println ("Saindo...");
                    default ->{
                        System.out.println("Opção Inválida");
                        aguardar();
                    }
                }
            }   catch (Exception e){
                    System.out.println("Opção Inválida");
                    aguardar();
                }
        } while (op != 0);
        System.out.println("Sistema encerrado");
    }
    
    private static int menuPrincipal(){
        System.out.println("\n=========================");
        System.out.println("     SISTEMA DE HOTEL      ");
        System.out.println("=========================");
        System.out.println("1 - Gerenciar Funcionarios");
        System.out.println("2 - Gerenciar Hospedes");
        System.out.println("3 - Gerenciar Quartos");
        System.out.println("4 - Gerenciar Estadias");
        System.out.println("5 - Gerenciar Reservas");
        System.out.println("6 - Consultas especiais");
        System.out.println("0 - Sair");
        System.out.println("=========================");
        return readInt("Opçao: ");
    }
    
    private static void menuFuncionarios(){
        System.out.println("\n=== Funcionarios ===");
        System.out.println("1 - Inserir");
        System.out.println("2 - Remover");
        System.out.println("3 - Listar");
        System.out.println("0 - Voltar");
        int op = readInt("Opçao: ");
        
        switch (op) {
            case 1 -> inserirFuncionario();
            case 2 -> removerFuncionario();
            case 3 -> listarFuncionario();
        }
        aguardar();
    }
    
    private static void menuHospedes() {
        System.out.println("\n=== Hóspedes ===");
        System.out.println("1 - Inserir");
        System.out.println("2 - Remover");
        System.out.println("3 - Listar");
        System.out.println("0 - Voltar");

        int op = readInt("Opção: ");

        switch (op) {
            case 1 -> inserirHospede();
            case 2 -> removerHospede();
            case 3 -> listarHospedes();
        }
        aguardar();
    }

    private static void menuQuartos() {
        System.out.println("\n=== Quartos ===");
        System.out.println("1 - Inserir");
        System.out.println("2 - Remover");
        System.out.println("3 - Listar");
        System.out.println("0 - Voltar");

        int op = readInt("Opção: ");

        switch (op) {
            case 1 -> inserirQuarto();
            case 2 -> removerQuarto();
            case 3 -> listarQuartos();
        }
        aguardar();
    }

    private static void menuEstadias() {
        System.out.println("\n=== Estadias ===");
        System.out.println("1 - Inserir");
        System.out.println("2 - Remover");
        System.out.println("3 - Listar");
        System.out.println("0 - Voltar");

        int op = readInt("Opção: ");

        switch (op) {
            case 1 -> inserirEstadia();
            case 2 -> removerEstadia();
            case 3 -> listarEstadias();
        }
        aguardar();
    }
    
    private static void menuReservas() {
        System.out.println("\n=== Reservas ===");
        System.out.println("1 - Inserir");
        System.out.println("2 - Remover");
        System.out.println("3 - Listar");
        System.out.println("0 - Voltar");

        int op = readInt("Opção: ");

        switch (op) {
            case 1 -> inserirReserva();
            case 2 -> removerReserva();
            case 3 -> listarReservas();
        }
        aguardar();
    }
    
    private static void menuConsultasEspeciais() {
        System.out.println("\n=== Consultas Especiais ===");
        System.out.println("1 - Listar Reservas com Nome (JOIN)");
        System.out.println("2 - Hóspedes com Reservas acima da média");
        System.out.println("0 - Voltar");

        int op = readInt("Opção: ");

        switch (op) {
            case 1 -> listarReservasComNome();
            case 2 -> hospedesAcimaMedia();
        }
        aguardar();
    }
    
    private static void aguardar() {
        System.out.print("\nPressione ENTER para continuar...");
        sc.nextLine();
    }
    
    private static int readInt(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Número inválido. " + prompt);
        }
        int n = sc.nextInt();
        sc.nextLine();
        return n;
    }
    
    private static String readString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }
    
    private static void inserirFuncionario() {
        System.out.println("\nInserir funcionário:");
        int id = readInt("id_func: ");
        String nome = readString("nome: ");
        String turno = readString("turno: ");

        if (funcDAO.insert(new Funcionario(id, nome, turno)))
            System.out.println("Funcionário inserido.");
        else
            System.out.println("Erro ao inserir.");
    }
    
    private static void removerFuncionario() {
        int id = readInt("id_func: ");
        if (funcDAO.delete(id)) System.out.println("Removido.");
        else System.out.println("Erro ao remover.");
    }

    private static void listarFuncionario() {
    List<Funcionario> lista = funcDAO.listAll();
    System.out.println("\nFuncionários:");
    lista.forEach(System.out::println);
}

    
    private static void inserirHospede() {
        System.out.println("\nInserir hóspede:");
        String cpf = readString("CPF: ");
        String tel = readString("Telefone: ");
        String nome = readString("Nome: ");
        String rua = readString("Rua: ");
        String bairro = readString("Bairro: ");
        String cidade = readString("Cidade: ");

        if (hospDAO.insert(new Hospede(cpf, tel, nome, rua, bairro, cidade)))
            System.out.println("Hóspede inserido.");
        else
            System.out.println("Erro ao inserir hóspede.");
    }

    private static void removerHospede() {
        String cpf = readString("CPF a remover: ");
        if (hospDAO.delete(cpf)) System.out.println("Removido.");
        else System.out.println("Erro ao remover.");
    }

    private static void listarHospedes() {
        System.out.println("\nHóspedes:");
        hospDAO.listAll().forEach(System.out::println);
    }
    
    private static void inserirQuarto() {
        System.out.println("\nInserir quarto:");
        int numero = readInt("Número: ");
        int andar = readInt("Andar: ");
        int camas = readInt("Camas: ");

        if (quartoDAO.insert(new Quarto(numero, andar, camas)))
            System.out.println("Quarto inserido.");
        else
            System.out.println("Erro ao inserir.");
    }

    private static void removerQuarto() {
        int numero = readInt("Número do quarto: ");
        if (quartoDAO.delete(numero)) System.out.println("Removido.");
        else System.out.println("Erro ao remover.");
    }

    private static void listarQuartos() {
        System.out.println("\nQuartos:");
        quartoDAO.listAll().forEach(System.out::println);
    }
    
    private static void inserirEstadia() {
        System.out.println("\nInserir estadia:");
        int id = readInt("id_estadia: ");
        int qtd = readInt("Qtd pessoas: ");
        String chegada = readString("Data chegada: ");
        String saida = readString("Data saída: ");

        if (estadiaDAO.insert(new Estadia(id, qtd, chegada, saida)))
            System.out.println("Estadia inserida.");
        else
            System.out.println("Erro ao inserir.");
    }

    private static void removerEstadia() {
        int id = readInt("ID para remover: ");
        if (estadiaDAO.delete(id)) System.out.println("Removido.");
        else System.out.println("Erro ao remover.");
    }

    private static void listarEstadias() {
        System.out.println("\nEstadias:");
        estadiaDAO.listAll().forEach(System.out::println);
    }
    
    private static void inserirReserva() {
        System.out.println("\nInserir reserva:");
        String cpf = readString("CPF: ");
        int id = readInt("id_estadia: ");
        String data = readString("Data reserva: ");

        if (reservaDAO.insert(new Reserva(cpf, id, data)))
            System.out.println("Reserva inserida.");
        else
            System.out.println("Erro ao inserir.");
    }

    private static void removerReserva() {
        String cpf = readString("CPF: ");
        int id = readInt("id_estadia: ");

        if (reservaDAO.delete(cpf, id))
            System.out.println("Reserva removida.");
        else
            System.out.println("Erro ao remover.");
    }

    private static void listarReservas() {
        System.out.println("\nReservas:");
        reservaDAO.listAll().forEach(System.out::println);
    }

    private static void listarReservasComNome() {
        System.out.println("\nReservas (JOIN):");
        reservaDAO.listarReservasComNomeHospede().forEach(System.out::println);
    }

    private static void hospedesAcimaMedia() {
        System.out.println("\nHóspedes acima da média:");
        estadiaDAO.hospedesComMaisDiasQueMedia().forEach(System.out::println);
    }

}

   

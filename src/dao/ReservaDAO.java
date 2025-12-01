/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.Conexao;
import model.Reserva;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mari
 */
public class ReservaDAO {
    
    public boolean insert(Reserva r) {
        String sql = "INSERT INTO public.reserva (cpf, id_estadia, data_reserva) VALUES (?, ?, ?)";
        try (Connection c = Conexao.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, r.getCpf());
            ps.setInt(2, r.getIdEstadia());
            ps.setString(3, r.getDataReserva());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir reserva: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(String cpf, int idEstadia) {
        String sql = "DELETE FROM public.reserva WHERE cpf = ? AND id_estadia = ?";
        try (Connection c = Conexao.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, cpf);
            ps.setInt(2, idEstadia);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao deletar reserva: " + e.getMessage());
            return false;
        }
    }

    public List<Reserva> listAll() {
        List<Reserva> list = new ArrayList<>();
        String sql = "SELECT cpf, id_estadia, data_reserva FROM public.reserva ORDER BY data_reserva";
        try (Connection c = Conexao.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Reserva r = new Reserva(rs.getString("cpf"), rs.getInt("id_estadia"), rs.getString("data_reserva"));
                list.add(r);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar reservas: " + e.getMessage());
        }
        return list;
    }
    
    //consulta com o JOIN entre reserva e hospede para mostrar 
    //o nome do hospede
    
    public List<String> listarReservasComNomeHospede() {
        List<String> result = new ArrayList<>();
        String sql = "SELECT r.id_estadia, r.data_reserva, h.nome "
                   + "FROM public.reserva r "
                   + "JOIN public.hospede h ON r.cpf = h.cpf "
                   + "ORDER BY r.data_reserva";
        try (Connection c = Conexao.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int idEstadia = rs.getInt("id_estadia");
                String data = rs.getString("data_reserva");
                String nome = rs.getString("nome");
                result.add("Estadia " + idEstadia + " - " + data + " - Hóspede: " + nome);
            }
        } catch (SQLException e) {
            System.err.println("Erro na consulta JOIN: " + e.getMessage());
        }
        return result;
    }
}
    


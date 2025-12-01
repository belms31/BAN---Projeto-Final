package dao;

import connection.Conexao;
import model.Hospede;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
        
public class HospedeDAO {
    
    public boolean insert(Hospede h) {
        String sql = "INSERT INTO public.hospede (cpf, telefone, nome, rua, bairro, cidade) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection c = Conexao.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, h.getCpf());
            ps.setString(2, h.getTelefone());
            ps.setString(3, h.getNome());
            ps.setString(4, h.getRua());
            ps.setString(5, h.getBairro());
            ps.setString(6, h.getCidade());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir hóspede: " + e.getMessage());
            return false;
        }
    }
    
    public boolean delete(String cpf) {
        String sql = "DELETE FROM public.hospede WHERE cpf = ?";
        try (Connection c = Conexao.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, cpf);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao deletar hóspede: " + e.getMessage());
            return false;
        }
    }
    
    public List<Hospede> listAll() {
        List<Hospede> list = new ArrayList<>();
        String sql = "SELECT cpf, telefone, nome, rua, bairro, cidade FROM public.hospede ORDER BY nome";
        try (Connection c = Conexao.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Hospede h = new Hospede(rs.getString("cpf"), rs.getString("telefone"),
                        rs.getString("nome"), rs.getString("rua"),
                        rs.getString("bairro"), rs.getString("cidade"));
                list.add(h);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar hóspedes: " + e.getMessage());
        }
        return list;
    }
}

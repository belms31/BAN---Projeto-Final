package dao;

import connection.Conexao;
import model.Quarto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuartoDAO {
    
    public boolean insert(Quarto q) {
        String sql = "INSERT INTO public.quarto (numero, andar, num_camas) VALUES (?, ?, ?)";
        try (Connection c = Conexao.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, q.getNumero());
            ps.setInt(2, q.getAndar());
            ps.setInt(3, q.getNumCamas());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir quarto: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int numero) {
        String sql = "DELETE FROM public.quarto WHERE numero = ?";
        try (Connection c = Conexao.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, numero);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao deletar quarto: " + e.getMessage());
            return false;
        }
    }

    public List<Quarto> listAll() {
        List<Quarto> list = new ArrayList<>();
        String sql = "SELECT numero, andar, num_camas FROM public.quarto ORDER BY numero";
        try (Connection c = Conexao.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Quarto q = new Quarto(rs.getInt("numero"),
                        rs.getInt("andar"), 
                        rs.getInt("num_camas"));
                list.add(q);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar quartos: " + e.getMessage());
        }
        return list;
    }
}

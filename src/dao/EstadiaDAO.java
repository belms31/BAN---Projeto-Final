package dao;

import connection.Conexao;
import model.Estadia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstadiaDAO {
    
    public boolean insert(Estadia e) {
        String sql = "INSERT INTO public.estadia (id_estadia, qtd_pessoas, data_chegada, data_saida) VALUES (?, ?, ?, ?)";
        try (Connection c = Conexao.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, e.getIdEstadia());
            ps.setInt(2, e.getQtdPessoas());
            ps.setString(3, e.getDataChegada());
            ps.setString(4, e.getDataSaida());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir estadia: " + ex.getMessage());
            return false;
        }
    }

    public boolean delete(int idEstadia) {
        String sql = "DELETE FROM public.estadia WHERE id_estadia = ?";
        try (Connection c = Conexao.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, idEstadia);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao deletar estadia: " + e.getMessage());
            return false;
        }
    }

    public List<Estadia> listAll() {
        List<Estadia> list = new ArrayList<>();
        String sql = "SELECT id_estadia, qtd_pessoas, data_chegada, data_saida FROM public.estadia ORDER BY id_estadia";
        try (Connection c = Conexao.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Estadia e = new Estadia(rs.getInt("id_estadia"), rs.getInt("qtd_pessoas"),
                        rs.getString("data_chegada"), rs.getString("data_saida"));
                list.add(e);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar estadias: " + e.getMessage());
        }
        return list;
    }
    
    public List<String> hospedesComMaisDiasQueMedia() {
    List<String> result = new ArrayList<>();

    String sql =
        "SELECT h.nome, SUM(e.data_saida::date - e.data_chegada::date) AS total_dias " +
        "FROM public.estadia e " +
        "JOIN public.reserva r ON r.id_estadia = e.id_estadia " +
        "JOIN public.hospede h ON h.cpf = r.cpf " +
        "GROUP BY h.nome " +
        "HAVING SUM(e.data_saida::date - e.data_chegada::date) > ( " +
        "    SELECT AVG(total_por_hospede) FROM ( " +
        "        SELECT SUM(e2.data_saida::date - e2.data_chegada::date) AS total_por_hospede " +
        "        FROM public.estadia e2 " +
        "        JOIN public.reserva r2 ON r2.id_estadia = e2.id_estadia " +
        "        GROUP BY r2.cpf " +
        "    ) sub " +
        ");";

    try (Connection c = Conexao.getConnection();
         PreparedStatement ps = c.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            String nome = rs.getString("nome");
            int totalDias = rs.getInt("total_dias");
            result.add(nome + " — " + totalDias + " dias no total");
        }

    } catch (SQLException e) {
        System.err.println("Erro na consulta de hóspedes acima da média: " + e.getMessage());
    }

    return result;
    }
}

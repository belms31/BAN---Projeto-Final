/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.Conexao;
import model.Funcionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mari
 */
public class FuncionarioDAO {
    
    public boolean insert(Funcionario f) {
        String sql = "INSERT INTO public.funcionarios (id_func, nome, turno) VALUES (?, ?, ?)";
        try (Connection c = Conexao.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, f.getIdFunc());
            ps.setString(2, f.getNome());
            ps.setString(3, f.getTurno());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir funcionário: " + e.getMessage());
            return false;
        }
    }
    
    public boolean delete(int id) {
        String sql = "DELETE FROM public.funcionarios WHERE id_func = ?";
        try (Connection c = Conexao.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao deletar funcionário: " + e.getMessage());
            return false;
        }
    }
    
    public List<Funcionario> listAll() {
        List<Funcionario> list = new ArrayList<>();
        String sql = "SELECT id_func, nome, turno FROM public.funcionarios ORDER BY id_func";
        try (Connection c = Conexao.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Funcionario f = new Funcionario(rs.getInt("id_func"), rs.getString("nome"), rs.getString("turno"));
                list.add(f);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar funcionários: " + e.getMessage());
        }
        return list;
    }
}

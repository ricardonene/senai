package DAO;

import entity.Tarefa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ricardonene
 */
public class TarefaDAO {

    private boolean insert(Tarefa tarefa) {
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement ps
                    = conn.prepareStatement("INSERT INTO tarefa "
                            + "(descrição, prazo, concluido )"
                            + "VALUES ( ?, ? , ?  )");
            ps.setString(1, tarefa.getDescricao());
            ps.setBoolean(2, tarefa.isConcluido());
            ps.setDate(3, (Date) tarefa.getPrazo());

            ps.execute();
            ps.close();
            conn.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private boolean update(Tarefa tarefa) {
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement ps
                    = conn.prepareStatement("UPDATE tarefa "
                            + "SET descrição = ?, prazo = ?, concluido = ?"
                            + " WHERE idtarefa = ?");
            ps.setString(1, tarefa.getDescricao());
            ps.setBoolean(2, tarefa.isConcluido());
            ps.setDate(3, (Date) tarefa.getPrazo());

            ps.execute();

            ps.close();
            conn.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement ps
                    = conn.prepareStatement("DELETE FROM tarefa "
                            + "WHERE idtarefa = ?");
            ps.setInt(1, id);

            ps.execute();

            ps.close();
            conn.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public List<Tarefa> listarTodos() {
        List<Tarefa> lista = new ArrayList<Tarefa>();
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement ps
                    = conn.prepareStatement("SELECT * From tarefa");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Tarefa tarefa = new Tarefa();
                tarefa.setIdTarefa(rs.getInt("idtarefa"));
                tarefa.setConcluido(rs.getBoolean("concluido"));
                tarefa.setDescricao(rs.getString("descrição"));
                tarefa.setPrazo(rs.getDate("prazo"));

                lista.add(tarefa);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

}

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

    public boolean salvar(Tarefa tarefa) {

        if (tarefa.getIdTarefa() == null) {
            return insert(tarefa);
        } else {
            return update(tarefa);
        }

    }

    private boolean insert(Tarefa tarefa) {
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement ps
                    = conn.prepareStatement("INSERT INTO tarefa "
                            + "(descricao, prazo, concluido )"
                            + "VALUES ( ?, ? , ?  )");
            ps.setString(1, tarefa.getDescricao());
            ps.setDate(2, new Date(tarefa.getPrazo().getTime()));
            ps.setBoolean(3, tarefa.isConcluido());

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
                            + "SET descricao = ?, prazo = ?, concluido = ?"
                            + " WHERE idtarefa = ?");
            
            ps.setString(1, tarefa.getDescricao());
            ps.setDate(2, new java.sql.Date(tarefa.getPrazo().getTime()));
            ps.setBoolean(3, tarefa.isConcluido());
            ps.setInt(4, tarefa.getIdTarefa());
            ps.execute();

            ps.close();
            conn.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

   
    public boolean delete(Tarefa tarefa) {
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement ps
                    = conn.prepareStatement("DELETE FROM tarefa "
                            + "WHERE idtarefa = ?");
            ps.setInt(1, tarefa.getIdTarefa());

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
                tarefa.setDescricao(rs.getString("descricao"));
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

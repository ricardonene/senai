package DAO;

import entity.Lista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author ricardonene
 */
public class ListaDAO {

    public boolean salvar(Lista lista) {

        if (lista.getIdLista() == null) {
            return insert(lista);
        } else {
            return update(lista);
        }

    }

    private boolean insert(Lista lista) {
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement ps
                    = conn.prepareStatement("INSERT INTO lista "
                            + "(nome )"
                            + "VALUES ( ?  )");
            ps.setString(1, lista.getNome());

            ps.execute();
            ps.close();
            conn.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private boolean update(Lista lista) {
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement ps
                    = conn.prepareStatement("UPDATE lista "
                            + "SET nome = ?"
                            + " WHERE idlista = ?");

            ps.setString(1, lista.getNome());

            ps.setInt(2, lista.getIdLista());
            ps.execute();

            ps.close();
            conn.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean delete(Lista lista) {
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement ps
                    = conn.prepareStatement("DELETE FROM lista "
                            + "WHERE idlista = ?");
            ps.setInt(1, lista.getIdLista());

            ps.execute();

            ps.close();
            conn.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public List<Lista> listarTodos() {
        List<Lista> lista = new ArrayList<Lista>();
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement ps
                    = conn.prepareStatement("SELECT * From lista ORDER BY nome");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Lista ListadeTabelas = new Lista();
                ListadeTabelas.setIdLista(rs.getInt("idlista"));

                ListadeTabelas.setNome(rs.getString("nome"));

                lista.add(ListadeTabelas);
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

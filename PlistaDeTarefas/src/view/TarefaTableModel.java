package view;

import entity.Tarefa;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TarefaTableModel extends AbstractTableModel {

    List<Tarefa> lista;

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tarefa t = lista.get(rowIndex);
        if (columnIndex == 0) {
            return t.getDescricao();
        } else if (columnIndex == 1) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
            return formatter.format(t.getPrazo());
        } else if (columnIndex == 2) {
            return t.isConcluido();
        } else {
            return "";
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "";
        } else if (columnIndex == 1) {
            return "";
        } else if (columnIndex == 2) {
            return "";
        } else {
            return "";
        }
    }

    public List<Tarefa> getLista() {
        return lista;
    }

    public void setLista(List<Tarefa> lista) {
        this.lista = lista;
    }

}

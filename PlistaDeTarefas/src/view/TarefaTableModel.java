package view;

import entity.Tarefa;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TarefaTableModel extends AbstractTableModel {

    List<Tarefa> lista = new ArrayList<>();

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
            return t.isConcluido()? "Sim" : "Não";
        } else {
            return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Descrição";
        } else if (column == 1) {
            return "Prazo";
        } else if (column == 2) {
            return "Concluido";
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

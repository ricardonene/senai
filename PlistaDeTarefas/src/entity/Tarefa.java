package entity;

import java.util.Date;

public class Tarefa {

    private int idTarefa;
    private String descricao;
    private Date prazo;
    private boolean concluido;

    @Override
    public String toString() {
        return "idTarefa=" + idTarefa + ", descricao=" + descricao + ", prazo=" + prazo + ", concluido=" + concluido;
    }

    public int getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(int idTarefa) {
        this.idTarefa = idTarefa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

}

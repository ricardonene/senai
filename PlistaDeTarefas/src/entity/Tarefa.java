package entity;

import java.util.Date;

public class Tarefa {

    private Integer idTarefa;
    private String descricao;
    private Date prazo;
    private boolean concluido;

    @Override
    public String toString() {
        return "idTarefa=" + idTarefa + ", descricao=" + descricao + ", prazo=" + prazo + ", concluido=" + concluido;
    }

    public Integer getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(Integer idTarefa) {
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

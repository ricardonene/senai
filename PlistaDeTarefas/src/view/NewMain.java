/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.TarefaDAO;
import entity.Tarefa;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.DefaultListModel;

public class NewMain {

    public static void main(String[] args) throws Exception {
        TarefaDAO tarefadao = new TarefaDAO();

//        List<Tarefa> listatarefa = tarefadao.listarTodos();
//        for (Tarefa convidado : listatarefa) {
//            System.out.println(convidado);
//
//        }
//        
//      
//        Calendar c = new GregorianCalendar();
//        c.set(2016, 1, 1, 23, 59, 59);
//        Date d = c.getTime();
//        System.out.println(d);
//        Calendar c1 = new GregorianCalendar();
//        c1.set(2015, 1, 1);
//
//        Date agora = new Date();
//
//        Calendar c2 = new GregorianCalendar();
//        c2.setTime(d);
//        c2.set(Calendar.HOUR_OF_DAY, 23);
//        c2.set(Calendar.MINUTE, 59);
//        c2.set(Calendar.SECOND, 59);
//        
//        System.out.println(c2.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Date date = formatter.parse("28/5/2016");
        // System.out.println(date);
        Calendar c2 = new GregorianCalendar();
        c2.setTime(date);
        c2.set(Calendar.HOUR_OF_DAY, 23);
        c2.set(Calendar.MINUTE, 59);
        c2.set(Calendar.SECOND, 59);
        System.out.println(c2.getTime());
        Date agora = new Date();
        Date dataUsuario = c2.getTime();

        Calendar c3 = new GregorianCalendar();
        c3.setTime(dataUsuario);

        Calendar calendarAgora = new GregorianCalendar();
        calendarAgora.setTime(agora);
        System.out.println(c3.after(calendarAgora));
        //  System.out.println(agora);

//        String a = "20120401";
//        String b = "20120331";
//        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//        Date data1 = new Date(format.parse(a).getTime());
//        Date data2 = new Date(format.parse(b).getTime());
//        if (data1.after(data2)) {
//            System.out.println("Data: " + a + " é posterior à " + b);
//        } else if (data1.before(data2)) {
//            System.out.println("Data: " + a + " é inferior à " + b);
//        } else {
//            System.out.println("Data: " + a + " é igual à " + b);
//        }
    }

}

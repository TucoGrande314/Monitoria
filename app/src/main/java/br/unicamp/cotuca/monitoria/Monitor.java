package br.unicamp.cotuca.monitoria;

import java.util.LinkedList;

/**
 * Created by u16167 on 16/05/2018.
 */

public class Monitor {
    String ra;
    String nome;
    LinkedList<Horario> horarios;

    public Monitor(){
        horarios = new LinkedList<Horario>();
    }

    public Monitor(String ra, String nome){
        horarios = new LinkedList<Horario>();
        this.ra = ra;
        this.nome = nome;
    }
    public String getRa(){
        return this.ra;
    }
    public String getNome(){
        return this.nome;
    }
    public void setRa(String ra){
        this.ra = ra;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void add(Horario h){
        horarios.add(h);
    }

}

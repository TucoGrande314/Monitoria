package br.unicamp.cotuca.monitoria;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by u16167 on 16/05/2018.
 */

public class Monitor {
    String ra;
    String nome;
    List<Horario> horarios;

    public Monitor(){
        horarios = new ArrayList<Horario>();
    }

    public Monitor(String ra, String nome){
        horarios = new ArrayList<Horario>();
        this.ra = ra;
        this.nome = nome;
    }
    public String getRa(){
        return this.ra;
    }
    public String getNome(){
        return this.nome;
    }
    public List<Horario> getHorarios(){return horarios;}
    public void setRa(String ra){
        this.ra = ra;
    }
    public void setNome(String nome){this.nome = nome;}
    public void setHorarios(List horarios){this.horarios = horarios;}

}

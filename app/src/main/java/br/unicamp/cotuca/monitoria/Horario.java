package br.unicamp.cotuca.monitoria;

import android.annotation.TargetApi;

import java.time.DayOfWeek;
import java.util.Date;
public class Horario{
    int idHorario;
    DayOfWeek dia;
    Date horario;

    public Horario(){}
    public Horario(int idHorario, DayOfWeek dia, Date horario){
        this.idHorario = idHorario;
        this.dia = dia;
        this.horario = horario;
    }
    public int getId(){
        return this.idHorario;
    }
    public DayOfWeek getDia(){
        return this.dia;
    }
    public Date getDate(){
        return this.horario;
    }
    public void setId(int idHorario){
        this.idHorario = idHorario;
    }
    public void setDia(DayOfWeek dia){
        this.dia = dia;
    }
    public void setHorario(Date horario){
        this.horario = horario;
    }
}
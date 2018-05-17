package br.unicamp.cotuca.monitoria;
import android.support.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class HorarioJSONParser {
    public static List<Horario> parseDados(String content) {
        try {

            JSONArray jsonArray = new JSONArray(content);
            List<Horario> horarioList = new ArrayList<>();
            for (int i = 0; i< jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Horario horario = new Horario();
                horario.setDia((jsonObject.getInt("diaDaSemana")));
                try
                {
                horario.setHorario((new SimpleDateFormat("HH:mm")).parse(jsonObject.getString("horario")));
                }
                catch (ParseException e) {
                    e.printStackTrace();
                    return null;
                }
                horarioList.add(horario);
            }
            return horarioList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
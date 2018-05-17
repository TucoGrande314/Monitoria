package br.unicamp.cotuca.monitoria;

import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;
        import java.util.ArrayList;
        import java.util.List;
public class MonitorJSONParser {
    public static List<Monitor> parseDados(String content) {
        try {

            JSONArray jsonArray = new JSONArray(content);
            List<Monitor> monitorList = new ArrayList<>();
            for (int i = 0; i< jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Monitor monitor = new Monitor();
                monitor.setRa(jsonObject.getString("raMonitor"));
                monitor.setNome(jsonObject.getString("nome"));
                monitorList.add(monitor);
            }
            return monitorList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}

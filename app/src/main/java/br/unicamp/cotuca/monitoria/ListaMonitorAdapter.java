package br.unicamp.cotuca.monitoria;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import 	android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by u16167 on 16/05/2018.
 */

public class ListaMonitorAdapter extends ArrayAdapter<Monitor> {
    private Context context;
    private List<Monitor> monitores = null;
    public ListaMonitorAdapter(Context context, List<Monitor> monitores) {
        super(context,0, monitores);
        this.monitores = monitores;
        this.context = context;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        Monitor monitor = monitores.get(position);
        if(view == null)
            view = LayoutInflater.from(context).inflate(R.layout.lista_monitores, null);
        //Cria uma view de imagem
        ImageView imageViewMonitor = (ImageView) view.findViewById(R.id.image_view_monitor);
        imageViewMonitor.setImageResource(getImage(context, "m"+monitor.getRa()));
        //Cria uma view de texto
        TextView textViewNomeMonitor = (TextView)
                view.findViewById(R.id.text_view_nome_monitor);
        textViewNomeMonitor.setText(monitor.getNome());
        //Retorna o objeto view
        return view;
    }
    public static int getImage(Context context, String nomeImagem){
        return context.getResources().getIdentifier("drawable/"+nomeImagem, null, context.getPackageName());
    }
}

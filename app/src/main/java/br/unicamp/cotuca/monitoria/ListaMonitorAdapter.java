package br.unicamp.cotuca.monitoria;
import 	android.widget.ArrayAdapter
/**
 * Created by u16167 on 16/05/2018.
 */

public class ListaMonitoresAdapter extends ArrayAdapter<Monitor> {
    private Context context;
    private List<Monitor> monitores = null;
    public ListaMonitoresAdapter(Context context, List<Monitor> monitores) {
        super(context,0, monitores);
        this.monitores = monitores;
        this.context = context;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        Monitor monitores = monitores.get(position);
        if(view == null)
            view = LayoutInflater.from(context).inflate(R.layout.lista_monitores, null);
        //Cria uma view de imagem
        ImageView imageViewMonitor = (ImageView) view.findViewById(R.id.image_view_monitor);
        imageViewMonitor.setImageResource(monitor.getRA+".jpg");
        //Cria uma view de texto
        TextView textViewNomeMonitor = (TextView)
                view.findViewById(R.id.text_view_nome_monitor);
        textViewNomeMonitor.setText(monitor.getNome());
        //Retorna o objeto view
        return view;
    }
}

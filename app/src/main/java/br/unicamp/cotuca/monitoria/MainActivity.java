package br.unicamp.cotuca.monitoria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.content.Context;
import android.widget.Toast;
import android.os.AsyncTask;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    ListView    listView;
    List<Monitor> monitoresList;
    static final String root = "http://177.220.18.71:18000/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
        listView = findViewById(R.id.listView);
        monitoresList = new ArrayList<>();

      /*  if(isOnline())
            buscarDados(root+"/monitores");
        else
            Toast.makeText(this,"Rede não disponível, verigique sua conexão e reenicie a aplicação",Toast.LENGTH_LONG).show();*/

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.iniciar_tarefa)
        {
            if(isOnline()){
                buscarDados(root+"monitor");
            }
            else
                Toast.makeText(this,"Rede não disponível, verifique sua conexão",Toast.LENGTH_LONG).show();
        }
        item.setVisible(false);
        return super.onOptionsItemSelected(item);
    }

    protected boolean isOnline(){
        ConnectivityManager cm = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()){
            return true;
        }else{
            return false;
        }
    }
    private class MyTask extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }
        @Override
        protected String doInBackground(String... params) {
            String conteudo = HttpManager.getDados(params[0]);
            return conteudo;
        }
        @Override
        protected void onPostExecute(String s) {
            monitoresList = MonitorJSONParser.parseDados(s);
            progressBar.setVisibility(View.INVISIBLE);
            atualizaView();
        }
        @Override
        protected void onProgressUpdate(String... values) {
            //atualizarView(values[0]);
        }
    }
    private void buscarDados(String uri) {
        MyTask task = new MyTask();
        task.execute(uri);
    }
    protected void atualizaView(){
        if (monitoresList != null){
            final ListaMonitorAdapter monitoresAdapter = new ListaMonitorAdapter(this,monitoresList);
            listView.setAdapter(monitoresAdapter);
            listView.setVisibility(View.VISIBLE);
        }
        else{
            Toast.makeText(this,"nulocarai",Toast.LENGTH_LONG).show();
        }
    }



}

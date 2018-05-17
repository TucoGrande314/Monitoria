package br.unicamp.cotuca.monitoria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class listarHorarios extends AppCompatActivity {

    TextView tvRA;
    TextView tvNome;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_horarios);

        tvRA = findViewById(R.id.tvRA);
        tvRA.setText(getIntent().getExtras().getString("ra"));
        tvNome = findViewById(R.id.tvNome);
        String nome = getIntent().getExtras().getString("nome");
        nome = nome.substring(0, nome.indexOf(" "));
        tvNome.setText(nome);
        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(this.getResources().getIdentifier("drawable/m"+
                                                                            getIntent().getExtras().getString("ra"),
                                                                            null, this.getPackageName()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.horarios, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(new Intent(listarHorarios.this, MainActivity.class));
        return super.onOptionsItemSelected(item);
    }
}

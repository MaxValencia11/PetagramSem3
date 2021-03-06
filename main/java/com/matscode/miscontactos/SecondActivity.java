package com.matscode.miscontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private RecyclerView listaContactos;
    ArrayList<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);

        androidx.appcompat.widget.Toolbar miActionbar = findViewById(R.id.miActionbar2);
        setSupportActionBar(miActionbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();
    }

    /*public void llamar(View v){
        String telefono = tvTelefono.getText().toString();
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + telefono)));
    }

    public void enviarMail(View v){
        String email = tvEmail.getText().toString();
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email"));
    }*/

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

    public MascotaAdaptador adaptador;
    private void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, this);
        listaContactos.setAdapter(adaptador);
    }

    public void inicializarListaContactos(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.ic_parrot,"Speaker", "3"));
        mascotas.add(new Mascota(R.drawable.ic_chicken, "Pee Oww", "5"));
        mascotas.add(new Mascota(R.drawable.ic_owl,"Hedwig", "4"));
        mascotas.add(new Mascota( R.drawable.ic_dog,"Dogo", "3"));
        mascotas.add(new Mascota(R.drawable.ic_cat, "Chami", "2"));
    }
}
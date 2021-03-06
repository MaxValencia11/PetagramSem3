package com.matscode.miscontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listaContactos;
    ArrayList<Mascota> mascotas;
    ImageButton btnLastRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidx.appcompat.widget.Toolbar miActionbar = findViewById(R.id.miActionbar);
        setSupportActionBar(miActionbar);
        
        btnLastRating = (ImageButton) findViewById(R.id.btnLastRating);

        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this, 2); Para ponerlo en Grid

        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();

        btnLastRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        /*ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(getResources().getString(R.string.pnombre), mascotas.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), mascotas.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), mascotas.get(position).getEmail());
                startActivity(intent);
                finish();
            }
        });*/
    }

    public MascotaAdaptador adaptador;
    private void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, this);
        listaContactos.setAdapter(adaptador);
    }

    public void inicializarListaContactos(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota( R.drawable.ic_dog,"Dogo", "3"));
        mascotas.add(new Mascota(R.drawable.ic_cat, "Chami", "2"));
        mascotas.add(new Mascota(R.drawable.ic_chicken, "Pee Oww", "5"));
        mascotas.add(new Mascota(R.drawable.ic_owl,"Hedwig", "4"));
        mascotas.add(new Mascota(R.drawable.ic_dog2,"Chore", "4"));
        mascotas.add(new Mascota(R.drawable.ic_parrot,"Speaker", "3"));
    }
}

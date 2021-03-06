package com.matscode.miscontactos;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.ContactoViewHolder>{
    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    //Infla el Layout y lo pasa al viewholder para que obtenga los viewa
    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);
        return new ContactoViewHolder(v);
    }

    @Override //Asocia cada elemento de la lista con cada view
    public void onBindViewHolder(@NonNull ContactoViewHolder contactoViewHolder, int position) {
        Mascota mascota = mascotas.get(position);
        contactoViewHolder.imgFoto.setImageResource(mascota.getFoto());
        contactoViewHolder.tvNombreCV.setText(mascota.getNombre());
        contactoViewHolder.tvTelefonoCV.setText(mascota.getRating());

        /*contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, SecondActivity.class);
                intent.putExtra("nombre", mascota.getNombre());
                intent.putExtra("telefono", mascota.getTelefono());
                intent.putExtra("email", mascota.getEmail());
                activity.startActivity(intent);
            }
        });*/

        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista de mascotas
        return mascotas.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV, tvTelefonoCV;
        private ImageButton btnLike;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto         = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV      = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV    = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
            btnLike         = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
}

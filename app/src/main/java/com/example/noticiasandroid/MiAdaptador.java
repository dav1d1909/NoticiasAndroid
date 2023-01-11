package com.example.noticiasandroid;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MiViewHolder> {

    ArrayList<Noticia>lista;

    public MiAdaptador(ArrayList<Noticia> lista) {//constructor de la clase
        this.lista = lista;
    }

    public static  class MiViewHolder extends RecyclerView.ViewHolder{

        TextView txtTitular,txtCuerpo;

        public MiViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitular = itemView.findViewById(R.id.txtTitular);
            txtCuerpo = itemView.findViewById(R.id.txtCuerpo);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(itemView.getContext(), DescripcionActivity.class);
                    i.putExtra("titular", txtTitular.getText().toString());
                    i.putExtra("cuerpo", txtCuerpo.getText().toString());
                    itemView.getContext().startActivity(i);
                }
            });

        }
    }
    @NonNull
    @Override
    public MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.elemento,parent,false);
        MiViewHolder mv = new MiViewHolder(v);

        return mv;
    }

    @Override
    public void onBindViewHolder(@NonNull MiViewHolder holder, int position) {

        holder.txtTitular.setText(lista.get(position).getTitular());
        holder.txtCuerpo.setText(lista.get(position).getCuerpo());



    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}

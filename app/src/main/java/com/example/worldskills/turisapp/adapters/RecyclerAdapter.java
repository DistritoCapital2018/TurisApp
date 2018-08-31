package com.example.worldskills.turisapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.worldskills.turisapp.R;
import com.example.worldskills.turisapp.modelo.LugaresModelo;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.ViewHolder> implements View.OnClickListener {

    //Se crea un arreglo de objetos de del modelo Lugar.
    ArrayList<LugaresModelo> lugares;


    //Creo el onClickListenerPara el fragment
    private View.OnClickListener listener;

    //Creo el constructor del arreglo.
    public RecyclerAdapter(ArrayList<LugaresModelo> lugares) {
        this.lugares = lugares;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflo la vista y le paso el item_list creado anteriormente.
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

        v.setOnClickListener(this);

        return new ViewHolder(v);



    }

    public void setOnClickListner(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imagenRecycler.setImageResource(R.mipmap.ic_launcher);
        //holder.nombreRecycler.setText();

    }

    @Override
    public int getItemCount() {
        //Le paso el tamaño del modelo.
        return lugares.size();
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            onClick(v);
        }
    }

    //En este metodo instancio los componentes.
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imagenRecycler;
        TextView nombreRecycler, descripcionRecycler, ubicacionRecycler;


        public ViewHolder(View itemView) {
            super(itemView);

            //Asigno los componentes con el xml.
            imagenRecycler = itemView.findViewById(R.id.imgList);
            nombreRecycler = itemView.findViewById(R.id.tvNombre);
            descripcionRecycler = itemView.findViewById(R.id.tvDescripcion);
            ubicacionRecycler = itemView.findViewById(R.id.tvUbicacion);

        }
    }
}

package com.androiddesdecero.reciclerview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static android.R.string.no;
import static android.os.Build.VERSION_CODES.M;

/**
 * Created by albertopalomarrobledo on 8/7/17.
 */

public class PesoAdaptador extends RecyclerView.Adapter<PesoAdaptador.PesoViewHolder>{

    public static final String PESO = "PESO";
    public static final String FECHA = "FECHA";

    private List<Peso> pesos;

    public PesoAdaptador(List<Peso> pesos){
        this.pesos = pesos;
    }

    @Override
    public PesoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new PesoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PesoViewHolder pesoViewHolder, int position) {
        Peso peso = pesos.get(position);
        pesoViewHolder.tvFecha.setText(peso.getmFecha());
        pesoViewHolder.tvPeso.setText(peso.getmPeso());
        double diferencia;
        String diferenciaString;
        if(position!=0){
            Peso pesoMenosUno = pesos.get(position-1);
            diferencia = Double.parseDouble(peso.getmPeso())-Double.parseDouble(pesoMenosUno.getmPeso());
            diferenciaString = String.valueOf(diferencia);
        }else{
            diferencia=0;
            diferenciaString="0";
        }
        pesoViewHolder.tvDiferencia.setText(diferenciaString);
        if(diferencia>0){
            pesoViewHolder.tvDiferencia.setTextColor(Color.parseColor("#64DD17"));
        }else if(diferencia==0){
            pesoViewHolder.tvDiferencia.setTextColor(Color.parseColor("#000000"));
        }else{
            pesoViewHolder.tvDiferencia.setTextColor(Color.parseColor("#D50000"));
        }
    }


    @Override
    public int getItemCount() {
        return pesos.size();
    }

    public class PesoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tvFecha;
        private TextView tvPeso;
        private TextView tvDiferencia;

        public PesoViewHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            tvFecha=(TextView) itemView.findViewById(R.id.tvFecha);
            tvPeso=(TextView) itemView.findViewById(R.id.tvPeso);
            tvDiferencia=(TextView) itemView.findViewById(R.id.tvDiferencia);
        }

        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            int position = getAdapterPosition();
            Peso peso = pesos.get(position);
            Intent intent = new Intent(v.getContext(), PesoEditar.class);
            intent.putExtra(PESO, peso.getmPeso());
            intent.putExtra(FECHA, peso.getmFecha());
            context.startActivity(intent);
        }
    }
}

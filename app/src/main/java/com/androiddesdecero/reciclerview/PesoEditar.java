package com.androiddesdecero.reciclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.androiddesdecero.reciclerview.PesoAdaptador.FECHA;
import static com.androiddesdecero.reciclerview.PesoAdaptador.PESO;

public class PesoEditar extends AppCompatActivity {

    private String mPeso;
    private String mFecha;

    TextView tvPeso;
    TextView tvFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peso_editar);

        mPeso = getIntent().getStringExtra(PESO);
        mFecha = getIntent().getStringExtra(FECHA);

        tvFecha = (TextView)findViewById(R.id.fecha);
        tvFecha.setText(mFecha);
        tvPeso = (TextView)findViewById(R.id.peso);
        tvPeso.setText(mPeso);

    }
}

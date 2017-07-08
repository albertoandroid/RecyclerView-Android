package com.androiddesdecero.reciclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Peso> pesos;
    private RecyclerView listaPesos;
    private PesoAdaptador adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaPesos=(RecyclerView)findViewById(R.id.rvLista);
        LinearLayoutManager lim = new LinearLayoutManager(this);
        lim.setOrientation(LinearLayoutManager.VERTICAL);
        listaPesos.setLayoutManager(lim);

        data();
        inicializaAdaptador();
    }

    private void data() {
        pesos = new ArrayList<>();
        pesos.add(new Peso("01/01/2018","78"));
        pesos.add(new Peso("02/01/2018","79"));
        pesos.add(new Peso("03/01/2018","72"));
        pesos.add(new Peso("04/01/2018","72"));
        pesos.add(new Peso("05/01/2018","74"));
        pesos.add(new Peso("06/01/2018","72"));
        pesos.add(new Peso("07/01/2018","73"));
        pesos.add(new Peso("08/01/2018","71"));
        pesos.add(new Peso("09/01/2018","75"));
        pesos.add(new Peso("01/01/2018","78"));
        pesos.add(new Peso("02/01/2018","79"));
        pesos.add(new Peso("03/01/2018","72"));
        pesos.add(new Peso("04/01/2018","73"));
        pesos.add(new Peso("05/01/2018","74"));
        pesos.add(new Peso("06/01/2018","72"));
        pesos.add(new Peso("07/01/2018","73"));
        pesos.add(new Peso("08/01/2018","71"));
        pesos.add(new Peso("09/01/2018","75"));
    }

    private void inicializaAdaptador() {
        adaptador = new PesoAdaptador(pesos);
        listaPesos.setAdapter(adaptador);
    }
}

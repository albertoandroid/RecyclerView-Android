package com.androiddesdecero.reciclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;

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

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(createHelperCallback());
        itemTouchHelper.attachToRecyclerView(listaPesos);

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

    private ItemTouchHelper.Callback createHelperCallback(){
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback =
                new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                        ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT){

                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                        moveItem(viewHolder.getAdapterPosition(),target.getAdapterPosition());
                        return false;
                    }

                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                        deleteItem(viewHolder.getAdapterPosition());
                    }
                };
        return simpleItemTouchCallback;
    }

    private void moveItem(int oldPos, int newPos){
        Peso item = (Peso) pesos.get(oldPos);
        pesos.remove(oldPos);
        pesos.add(newPos, item);
        adaptador.notifyItemMoved(oldPos, newPos);
    }

    private void deleteItem(final int position){
        pesos.remove(position);
        adaptador.notifyItemRemoved(position);
    }
}

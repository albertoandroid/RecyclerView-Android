package com.androiddesdecero.reciclerview;

/**
 * Created by albertopalomarrobledo on 8/7/17.
 */

public class Peso {

    private String mFecha;
    private String mPeso;

    public Peso(String mFecha, String mPeso) {
        this.mFecha = mFecha;
        this.mPeso = mPeso;
    }

    public String getmFecha() {
        return mFecha;
    }

    public void setmFecha(String mFecha) {
        this.mFecha = mFecha;
    }

    public String getmPeso() {
        return mPeso;
    }

    public void setmPeso(String mPeso) {
        this.mPeso = mPeso;
    }
}

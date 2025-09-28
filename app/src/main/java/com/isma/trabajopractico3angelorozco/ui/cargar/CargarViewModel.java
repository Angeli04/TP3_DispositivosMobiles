package com.isma.trabajopractico3angelorozco.ui.cargar;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.isma.trabajopractico3angelorozco.MainActivity;
import com.isma.trabajopractico3angelorozco.modelo.Producto;

public class CargarViewModel extends AndroidViewModel {

    MutableLiveData<String> mMensaje;

    public LiveData<String> getMensaje() {
        if (mMensaje == null) {
            mMensaje = new MutableLiveData<>();
        }
        return mMensaje;
    }

    public CargarViewModel(@NonNull Application application) {
        super(application);

    }
    // TODO: Implement the ViewModel

    public void guardarProducto(String codigo, String descripcion, double precio){
        // validar datos
        if(codigo.isEmpty() || descripcion.isEmpty() || precio <= 0){
            mMensaje.setValue("Debe completar todos los campos");
            return;
        }
        // validar codigo unico
        for(Producto p : MainActivity.productos){
            if(p.getCodigo().equals(codigo)){
                mMensaje.setValue("El codigo ya existe");
                return;
            }
        }

        Producto p = new Producto(codigo, descripcion, precio);
        MainActivity.productos.add(p);
        mMensaje.setValue("Producto guardado correctamente");
    }

}
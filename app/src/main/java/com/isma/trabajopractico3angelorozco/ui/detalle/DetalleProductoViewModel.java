package com.isma.trabajopractico3angelorozco.ui.detalle;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.isma.trabajopractico3angelorozco.MainActivity;
import com.isma.trabajopractico3angelorozco.modelo.Producto;

public class DetalleProductoViewModel extends AndroidViewModel {
    public DetalleProductoViewModel(@NonNull Application application) {
        super(application);
    }

    public void eliminar(Producto p){
        for (Producto producto : MainActivity.productos) {
            if (producto.equals(p)) {
                MainActivity.productos.remove(producto);
                return;
            }
        }
    }

    // TODO: Implement the ViewModel
}
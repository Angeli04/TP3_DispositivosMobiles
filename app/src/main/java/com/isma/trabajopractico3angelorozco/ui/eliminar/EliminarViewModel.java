package com.isma.trabajopractico3angelorozco.ui.eliminar;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.isma.trabajopractico3angelorozco.MainActivity;
import com.isma.trabajopractico3angelorozco.modelo.Producto;

public class EliminarViewModel extends AndroidViewModel {

    private MutableLiveData<Producto> productoEncontrado;
    private MutableLiveData<String> mensaje;


    public MutableLiveData<Producto> getProductoEncontrado() {
        if (productoEncontrado == null) {
            productoEncontrado = new MutableLiveData<>();
        }
        return productoEncontrado;
    }

    public MutableLiveData<String> getMensaje() {
        if (mensaje == null) {
            mensaje = new MutableLiveData<>();
        }
        return mensaje;
    }

    public EliminarViewModel(@NonNull Application application) {
        super(application);
    }

    public void buscarProducto(String codigo) {

        if (codigo == null || codigo.trim().isEmpty()) {
            mensaje.setValue("Debes ingresar un código.");
            return;
        }

        for (Producto p : MainActivity.productos) {
            if (p.getCodigo().equals(codigo)) {
                productoEncontrado.setValue(p);
                return;
            }
        }

        mensaje.setValue("El producto con código " + codigo + " no existe.");
    }

    // TODO: Implement the ViewModel
}
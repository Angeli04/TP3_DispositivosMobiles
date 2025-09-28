package com.isma.trabajopractico3angelorozco.ui.listar;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.isma.trabajopractico3angelorozco.MainActivity;
import com.isma.trabajopractico3angelorozco.modelo.Producto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListarViewModel extends AndroidViewModel {
    private MutableLiveData<List<Producto>> listaMutable;
    public ListarViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Producto>> getListaMutable(){
        if(listaMutable == null){
            listaMutable = new MutableLiveData<>();
        }
        return listaMutable;
    }

    public void cargarLista(){
        ArrayList<Producto> lista = new ArrayList<>(MainActivity.productos);  // copio la lista del main
        Collections.sort(lista, Comparator.comparing(Producto::getDescripcion)); // ordeno la lista
        listaMutable.setValue(lista);  // envio la lista al observador
    }

}
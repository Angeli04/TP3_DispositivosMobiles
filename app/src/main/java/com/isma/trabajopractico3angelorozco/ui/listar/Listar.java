package com.isma.trabajopractico3angelorozco.ui.listar;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isma.trabajopractico3angelorozco.ProductoAdapter;
import com.isma.trabajopractico3angelorozco.R;
import com.isma.trabajopractico3angelorozco.databinding.FragmentListarBinding;
import com.isma.trabajopractico3angelorozco.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class Listar extends Fragment {

    private ListarViewModel mViewModel;
    private FragmentListarBinding binding;
    private ProductoAdapter adapter;

    public static Listar newInstance() {
        return new Listar();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentListarBinding.inflate(inflater, container, false);
        View root = binding.getRoot(); // Guardar la vista raíz para retornarla al final
        mViewModel = new ViewModelProvider(this).get(ListarViewModel.class);

        // Preparar los argumentos para el ProductoAdapter
        List<Producto> listaInicial = new ArrayList<>();
        Context context = getContext(); // O requireContext() si prefieres que falle rápido si no hay contexto
        LayoutInflater layoutInflater = inflater; // Usar el inflater de onCreateView

        // Inicializar el adapter con los argumentos correctos
        adapter = new ProductoAdapter(listaInicial, context, layoutInflater);

        binding.lista.setLayoutManager(new LinearLayoutManager(context)); // Usar el context obtenido
        binding.lista.setAdapter(adapter);

        mViewModel.getListaMutable().observe(getViewLifecycleOwner(), (List<Producto> productos) -> {
            adapter.actualizarLista(productos);
        });

        mViewModel.cargarLista();
        return root; // Retornar la vista raíz
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ListarViewModel.class);
        // TODO: Use the ViewModel
    }

}
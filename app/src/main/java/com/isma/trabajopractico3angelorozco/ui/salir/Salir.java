package com.isma.trabajopractico3angelorozco.ui.salir;

import android.app.AlertDialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isma.trabajopractico3angelorozco.databinding.FragmentSalirBinding;

public class Salir extends Fragment {

    private FragmentSalirBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentSalirBinding.inflate(inflater, container, false);

        // mostrar a penas se crea
        mostrarDialogoSalir();

        return binding.getRoot();
    }

    private void mostrarDialogoSalir() {
        new AlertDialog.Builder(requireContext())
                .setTitle("Salir")
                .setMessage("¿Seguro que desea salir de la aplicación?")
                .setPositiveButton("Sí", (dialog, which) -> {
                    requireActivity().finishAffinity(); // cierra la app
                })
                .setNegativeButton("No", (dialog, which) -> {
                    dialog.dismiss();
                    // Opcional: volver al fragment anterior
                    requireActivity().onBackPressed();
                })
                .setCancelable(false)
                .show();
    }
}

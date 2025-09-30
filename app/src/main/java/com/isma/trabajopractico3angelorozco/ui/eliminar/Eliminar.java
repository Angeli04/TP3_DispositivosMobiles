package com.isma.trabajopractico3angelorozco.ui.eliminar;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.isma.trabajopractico3angelorozco.R;
import com.isma.trabajopractico3angelorozco.databinding.FragmentEliminarBinding;
import com.isma.trabajopractico3angelorozco.ui.detalle.DetalleProducto;

public class Eliminar extends Fragment {

    private EliminarViewModel mViewModel;
    private FragmentEliminarBinding binding;

    public static Eliminar newInstance() {
        return new Eliminar();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentEliminarBinding.inflate(inflater, container, false);
        mViewModel = new ViewModelProvider(this).get(EliminarViewModel.class);

        mViewModel.getProductoEncontrado().observe(getViewLifecycleOwner(), producto -> {
            Fragment detalleFragment = new DetalleProducto();
            Bundle args = new Bundle();
            args.putSerializable("producto", producto);
            detalleFragment.setArguments(args);

            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.nav_host_fragment_content_main, detalleFragment)
                    .addToBackStack(null)
                    .commit();
            binding.btEliminar.setEnabled(false);
            binding.etCodigoEliminar.setEnabled(false);
            binding.btEliminar.setVisibility(View.GONE);
            binding.etCodigoEliminar.setVisibility(View.GONE);
            binding.tvsubtitulo.setVisibility(View.GONE);
            binding.tvTitulo.setVisibility(View.GONE);



        });

        mViewModel.getMensaje().observe(getViewLifecycleOwner(), mensaje -> {
            Toast.makeText(getContext(), mensaje, Toast.LENGTH_SHORT).show();
        });

        binding.btEliminar.setOnClickListener(v -> {
            String codigo = binding.etCodigoEliminar.getText().toString();
            mViewModel.buscarProducto(codigo);
        });

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(EliminarViewModel.class);
        // TODO: Use the ViewModel
    }

}
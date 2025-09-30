package com.isma.trabajopractico3angelorozco.ui.detalle;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.isma.trabajopractico3angelorozco.R;
import com.isma.trabajopractico3angelorozco.databinding.FragmentDetalleProductoBinding;
import com.isma.trabajopractico3angelorozco.modelo.Producto;

public class DetalleProducto extends Fragment {

    private DetalleProductoViewModel mViewModel;
    private FragmentDetalleProductoBinding binding;

    public static DetalleProducto newInstance() {
        return new DetalleProducto();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentDetalleProductoBinding.inflate(inflater, container, false);
        mViewModel = new ViewModelProvider(this).get(DetalleProductoViewModel.class);
        Producto producto = (Producto) getArguments().getSerializable("producto");
        binding.tvCod.setText(producto.getCodigo());
        binding.tvDesc.setText(producto.getDescripcion());
        binding.tvPreci.setText(String.valueOf(producto.getPrecio()));
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.eliminar(producto);
                Toast.makeText(getContext(), "Producto eliminado", Toast.LENGTH_SHORT).show();
                getActivity().getSupportFragmentManager().popBackStack();
                binding.tvCod.setVisibility(View.GONE);
                binding.tvDesc.setVisibility(View.GONE);
                binding.tvPreci.setVisibility(View.GONE);
                binding.button.setVisibility(View.GONE);
                binding.tvtittle.setVisibility(View.GONE);
            }

        });

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DetalleProductoViewModel.class);
        // TODO: Use the ViewModel
    }

}
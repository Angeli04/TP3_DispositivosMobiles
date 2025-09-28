package com.isma.trabajopractico3angelorozco;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.isma.trabajopractico3angelorozco.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolderProducto> {

    private List<Producto> lista ;
    private Context context;
    private LayoutInflater li;

    public ProductoAdapter(List<Producto>listado,Context context, LayoutInflater li){
       this.context = context;
       this.lista = listado;
       this.li = li;
    };

    @NonNull
    @Override
    public ViewHolderProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = li.inflate(R.layout.item,parent,false);
        return new ViewHolderProducto(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProducto holder, int position) {

        Producto productoActual = lista.get(position);
        holder.tvCodigo.setText(productoActual.getCodigo());
        holder.tvDescripcion.setText(productoActual.getDescripcion());
        holder.tvPrecio.setText(String.valueOf(productoActual.getPrecio()));

    }

    @Override
    public int getItemCount() {
        // si es null, devuelve 0
        return lista != null ? lista.size() : 0;
    }

    public void actualizarLista(List<Producto> productos) {
        this.lista = productos; // Asigna la nueva lista
        notifyDataSetChanged(); // Avisa de un cambio en la lista
    }

    public class ViewHolderProducto extends RecyclerView.ViewHolder{

        TextView tvCodigo, tvDescripcion, tvPrecio;

        public ViewHolderProducto(@NonNull View itemView) {
            super(itemView);
            tvCodigo = itemView.findViewById(R.id.tvCodigo);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
        }
    }

}

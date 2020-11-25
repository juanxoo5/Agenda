package com.example.agenda.view.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.agenda.model.ContactoRepository;
import com.example.agenda.model.entity.Contacto;
import com.example.agenda.viewmodel.AndroidContactoViewModel;

public class ContactoAdapter extends ListAdapter<Contacto, ContactoViewHolder> {


    public ContactoAdapter(@NonNull DiffUtil.ItemCallback<Contacto> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ContactoViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        Contacto current = getItem(position);
        holder.bind(current.getNombre());
    }

    public static class ContactoDiff extends DiffUtil.ItemCallback<Contacto>{

        @Override
        public boolean areItemsTheSame(@NonNull Contacto oldItem, @NonNull Contacto newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Contacto oldItem, @NonNull Contacto newItem) {
            return oldItem.getNombre().equals(newItem.getNombre());
        }
    }
}

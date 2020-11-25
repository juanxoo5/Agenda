package com.example.agenda.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agenda.R;

public class ContactoViewHolder extends RecyclerView.ViewHolder {

    private final Button btContacto;

    public ContactoViewHolder(@NonNull View itemView) {
        super(itemView);
        btContacto = itemView.findViewById(R.id.btContacto);
    }

    //asignamos valor al Tv
    public void bind(String text) {
        btContacto.setText(text);
    }

    //devolvemos el id del contacto
//    public long bind2(long id) {
//        return id;
//    }

    //aquí se crea un layout del tipo item (inflate)
    static ContactoViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ContactoViewHolder(view);
    }
}

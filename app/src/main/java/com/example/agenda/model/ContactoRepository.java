package com.example.agenda.model;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.agenda.ContactoApplication;
import com.example.agenda.model.dao.ContactoDao;
import com.example.agenda.model.entity.Contacto;
import com.example.agenda.model.room.ContactoDb;

import java.util.List;

public class ContactoRepository {

    private ContactoDb db;
    private ContactoDao dao;
    private LiveData<List<Contacto>> liveListaContacto;
    private Contacto contacto1;

    public ContactoRepository(Application context) {
        db = ContactoDb.getDB(context);
        dao = db.getContactoDao();

        //LiveData: carga de datos en segundo plano
        liveListaContacto = dao.getAll();
    }

    public LiveData<List<Contacto>> getLiveListaContactos() {
        return liveListaContacto;
    }

    public void insert(Contacto contacto){
        ContactoApplication.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.insert(contacto);
            }
        });
    }

    public Contacto getContacto (String nombre){
        ContactoApplication.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                contacto1 = dao.get(nombre);
            }
        });
        return  contacto1;
    }


}

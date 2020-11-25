package com.example.agenda.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.agenda.model.ContactoRepository;
import com.example.agenda.model.entity.Contacto;

import java.util.List;

public class AndroidContactoViewModel extends AndroidViewModel {

    private ContactoRepository repository;
    private LiveData<List<Contacto>>liveContactos;

    public AndroidContactoViewModel(@NonNull Application application) {
        super(application);
        repository=new ContactoRepository(application);
        liveContactos = repository.getLiveListaContactos();
    }

    public LiveData<List<Contacto>> getAllContactos(){
        return liveContactos;
    }


    public void insert(Contacto contacto){
        repository.insert(contacto);
    }

    public Contacto getContacto(String nombre){
        Contacto contacto = repository.getContacto(nombre);
        return contacto;
    }

}

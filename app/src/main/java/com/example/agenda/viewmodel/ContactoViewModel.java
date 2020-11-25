package com.example.agenda.viewmodel;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.agenda.model.ContactoRepository;
import com.example.agenda.model.entity.Contacto;

import java.util.List;

public class ContactoViewModel extends ViewModel {

    private ContactoRepository repository;
    private LiveData<List<Contacto>> liveContactos;

    public ContactoViewModel(){
        super();
    }

    public void  setContext(Application application){
        repository = new ContactoRepository(application);
        liveContactos = repository.getLiveListaContactos();
    }

    public LiveData<List<Contacto>> getAllContactos(){
        return liveContactos;
    }

    public void insert(Contacto contacto){
        repository.insert(contacto);
    }

}

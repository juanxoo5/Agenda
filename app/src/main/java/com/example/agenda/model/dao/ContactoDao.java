package com.example.agenda.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.agenda.model.entity.Contacto;

import java.util.List;

@Dao
public interface ContactoDao {

    @Delete
    void delete(Contacto contacto);

    @Query("select * from Contacto where id = :id")
    Contacto get(int id);

    @Query("select * from Contacto where nombre = :nombre")
    Contacto get(String nombre);

    @Query("select * from Contacto order by nombre")
    LiveData<List<Contacto>> getAll();

    @Insert
    long insert(Contacto contacto);

    @Update
    int update(Contacto contacto);

    @Query("delete from Contacto")
    void deleteAll();
}

package com.example.agenda.model.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.agenda.model.dao.ContactoDao;
import com.example.agenda.model.entity.Contacto;

import static com.example.agenda.ContactoApplication.threadExecutor;

@Database(entities = {Contacto.class}, version = 1, exportSchema = false)
public abstract class ContactoDb extends RoomDatabase {

    public abstract ContactoDao getContactoDao();

    private volatile static ContactoDb INSTANCE;


    private static RoomDatabase.Callback callback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            threadExecutor.execute(() -> {
                ContactoDao dao = INSTANCE.getContactoDao();
                dao.deleteAll();
                Contacto contacto = new Contacto();
                contacto.setNombre("Carmen");
                contacto.setApellidos("Petra");
                contacto.setFecha_nacimiento("1998-7-15");
                contacto.setTelefono(691913742);
                contacto.setLocalidad("Almunecar");
                contacto.setCalle("Colina de San Cristobal");
                contacto.setNumero(41);
                dao.insert(contacto);
                contacto = new Contacto();
                contacto.setNombre("Erika");
                contacto.setApellidos("Rodriguez");
                contacto.setFecha_nacimiento("1993-11-08");
                contacto.setTelefono(684751248);
                contacto.setLocalidad("Almunecar");
                contacto.setCalle("Avd. Costa del sol");
                contacto.setNumero(23);
                dao.insert(contacto);
            });
        }
    };

    public static ContactoDb getDB(final Context context) {
        if (INSTANCE == null) {
            synchronized (ContactoDb.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ContactoDb.class, "contactodb").addCallback(callback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

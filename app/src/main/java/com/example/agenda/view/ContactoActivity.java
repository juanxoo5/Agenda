package com.example.agenda.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.Toast;

import com.example.agenda.R;
import com.example.agenda.model.entity.Contacto;
import com.example.agenda.view.adapter.ContactoAdapter;
import com.example.agenda.viewmodel.AndroidContactoViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ContactoActivity extends AppCompatActivity {

    public static final int NEW_CONTACT_ACTIVITY_REQUEST_CODE = 1;
    public static final int EDIT_CONTACT_ACTIVITY_REQUEST_CODE = 2;
    public static final String EXTRA_REPLY_NOMBRE1 = " com.example.agenda.NOMBRE";
    public static final String EXTRA_REPLY_APELLIDOS1 = "com.example.agenda.APELLIDOS";
    public static final String EXTRA_REPLY_TELEFONO1 = "com.example.agenda.TELEFONO";
    public static final String EXTRA_REPLY_CALLE1 = "com.example.agenda.CALLE";
    public static final String EXTRA_REPLY_NUMERO1 = "com.example.agenda.NUMERO";
    public static final String EXTRA_REPLY_LOCALIDAD1= "com.example.agenda.LOCALIDAD";
    public static final String EXTRA_REPLY_FECHA_NACIMIENTO1 = "com.example.agenda.FECHA_NACIMIENTO";

    public AndroidContactoViewModel androidViewModel;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        //HABILITO AQUÍ LOS BOTONES DE EDITAR Y DE ELIMINAR PORQUE NO SÉ HACERLOS FUNCIONAR AL CARGAR LA ACTIVIDAD, YA QUE AL ESTAR LOS BOTONES EN LOS ITEM
//        //Y NO ESTAR CARGADOS TODAVIA, DA NULL POINTER EXCEPTION AL BUSCARLOS Y QUERER USARLOS
        habilitarBotones();
        if(requestCode == NEW_CONTACT_ACTIVITY_REQUEST_CODE) {
            if(resultCode == RESULT_OK) {
                Contacto contacto = new Contacto();
                contacto.setNombre(data.getStringExtra(NewContactoActivity.EXTRA_REPLY_NOMBRE));
                contacto.setApellidos(data.getStringExtra(NewContactoActivity.EXTRA_REPLY_APELLIDOS));
                contacto.setTelefono(Long.parseLong(data.getStringExtra(NewContactoActivity.EXTRA_REPLY_TELEFONO)));
                contacto.setCalle(data.getStringExtra(NewContactoActivity.EXTRA_REPLY_CALLE));
                contacto.setNumero(Integer.parseInt(data.getStringExtra(NewContactoActivity.EXTRA_REPLY_NUMERO)));
                contacto.setLocalidad(data.getStringExtra(NewContactoActivity.EXTRA_REPLY_LOCALIDAD));
                contacto.setFecha_nacimiento(data.getStringExtra(NewContactoActivity.EXTRA_REPLY_FECHA_NACIMIENTO));
                androidViewModel.insert(contacto);
            }else if(resultCode == RESULT_CANCELED) {
                Toast.makeText(
                        getApplicationContext(),
                        R.string.empty_not_saved,
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        androidViewModel = new ViewModelProvider(this).get(AndroidContactoViewModel.class);
        init();
    }


    public void init(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final ContactoAdapter adapter = new ContactoAdapter(new ContactoAdapter.ContactoDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton btAddNew = findViewById(R.id.btNewContact);
        btAddNew.setOnClickListener(view -> {
            Intent intent = new Intent(ContactoActivity.this, NewContactoActivity.class);
            startActivityForResult(intent, NEW_CONTACT_ACTIVITY_REQUEST_CODE);
        });
        androidViewModel.getAllContactos().observe(this, new Observer<List<Contacto>>() {
            @Override
            public void onChanged(List<Contacto> contactos) {
                adapter.submitList(contactos);
            }

        });
    }


//  NO SE MANDAR LOS DATOS DEL CONTACTO EDITADO A LA OTRA ACTIVIDAD PARA PODER ELIMINARLO O ACTUALIZARLO, NI COMO SELECCIONAR EL ID CONCRETO DE CADA ITEM,
//  ASI SOLO CONSIGO HABILITAR EL BOTON DEL PRIMER ITEM. LO HE INTENTADO PERO VOY DEMASIADO ATRASADO. USAR LA BASE DE DATOS Y EL DAO CREO QUE ES LO MAS SENCILLO
//  AUNQUE SOLO LO HE PODIDO USAR PARA EL GETALL Y EL INSERT.
    public void habilitarBotones() {

        Button btEdit = findViewById(R.id.btContacto);
        btEdit.setOnClickListener(view -> {
            Intent intent1 = new Intent(ContactoActivity.this, NewContactoActivity.class);
            startActivityForResult(intent1, EDIT_CONTACT_ACTIVITY_REQUEST_CODE);

            Intent intent = new Intent();
            String nombreS = btEdit.getText().toString();
            Contacto contacto = androidViewModel.getContacto(nombreS);
            intent.putExtra(EXTRA_REPLY_NOMBRE1, nombreS);
            //AQUI ME DA UN NULL POINTER PORQUE contacto ESTÁ NULL, PERO DEPURANDO Y ENTRANDO EN LOS METODOS getContacto SI LO RESCATA BIEN Y FUNCIONA. NO LO ENTIENDO!
            intent.putExtra(EXTRA_REPLY_APELLIDOS1, contacto.getApellidos());
            intent.putExtra(EXTRA_REPLY_TELEFONO1, contacto.getTelefono());
            intent.putExtra(EXTRA_REPLY_CALLE1, contacto.getCalle());
            intent.putExtra(EXTRA_REPLY_NUMERO1, contacto.getNumero());
            intent.putExtra(EXTRA_REPLY_LOCALIDAD1, contacto.getLocalidad());
            intent.putExtra(EXTRA_REPLY_FECHA_NACIMIENTO1, contacto.getFecha_nacimiento());
            setResult(RESULT_OK, intent);
        });
    }

}
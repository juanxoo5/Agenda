package com.example.agenda.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.R;
import com.example.agenda.model.entity.Contacto;
import com.example.agenda.viewmodel.AndroidContactoViewModel;

public class NewContactoActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY_NOMBRE = " com.example.agenda.NOMBRE";
    public static final String EXTRA_REPLY_APELLIDOS = "com.example.agenda.APELLIDOS";
    public static final String EXTRA_REPLY_TELEFONO = "com.example.agenda.TELEFONO";
    public static final String EXTRA_REPLY_CALLE = "com.example.agenda.CALLE";
    public static final String EXTRA_REPLY_NUMERO = "com.example.agenda.NUMERO";
    public static final String EXTRA_REPLY_LOCALIDAD= "com.example.agenda.LOCALIDAD";
    public static final String EXTRA_REPLY_FECHA_NACIMIENTO = "com.example.agenda.FECHA_NACIMIENTO";

    private AndroidContactoViewModel androidViewModel;
    private EditText etNombre, etApellidos, etTelefono, etDireccion, etNumero, etLocalidad, etFech_nac;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        init();
    }

    private void init() {
        etNombre = findViewById(R.id.etName);
        etApellidos = findViewById(R.id.etApellidos);
        etTelefono = findViewById(R.id.etPhone);
        etDireccion = findViewById(R.id.etDireccion);
        etNumero = findViewById(R.id.etNumber);
        etLocalidad = findViewById(R.id.etLocalidad);
        etFech_nac = findViewById(R.id.etNacimiento);

        final Button button = findViewById(R.id.btAdd);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(etNombre.getText()) ||
                    TextUtils.isEmpty(etApellidos.getText()) ||
                    TextUtils.isEmpty(etTelefono.getText()) ||
                    TextUtils.isEmpty(etDireccion.getText())  ||
                    TextUtils.isEmpty(etNumero.getText())||
                    TextUtils.isEmpty(etLocalidad.getText())||
                    TextUtils.isEmpty(etFech_nac.getText())    ) {
                setResult(RESULT_CANCELED, replyIntent);
            }else {
                String nombre = etNombre.getText().toString();
                String apellidos = etApellidos.getText().toString();
                String telefono = etTelefono.getText().toString();
                String direccion = etDireccion.getText().toString();
                String numero = etNumero.getText().toString();
                String localidad = etLocalidad.getText().toString();
                String fecha_nacimiento = etFech_nac.getText().toString();
                replyIntent.putExtra(EXTRA_REPLY_NOMBRE, nombre);
                replyIntent.putExtra(EXTRA_REPLY_APELLIDOS, apellidos);
                replyIntent.putExtra(EXTRA_REPLY_TELEFONO, telefono);
                replyIntent.putExtra(EXTRA_REPLY_CALLE, direccion);
                replyIntent.putExtra(EXTRA_REPLY_NUMERO, numero);
                replyIntent.putExtra(EXTRA_REPLY_LOCALIDAD, localidad);
                replyIntent.putExtra(EXTRA_REPLY_FECHA_NACIMIENTO, fecha_nacimiento);

                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}

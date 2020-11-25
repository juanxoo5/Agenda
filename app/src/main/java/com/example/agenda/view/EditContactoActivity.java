//package com.example.agenda.view;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.agenda.R;
//import com.example.agenda.viewmodel.AndroidContactoViewModel;
//
//      //NO ME FUNCIONA LA CLASE!!
//public class EditContactoActivity extends AppCompatActivity {
//    public static final String EXTRA_REPLY_NOMBRE2 = " com.example.agenda.NOMBRE";
//    public static final String EXTRA_REPLY_APELLIDOS2 = "com.example.agenda.APELLIDOS";
//    public static final String EXTRA_REPLY_TELEFONO2 = "com.example.agenda.TELEFONO";
//    public static final String EXTRA_REPLY_CALLE2 = "com.example.agenda.CALLE";
//    public static final String EXTRA_REPLY_NUMERO2 = "com.example.agenda.NUMERO";
//    public static final String EXTRA_REPLY_LOCALIDAD2= "com.example.agenda.LOCALIDAD";
//    public static final String EXTRA_REPLY_FECHA_NACIMIENTO2 = "com.example.agenda.FECHA_NACIMIENTO";
//
//    private AndroidContactoViewModel androidViewModel;
//    private EditText etNombre, etApellidos, etTelefono, etDireccion, etNumero, etLocalidad, etFech_nac;
//
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(resultCode == RESULT_OK) {
//            //MI INTENCION AQUI ES RELLENAR LOS CAMPOS CON LOS DATOS RESCATADOS DEL CONTACTO, PARA PODER EDITARLO PERO NO ENTRA!
//            etNombre.setText(data.getStringExtra(ContactoActivity.EXTRA_REPLY_NOMBRE1));
//            etApellidos.setText(data.getStringExtra(ContactoActivity.EXTRA_REPLY_APELLIDOS1));
//            etTelefono.setText((int) Long.parseLong(data.getStringExtra(ContactoActivity.EXTRA_REPLY_TELEFONO1) ));
//            etDireccion.setText(data.getStringExtra(ContactoActivity.EXTRA_REPLY_CALLE1));
//            etNumero.setText(Integer.parseInt(data.getStringExtra(ContactoActivity.EXTRA_REPLY_NUMERO1)));
//            etLocalidad.setText(data.getStringExtra(ContactoActivity.EXTRA_REPLY_LOCALIDAD1));
//            etFech_nac.setText(data.getStringExtra(ContactoActivity.EXTRA_REPLY_FECHA_NACIMIENTO1));
//            //AQUI COMPROBARIA SI HAN CAMBIADO LOS CAMPOS Y HARIA EL UPDATE
//        }else if(resultCode == RESULT_CANCELED) {
//            Toast.makeText(
//                    getApplicationContext(),
//                    R.string.empty_not_saved,
//                    Toast.LENGTH_LONG).show();
//        }
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_edit);
//        init();
//    }
//
//    private void init() {
//        etNombre = findViewById(R.id.etName1);
//        etNombre.setText(ContactoActivity.EXTRA_REPLY_NOMBRE1);
//        etApellidos = findViewById(R.id.etApellidos1);
//        etTelefono = findViewById(R.id.etPhone1);
//        etDireccion = findViewById(R.id.etDireccion1);
//        etNumero = findViewById(R.id.etNumber1);
//        etLocalidad = findViewById(R.id.etLocalidad1);
//        etFech_nac = findViewById(R.id.etNacimiento1);
//
//        final Button button = findViewById(R.id.btAdd);
//        button.setOnClickListener(view -> {
//            Intent replyIntent = new Intent();
//            if (TextUtils.isEmpty(etNombre.getText()) ||
//                    TextUtils.isEmpty(etApellidos.getText()) ||
//                    TextUtils.isEmpty(etTelefono.getText()) ||
//                    TextUtils.isEmpty(etDireccion.getText())  ||
//                    TextUtils.isEmpty(etNumero.getText())||
//                    TextUtils.isEmpty(etLocalidad.getText())||
//                    TextUtils.isEmpty(etFech_nac.getText()) ) {
//                setResult(RESULT_CANCELED, replyIntent);
//            }else {
//                String nombre = etNombre.getText().toString();
//                String apellidos = etApellidos.getText().toString();
//                String telefono = etTelefono.getText().toString();
//                String direccion = etDireccion.getText().toString();
//                String numero = etNumero.getText().toString();
//                String localidad = etLocalidad.getText().toString();
//                String fecha_nacimiento = etFech_nac.getText().toString();
//                replyIntent.putExtra(EXTRA_REPLY_NOMBRE2, nombre);
//                replyIntent.putExtra(EXTRA_REPLY_APELLIDOS2, apellidos);
//                replyIntent.putExtra(EXTRA_REPLY_TELEFONO2, telefono);
//                replyIntent.putExtra(EXTRA_REPLY_CALLE2, direccion);
//                replyIntent.putExtra(EXTRA_REPLY_NUMERO2, numero);
//                replyIntent.putExtra(EXTRA_REPLY_LOCALIDAD2, localidad);
//                replyIntent.putExtra(EXTRA_REPLY_FECHA_NACIMIENTO2, fecha_nacimiento);
//
//                setResult(RESULT_OK, replyIntent);
//            }
//            finish();
//        });
//    }
//}

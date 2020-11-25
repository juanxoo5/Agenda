package com.example.agenda.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacto")
public class Contacto {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @NonNull
    @ColumnInfo(name = "nombre")
    private String nombre;

    @NonNull
    @ColumnInfo(name = "apellidos")
    private String apellidos;

    @NonNull
    @ColumnInfo(name = "telefono")
    private long telefono;

    @NonNull
    @ColumnInfo(name = "fecha_nacimiento")
    private String fecha_nacimiento;

    @NonNull
    @ColumnInfo(name = "localidad")
    private String localidad;

    @NonNull
    @ColumnInfo(name = "calle")
    private String calle;

    @NonNull
    @ColumnInfo(name = "numero")
    private int numero;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    @NonNull
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(@NonNull String apellidos) {
        this.apellidos = apellidos;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    @NonNull
    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(@NonNull String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    @NonNull
    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(@NonNull String localidad) {
        this.localidad = localidad;
    }

    @NonNull
    public String getCalle() {
        return calle;
    }

    public void setCalle(@NonNull String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono=" + telefono +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", localidad='" + localidad + '\'' +
                ", calle='" + calle + '\'' +
                ", numero=" + numero +
                '}';
    }
}

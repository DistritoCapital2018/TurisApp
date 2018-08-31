package com.example.worldskills.turisapp.modelo;

public class LugaresModelo {

    private int id;
    private String nombre;
    private String descripcion;
    private String ubicacion;
    private int foto;
    private float latitud;
    private float longitud;
    private String nombreDetalle;
    private String ubicacionDetalle;

    public LugaresModelo() {
    }

    public LugaresModelo(int id, String nombre, String descripcion, String ubicacion, int foto, float latitud, float longitud, String nombreDetalle, String ubicacionDetalle) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.foto = foto;
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombreDetalle = nombreDetalle;
        this.ubicacionDetalle = ubicacionDetalle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public String getNombreDetalle() {
        return nombreDetalle;
    }

    public void setNombreDetalle(String nombreDetalle) {
        this.nombreDetalle = nombreDetalle;
    }

    public String getUbicacionDetalle() {
        return ubicacionDetalle;
    }

    public void setUbicacionDetalle(String ubicacionDetalle) {
        this.ubicacionDetalle = ubicacionDetalle;
    }
}

package com.gashe.turecadero;

import java.util.Date;

/**
 * Created by Gashe on 2/4/17.
 */

public class Recado {

    private Date fecha_hora;
    private String nombre_cliente;
    private String telefono;
    private String direccion_recogida;
    private String descripcion;
    private Date fecha_hora_maxima;
    private boolean realidazo;

    public Recado(Date fecha_hora, String nombre_cliente, String telefono, String direccion_recogida, String descripcion, Date fecha_hora_maxima) {
        this.fecha_hora = fecha_hora;
        this.nombre_cliente = nombre_cliente;
        this.telefono = telefono;
        this.direccion_recogida = direccion_recogida;
        this.descripcion = descripcion;
        this.fecha_hora_maxima = fecha_hora_maxima;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion_recogida() {
        return direccion_recogida;
    }

    public void setDireccion_recogida(String direccion_recogida) {
        this.direccion_recogida = direccion_recogida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_hora_maxima() {
        return fecha_hora_maxima;
    }

    public void setFecha_hora_maxima(Date fecha_hora_maxima) {
        this.fecha_hora_maxima = fecha_hora_maxima;
    }

    public boolean isRealidazo() {
        return realidazo;
    }

    public void setRealidazo(boolean realidazo) {
        this.realidazo = realidazo;
    }
}
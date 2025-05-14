package com.alumnos.j2ee.model;

public class Hamburguesa {
    private String nombre;
    private double precio;

    public Hamburguesa(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
}

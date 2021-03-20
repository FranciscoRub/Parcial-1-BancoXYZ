package com.company;

public class Transacciones {


    private double montocl1;
    private double montocl2;
    private double maximoprestamo;




    //Atributos
    String Client1;
    String Client2;
    //cantidad que pide el cliente
    private double cantidadprestada;
    //comision del banco
    private double comision;
    //realizacion del prestamo
    private double prestamo;

    public Transacciones(double cantidadprestada){
        this.cantidadprestada = cantidadprestada;
    }

    public double getCantidadprestada() {
        return cantidadprestada;
    }
//calculos del prestamo
    public double getPrestamo() {
        return cantidadprestada;
    }
    public double getComision(){
        return cantidadprestada * 30 /100;
    }
}

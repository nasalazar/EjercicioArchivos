/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.archivos;

/**
 *
 * @author NATHALY
 * @author Cristian
 * Clase que contiene el prestamo
 */
public class Record {
    /**
     * Variable que recibe el nit de una empresa
     */
    private int codigo;
    /**
     * Variable que recibe el nobre de una empresa
     */
    private String empresa;
    /**
     * Variable que recibe el estado de una deuda pagada/deudora
     */
    private int estado;
    /**
     * Variable que recibe el monto del prestamo
     */
    private double valor;
    /**
     * Constructor de la clase
     * @param codigo nit de la empresa
     * @param empresa nombre de la empresa
     * @param estado estado en deuda o pagada
     * @param valor monto del prestamo
     */
    public Record(int codigo, String empresa, int estado, double valor) {
        this.codigo = codigo;
        this.empresa = empresa;
        this.estado = estado;
        this.valor = valor;
    }
    /**
     * Constructor vacio
     */
    public Record() {
    }
    /**
     * get de nit empresa
     * @return entero
     */
    public int getCodigo() {
        return codigo;
    }
    /**
     * set de nit empresa
     * @param codigo 
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    /**
     * get de nombre empresa
     * @return String
     */
    public String getEmpresa() {
        return empresa;
    }
    /**
     * set de nombre empresa
     * @param empresa 
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    /**
     * get del estado de prestamo
     * @return entero
     */
    public int getEstado() {
        return estado;
    }
    /**
     * set del estado de prestamo
     * @param estado 
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }
    /**
     * get del monto de prestado
     * @return double
     */
    public double getValor() {
        return valor;
    }
    /**
     * set del monto de prestamo
     * @param valor 
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
    
}

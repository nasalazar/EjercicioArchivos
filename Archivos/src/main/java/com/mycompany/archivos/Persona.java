/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.archivos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NATHALY
 * @author Cristian
 * Clase que contiene la persona del prestamo
 */
public class Persona implements Serializable{
    /**
     * variable que guarda la cedula del usuario
     */
    private int cedula;
    /**
     * variable que guarda el nombre del usuario
     */
    private String nombre;
    /**
     * variable que guarda el apellido del usuario
     */
    private String apellido;
    /**
     * Objeto Record que contiene el prestamo del usuario
     */
    private Record record = new Record();
    /**
     * Lista que contiene las personas con prestamos
     */
    private static List<Persona> listaPersona = new ArrayList();
    /**
     * Constructor de personas
     * @param cedula documento persona
     * @param nombre nombre persona
     * @param apellido apellido persona
     * @param record Prestamo de la persona
     */
    public Persona(int cedula, String nombre, String apellido, Record record) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.record = record;
    }
    /**
     * Constructor vacio
     */
    public Persona() {
    }
    /**
     * get del documento usuario
     * @return entero
     */
    public int getCedula() {
        return cedula;
    }
    /**
     * set del documento usuario
     * @param cedula 
     */
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    /**
     * get del nombre persona
     * @return String
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * set del nombre de la persona
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * get apellido de la persona
     * @return String
     */
    public String getApellido() {
        return apellido;
    }
    /**
     * set del apellido de la persona
     * @param apellido 
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    /**
     * get del prestamo
     * @return Record
     */
    public Record getRecord() {
        return record;
    }
    /**
     * set del prestamo
     * @param record 
     */
    public void setRecord(Record record) {
        this.record = record;
    }

    /**
     * get de la lista de personas
     * @return Lista
     */

    public List<Persona> getListaPersona() {
        return listaPersona;
    }
    /**
     * set de la lista de personas
     * @param listaPersona 
     */
    public void setListaPersona(List<Persona> listaPersona) {
        Persona.listaPersona = listaPersona;
    }
    
    
    
}

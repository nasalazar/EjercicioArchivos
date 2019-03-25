
package com.mycompany.archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author NATHALY
 * @author Cristian
 * Clase que contiene las operaciones
 */
public class Principal{
    static Persona persona;
    static List<Record> listaEAux = new ArrayList();
    static List<Persona> listaPAux = new ArrayList();
    /**
     * Agrega usuarios por defecto
     */
    public void agregaPersona(){
        Record r1 = new Record(1,"Bavaria",1,60000000);
        Record r2 = new Record(2,"Colgate",2,30000000);
        Record r3 = new Record(3,"Domino's pizza",2,200);
        Record r4 = new Record(4,"Empanadas del valle",1,130000);
        Record r5 = new Record(5,"Fenalco",2,93000000);
        listaEAux.add(r1);
        listaEAux.add(r2);
        listaEAux.add(r3);
        listaEAux.add(r4);
        listaEAux.add(r5);
        
        Persona p1 = new Persona(1,"Andres","Calamaro",new Record(1,"Bavaria",1,60000000));
        Persona p2 = new Persona(2,"Briseida","Duarte",new Record(2,"Colgate",2,30000000));
        Persona p3 = new Persona(3,"Carlos","Erreño",new Record(3,"Domino's pizza",2,200));
        Persona p4 = new Persona(4,"Daniel","Forero",new Record(4,"Empanadas del valle",1,130000));
        Persona p5 = new Persona(5,"Fabiola","Gaitan",new Record(5,"Fenalco",2,93000000));
        
        listaPAux.add(p1);
        listaPAux.add(p2);
        listaPAux.add(p3);
        listaPAux.add(p4);
        listaPAux.add(p5);
        EscrituraArchivos(listaPAux);
    }
    /**
     * Lee el archivo
     */
    public void lecturadeArchivo(){
        String fileName = "Archivo_lectura/doc.txt";
        String line = null;
        try {
            FileReader fileReader = 
                new FileReader(fileName);
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }   
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "No se puede abrir el archivo: '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
        }
    }
    /**
     * Escribe el archivo
     * @param lista 
     */
    public void EscrituraArchivos(List<Persona> lista){
        String fileName = "Archivo_lectura/doc.txt";
        try {
            FileWriter fileWriter =
                new FileWriter(fileName,true);
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
            for(Persona ps:lista){
                bufferedWriter.write("~"+ps.getCedula()+","+ps.getNombre()+","+ps.getApellido()+"*"+ps.getRecord().getEmpresa()+","+ps.getRecord().getEstado()+","+ps.getRecord().getValor());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error al escribir en '"
                + fileName + "'");
        }
    }
    /**
     * Agrega un usuario manualmente
     */
    public void agregarNuevo(){
        System.out.println("");
        System.out.println("AGREGAR UNA PERSONA");
        Scanner sDoc = new Scanner(System.in);
        Scanner sNom = new Scanner(System.in);
        Scanner sApe = new Scanner(System.in);
        Scanner sNumEmp = new Scanner(System.in);
        Scanner sNomEmp = new Scanner(System.in);
        Scanner sEstadoDeuda = new Scanner(System.in);
        Scanner sValor = new Scanner(System.in);
        System.out.println("   documento: ");
        int documento = sDoc.nextInt();
        System.out.println("   Nombre del usuario: ");
        String nombrePersona = sNom.nextLine().toUpperCase();
        System.out.println("   Apellido del usuario: ");
        String apellidoPersona = sApe.nextLine().toUpperCase();
        System.out.println("   Nit empresa: ");
        int nit = sNumEmp.nextInt();
        System.out.println("   Nombre de empresa: ");
        String nombreEmpresa = sNomEmp.nextLine().toUpperCase();
        System.out.println("   Precio deuda/pago: ");
        double precio = (double)sValor.nextLong();
        boolean aux=false;
        while(aux!=true){
            try{
                System.out.println("   Estado de empresa:  negativo/positivo");
                String estado = sEstadoDeuda.nextLine().toUpperCase();
                if(estado.equals("NEGATIVO")){
                    List<Persona> listaSoporte = new ArrayList();
                    byte estadoDeuda = 2;
                    listaSoporte.add(new Persona(documento,nombrePersona,apellidoPersona,new Record(nit,nombreEmpresa,estadoDeuda,precio)));
                    EscrituraArchivos(listaSoporte);
                    aux=true;
                }else{
                    System.out.println("Solo digite lo solicitado");            
                }
                if(estado.equals("Solo digite lo solicitado")){
                    List<Persona> listaSoporte = new ArrayList();
                    byte estadoDeuda = 1;
                    listaSoporte.add(new Persona(documento,nombrePersona,apellidoPersona,new Record(nit,nombreEmpresa,estadoDeuda,precio)));
                    EscrituraArchivos(listaSoporte);
                    aux=true;
                }
        }catch(InputMismatchException e){System.out.println("Solo digite lo solicitado, intentelo de nuevo");}
        }
    }
    /**
     * menu principal de la aplicacion
     */
    public void menu(){
        lecturadeArchivo();
        agregaPersona();
        int opcion = 100;
        while(opcion!=3){
            Scanner scanI = new Scanner(System.in);
            System.out.println("");
            System.out.println("                  MENU PRINCIPAL");
            System.out.println("-------------------------------------------------");
            System.out.println("1. - AGREGAR USUARIO A DATACREDITO");
            System.out.println("2. - ELIMINAR CREDITO DE USUARIO");
            opcion = scanI.nextInt();
            switch(opcion){
                case 1:
                    agregarNuevo();
                    break;
                case 2:
                    eliminarHistoria();
                    break;
                case 3:
                    break;
            }
        }
    }
    /**
     * Elimina la historia negativa de los usuario
     */
    public void eliminarHistoria(){
        System.out.println("");
        System.out.println("            ELIMINACION DE UN USUARIO");
        boolean bucle=false;
//        while(bucle!=true){
//            try{
//                List<Persona> listaAuxPersona = new ArrayList();
//                Scanner scan = new Scanner(System.in);
//                int op = scan.nextInt();
//                if(op==1){
//                    String fileName = "Archivo_lectura/doc.txt";
//                    String line = null;
//                    try {
//                        String recepcion[],objPersona[],objRecord[];
//                        FileReader fileReader = 
//                            new FileReader(fileName);
//                        BufferedReader bufferedReader = 
//                            new BufferedReader(fileReader);
//                        while((line = bufferedReader.readLine()) != null) {
//                            //System.out.println(line);
//                            recepcion = (String[])line.split("~");
//                            for (int i = 0; i < recepcion.length; i++) {
//                                String medio = recepcion[i];
//                                objPersona = medio.split("*");
//                                for(int j=0; j<objPersona.length; j++){
//                                    String medio2 = objPersona[j];
//                                    objRecord = medio2.split(",");
//                                    listaAuxPersona.add(new Persona(medio2[0],medio2[1],medio2[2],new Record(medio2[3], medio2[4], medio2[5],medio[6])));
//                                }
//                                
//                                
//                            }
//                        }   
//                        bufferedReader.close();         
//                    }
//                    catch(FileNotFoundException ex) {
//                    System.out.println("No se puede abrir el archivo: '" + fileName + "'");                
//                }
//                catch(IOException ex) {
//                    System.out.println("Error reading file '" + fileName + "'");}
//                }   
//            }catch(InputMismatchException e){System.out.println("Solo 1 o 2 por favor");}
//        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaAsistencia;


/**
 *
 * @author mycomputer
 */
public class Empleado {
    
    public int idEmpleado;
    public String nombreEmpleado;
    public String calle;
    public int numero;
    public String colonia;
    public String codigoPostal;
    public String ciudad;
    public String estado;
    public int edad;
    public String puesto;
    public String fechaIngreso;
    public int sueldo;
    
    public Empleado(int idEmpleado,String nombre,String calle,int numero,String colonia,String codigoPostal,String ciudad,String estado,int edad,String puesto, String fechaIngreso, int sueldo){
        this.idEmpleado=idEmpleado;
        this.nombreEmpleado=nombre;
        this.calle=calle;
        this.numero=numero;
        this.colonia=colonia;
        this.codigoPostal=codigoPostal;
        this.ciudad=ciudad;
        this.estado=estado;
        this.edad=edad;
        this.puesto=puesto;
        this.fechaIngreso=fechaIngreso;
        this.sueldo=sueldo;
    }

    Empleado(String nombreEmpleado, int idEmpleado) {
        this.nombreEmpleado=nombreEmpleado;
        this.idEmpleado=idEmpleado;
    }
    
    Empleado(String nombreEmpleado){
        this.nombreEmpleado=nombreEmpleado;
    }
    
    public int getIdEmpleado(){
        return idEmpleado;
    }
    
    public void setIdEmpleado(int idEmpleado){
        this.idEmpleado = idEmpleado;
    }
    
    public String getNombreEmpleado(){
        return nombreEmpleado;
    }
    
    public void setNombreEmpleado(String nombreEmpleado){
        this.nombreEmpleado = nombreEmpleado;
    }
    
    public String getCalle(){
        return calle;
    }
    
    public void setCalle(String calle){
        this.calle = calle;
    }
     
    public int getNumero(){
        return numero;
    }
    
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public String getColonia(){
        return colonia;
    }
    
    public void setColonia(String colonia){
        this.colonia = colonia;
    }
    
    public String getCodigoPostal(){
        return codigoPostal;
    }
    
    public void setcodigoPostal(String codigoPostal){
        this.codigoPostal = codigoPostal;
    }
    
    public String getCiudad(){
        return ciudad;
    }
    
    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }
    
    public String getEstado(){
        return estado;
    }
    
    public void setEstado(String estado){
        this.estado = estado;
    }
    public int getEdad(){
        return edad;
    }
    
    public void setEdad(int edad){
        this.edad = edad;
    }
    public String getPuesto(){
        return puesto;
    }
    
    public void setPuesto(String puesto){
        this.puesto = puesto;
    }
    
    public String getFechaIngreso(){
        return fechaIngreso;
    }
    
    public void setFechaIngreso(String fechaIngreso){
        this.fechaIngreso = fechaIngreso;
    }
    
    @Override
    public String toString(){
        return nombreEmpleado;
    }
    
}

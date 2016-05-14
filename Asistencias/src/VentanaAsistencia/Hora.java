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
class Hora {
    public int idEntrada;
    public int empleado_idEmpleado;
    public String horaEntrada;
    public String diaEntrada;
    public String fechaDays;
    public String retardo;
    public String falta;
    
    public Hora(int idEntrada, int empleado_idEmpleado, String horaEntrada, String diaEntrada, String fechaDays, String retardo, String falta){
        this.idEntrada=idEntrada;
        this.empleado_idEmpleado=empleado_idEmpleado;
        this.horaEntrada=horaEntrada;
        this.diaEntrada=diaEntrada;
        this.fechaDays=fechaDays;
        this.retardo=retardo;
        this.falta=falta;
    }

    Hora(String diaEntrada, String fechaDays, int idEntrada, int empleado_idEmpleado) {
        this.diaEntrada=diaEntrada;
        this.fechaDays=fechaDays;
        this.idEntrada=idEntrada;
        this.empleado_idEmpleado=empleado_idEmpleado;
    }
    
    Hora(String fechaDays) {
        this.fechaDays=fechaDays;
    }
    
    public int getIdEntrada(){
        return idEntrada;
    }
    
    public void setIdEntrada(int idEntrada){
        this.idEntrada = idEntrada;
    }
    
    public int getEmpleado_IdEmpleado(){
        return empleado_idEmpleado;
    }
    
    public void setEmpleado_idEmpleado(int empleado_idEmpleado){
        this.empleado_idEmpleado = empleado_idEmpleado;
    }
    
    public String getHoraEntrada(){
        return horaEntrada;
    }
    
    public void setHoraEntrada(String horaEntrada){
        this.horaEntrada = horaEntrada;
    }
    
    public String getDiaEntrada(){
        return diaEntrada;
    }
    
    public void setDiaEntrada(String diaEntrada){
        this.diaEntrada = diaEntrada;
    }
    
    public String getFechaDays(){
        return fechaDays;
    }
    
    public void setFechaDays(String fechaDays){
        this.fechaDays = fechaDays;
    }
    
    public String getRetardo(){
        return retardo;
    }
    
    public void setRetardo(String retardo){
        this.retardo = retardo;
    }
    
    public String getFalta(){
        return falta;
    }
    
    public void setFalta(String falta){
        this.falta = falta;
    }
    
    @Override
    public String toString(){
        return fechaDays;
    }
    
}

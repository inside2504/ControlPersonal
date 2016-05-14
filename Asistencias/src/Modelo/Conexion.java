/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mycomputer
 */
public class Conexion {
    private static final String servidor = "jdbc:mysql://localhost/asistencia"; //Ruta a la base de datos
    private static final String user = "root"; //usuario
    private static final String pass="Inside09";//Clave para SQL
    private static final String driver="com.mysql.jdbc.Driver";
    
    private static Connection conexion;
    
    
    
    public Conexion(){
        
        try{
           Class.forName(driver);//Levanto el driver
           conexion=DriverManager.getConnection(servidor,user,pass);
           System.out.println("Conexión realizada con éxito");
        }catch(ClassNotFoundException | SQLException e){
            //TODO Auto-generated catch block
            System.out.println("Conexión fallida");
        }
    }
    
    public Connection getConnection(){
        return conexion;
    }
    
    public ResultSet SeleccionarEmpleados(){
        Modelo.Conexion cc=new Modelo.Conexion();
        Connection cn= cc.getConnection();
        Statement st;
        ResultSet rs= null;
        try{
            st = cn.createStatement();
            rs = st.executeQuery("select * from entrada");
        } catch(SQLException ex){
            Logger.getLogger(Modelo.Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public void ConsultaNombre(String nombre, JTable tabla){     
        String consulta = "select * from (entrada INNER JOIN salida on entrada.empleado_idEmpleado = salida.empleado_idEmpleado) INNER JOIN empleado on entrada.empleado_idEmpleado = empleado.idEmpleado where nombreEmpleado = '"+nombre+"' ";
    
        String[] columNames = {"Nombre","Día","Fecha","Retardo","Falta"};
        String[] datos = new String[7];
        DefaultTableModel dato = new DefaultTableModel(null,columNames);
        tabla.setRowHeight(30);
        tabla.setModel(dato);
        tabla.getColumnModel().getColumn(0).setMaxWidth(180);
        tabla.getColumnModel().getColumn(0).setMinWidth(180);
        tabla.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(180);
        tabla.getTableHeader().getColumnModel().getColumn(0).setMinWidth(180);
        tabla.getColumnModel().getColumn(1).setMaxWidth(80);
        tabla.getColumnModel().getColumn(1).setMinWidth(80);
        tabla.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(80);
        tabla.getTableHeader().getColumnModel().getColumn(1).setMinWidth(80);
        tabla.getColumnModel().getColumn(2).setMaxWidth(150);
        tabla.getColumnModel().getColumn(2).setMinWidth(150);
        tabla.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(150);
        tabla.getTableHeader().getColumnModel().getColumn(2).setMinWidth(150);
        
        //realizamos la consulta sql y llenamos los datos en la matriz "Object"
        try{
           PreparedStatement pstm = conexion.prepareStatement(consulta);
           ResultSet res = pstm.executeQuery();
           
           while(res.next()){            
              datos[0] = res.getString( "nombreEmpleado" );
              datos[1] = res.getString( "diaEntrada" );
              datos[2] = res.getString( "entrada.fechaDays" );
              datos[3] = res.getString( "retardo" );
              datos[4] = res.getString( "falta" );
              
              dato.addRow(datos);
           }
           tabla.setModel(dato);
           res.close();
            }catch(SQLException e){
                 System.out.println(e);
          }
    }
    
    public void ConsultaFechaEntrada(String fechaEntrada, JTable tabla){     
        String consulta = "select * from entrada INNER JOIN empleado on entrada.empleado_idEmpleado = empleado.idEmpleado where entrada.fechaDays = '"+fechaEntrada+"' ";
    
        String[] columNames = {"Nombre","Día","Fecha","Hora","Retardo","Falta"};
        String[] datos = new String[7];
        DefaultTableModel dato = new DefaultTableModel(null,columNames);
        tabla.setRowHeight(30);
        tabla.setModel(dato);
        tabla.getColumnModel().getColumn(0).setMaxWidth(180);
        tabla.getColumnModel().getColumn(0).setMinWidth(180);
        tabla.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(180);
        tabla.getTableHeader().getColumnModel().getColumn(0).setMinWidth(180);
        tabla.getColumnModel().getColumn(1).setMaxWidth(70);
        tabla.getColumnModel().getColumn(1).setMinWidth(70);
        tabla.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(70);
        tabla.getTableHeader().getColumnModel().getColumn(1).setMinWidth(70);
        tabla.getColumnModel().getColumn(2).setMaxWidth(120);
        tabla.getColumnModel().getColumn(2).setMinWidth(120);
        tabla.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(120);
        tabla.getTableHeader().getColumnModel().getColumn(2).setMinWidth(120);
        tabla.getColumnModel().getColumn(3).setMaxWidth(70);
        tabla.getColumnModel().getColumn(3).setMinWidth(70);
        tabla.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(70);
        tabla.getTableHeader().getColumnModel().getColumn(3).setMinWidth(70);
        
        //realizamos la consulta sql y llenamos los datos en la matriz "Object"
        try{
           PreparedStatement pstm = conexion.prepareStatement(consulta);
           ResultSet res = pstm.executeQuery();
           
           while(res.next()){            
              datos[0] = res.getString( "nombreEmpleado" );
              datos[1] = res.getString( "diaEntrada" );
              datos[2] = res.getString( "entrada.fechaDays" );
              datos[3] = res.getString( "horaEntrada" );
              datos[4] = res.getString( "retardo" );
              datos[5] = res.getString( "falta" );
              
              dato.addRow(datos);
           }
           tabla.setModel(dato);
           res.close();
            }catch(SQLException e){
                 System.out.println(e);
          }
    }
    
    public void ConsultaFechaSalida(String fechaSalida, JTable tabla){     
        String consulta = "select * from salida INNER JOIN empleado on salida.empleado_idEmpleado = empleado.idEmpleado where salida.fechaDays = '"+fechaSalida+"' ";
    
        String[] columNames = {"Nombre","Día","Fecha","Hora"};
        String[] datos = new String[4];
        DefaultTableModel dato = new DefaultTableModel(null,columNames);
        tabla.setRowHeight(30);
        tabla.setModel(dato);
        tabla.getColumnModel().getColumn(0).setMaxWidth(200);
        tabla.getColumnModel().getColumn(0).setMinWidth(200);
        tabla.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(200);
        tabla.getTableHeader().getColumnModel().getColumn(0).setMinWidth(200);
        tabla.getColumnModel().getColumn(1).setMaxWidth(70);
        tabla.getColumnModel().getColumn(1).setMinWidth(70);
        tabla.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(100);
        tabla.getTableHeader().getColumnModel().getColumn(1).setMinWidth(100);
        tabla.getColumnModel().getColumn(2).setMaxWidth(120);
        tabla.getColumnModel().getColumn(2).setMinWidth(120);
        tabla.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(120);
        tabla.getTableHeader().getColumnModel().getColumn(2).setMinWidth(120);
        
        //realizamos la consulta sql y llenamos los datos en la matriz "Object"
        try{
           PreparedStatement pstm = conexion.prepareStatement(consulta);
           ResultSet res = pstm.executeQuery();
           
           while(res.next()){            
              datos[0] = res.getString( "nombreEmpleado" );
              datos[1] = res.getString( "diaSalida" );
              datos[2] = res.getString( "salida.fechaDays" );
              datos[3] = res.getString( "horaSalida" );
              
              dato.addRow(datos);
           }
           tabla.setModel(dato);
           res.close();
            }catch(SQLException e){
                 System.out.println(e);
          }
    }
    
    public Object[][] SelectNomina(){
       int registros = 0;      
        String consulta = "select * from (nomina INNER JOIN empleado on nomina.empleado_idEmpleado = empleado.idEmpleado)";
        String consulta2 = "Select count(*) as total from (nomina INNER JOIN empleado on nomina.empleado_idEmpleado = empleado.idEmpleado)";
        //obtenemos la cantidad de registros existentes en la tabla
        try{
           PreparedStatement pstm = conexion.prepareStatement( consulta2 );
           ResultSet res = pstm.executeQuery();
           res.next();
           registros = res.getInt("total");
           res.close();
        }catch(SQLException e){
           System.out.println(e);
        }
      //se crea una matriz con tantas filas y columnas que necesite
      Object[][] datos = new String[registros][2];
      //realizamos la consulta sql y llenamos los datos en la matriz "Object"
        try{
           PreparedStatement pstm = conexion.prepareStatement(consulta);
           ResultSet res = pstm.executeQuery();
           int i = 0;
           while(res.next()){            
              datos[i][0] = res.getString( "nombreEmpleado" );
              datos[i][1] = res.getString( "sueldoNeto" );
              i++;
           }
           res.close();
            }catch(SQLException e){
                 System.out.println(e);
          }
      return datos;
    }
    
    public Object[][] SelectHora(){
       int registros = 0;      
        String consulta = "select * from (entrada INNER JOIN salida on entrada.empleado_idEmpleado = salida.empleado_idEmpleado) INNER JOIN empleado on entrada.empleado_idEmpleado = empleado.idEmpleado";
        String consulta2 = "Select count(*) as total from (entrada INNER JOIN salida on entrada.empleado_idEmpleado = salida.empleado_idEmpleado) INNER JOIN empleado on entrada.empleado_idEmpleado = empleado.idEmpleado";
        //obtenemos la cantidad de registros existentes en la tabla
        try{
           PreparedStatement pstm = conexion.prepareStatement( consulta2 );
           ResultSet res = pstm.executeQuery();
           res.next();
           registros = res.getInt("total");
           res.close();
        }catch(SQLException e){
           System.out.println(e);
        }
      //se crea una matriz con tantas filas y columnas que necesite
      Object[][] datos = new String[registros][7];
      //realizamos la consulta sql y llenamos los datos en la matriz "Object"
        try{
           PreparedStatement pstm = conexion.prepareStatement(consulta);
           ResultSet res = pstm.executeQuery();
           int i = 0;
           while(res.next()){            
              datos[i][0] = res.getString( "nombreEmpleado" );
              datos[i][1] = res.getString( "diaEntrada" );
              datos[i][2] = res.getString( "entrada.fechaDays" );
              datos[i][3] = res.getString( "horaEntrada" );
              datos[i][4] = res.getString( "horaSalida" );
              datos[i][5] = res.getString( "retardo" );
              datos[i][6] = res.getString( "falta" );
              i++;
           }
           res.close();
            }catch(SQLException e){
                 System.out.println(e);
          }
      return datos;
    }
    
    public Object[][] SelectSalida(){
       int registros = 0;      
        String consulta = "select * from (salida INNER JOIN empleado on salida.empleado_idEmpleado = empleado.idEmpleado)";
        String consulta2 = "Select count(*) as total from (salida INNER JOIN empleado on salida.empleado_idEmpleado = empleado.idEmpleado)";
        //obtenemos la cantidad de registros existentes en la tabla
        try{
           PreparedStatement pstm = conexion.prepareStatement( consulta2 );
           ResultSet res = pstm.executeQuery();
           res.next();
           registros = res.getInt("total");
           res.close();
        }catch(SQLException e){
           System.out.println(e);
        }
      //se crea una matriz con tantas filas y columnas que necesite
      Object[][] datos = new String[registros][4];
      //realizamos la consulta sql y llenamos los datos en la matriz "Object"
        try{
           PreparedStatement pstm = conexion.prepareStatement(consulta);
           ResultSet res = pstm.executeQuery();
           int i = 0;
           while(res.next()){            
              datos[i][0] = res.getString( "nombreEmpleado" );
              datos[i][1] = res.getString( "diaSalida" );
              datos[i][2] = res.getString( "fechaDays" );
              datos[i][3] = res.getString( "horaSalida" );
              i++;
           }
           res.close();
            }catch(SQLException e){
                 System.out.println(e);
          }
      return datos;
    }
    
    public Object[][] SelectEntrada(){
       int registros = 0;      
        String consulta = "select * from (entrada INNER JOIN empleado on entrada.empleado_idEmpleado = empleado.idEmpleado)";
        String consulta2 = "Select count(*) as total from (entrada INNER JOIN empleado on entrada.empleado_idEmpleado = empleado.idEmpleado)";
        //obtenemos la cantidad de registros existentes en la tabla
        try{
           PreparedStatement pstm = conexion.prepareStatement( consulta2 );
           ResultSet res = pstm.executeQuery();
           res.next();
           registros = res.getInt("total");
           res.close();
        }catch(SQLException e){
           System.out.println(e);
        }
      //se crea una matriz con tantas filas y columnas que necesite
      Object[][] datos = new String[registros][6];
      //realizamos la consulta sql y llenamos los datos en la matriz "Object"
        try{
           PreparedStatement pstm = conexion.prepareStatement(consulta);
           ResultSet res = pstm.executeQuery();
           int i = 0;
           while(res.next()){            
              datos[i][0] = res.getString( "nombreEmpleado" );
              datos[i][1] = res.getString( "diaEntrada" );
              datos[i][2] = res.getString( "fechaDays" );
              datos[i][3] = res.getString( "horaEntrada" );
              datos[i][4] = res.getString( "retardo" );
              datos[i][5] = res.getString( "falta" );
              i++;
           }
           res.close();
            }catch(SQLException e){
                 System.out.println(e);
          }
      return datos;
    }
    
    public Object[][] SelectEmpleado(){
     int registros = 0;      
      String consulta = "Select * FROM empleado ";
      String consulta2 = "Select count(*) as total from empleado ";
      //obtenemos la cantidad de registros existentes en la tabla
      try{
         PreparedStatement pstm = conexion.prepareStatement( consulta2 );
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }
    //se crea una matriz con tantas filas y columnas que necesite
    Object[][] data = new String[registros][12];
    //realizamos la consulta sql y llenamos los datos en la matriz "Object"
      try{
         PreparedStatement pstm = conexion.prepareStatement(consulta);
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){            
            data[i][0] = res.getString( "idEmpleado" );
            data[i][1] = res.getString( "nombreEmpleado" );
            data[i][2] = res.getString( "calleEmpleado" );
            data[i][3] = res.getString( "numeroEmpleado" );
            data[i][4] = res.getString( "coloniaEmpleado" );
            data[i][5] = res.getString( "codigoPostal" );
            data[i][6] = res.getString( "ciudadEmpleado" );
            data[i][7] = res.getString( "estadoEmpleado" );
            data[i][8] = res.getString( "edadEmpleado" );
            data[i][9] = res.getString( "puestoEmpleado" );
            data[i][10] = res.getString( "fechaIngreso" );
            data[i][11] = res.getString( "sueldoEmpleado" );
            i++;
         }
         res.close();
          }catch(SQLException e){
               System.out.println(e);
        }
    return data;
    }

/* Ejecuta la actualizacion de la tabla persona dado los valores de actualizacion
 * y el ID del registro a afectar
 */
    public boolean update(String valores, String id)
    {
        boolean res = false;        
        String q = " UPDATE empleado SET " + valores + " WHERE idEmpleado= " + id;
        try {
            PreparedStatement pstm = conexion.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaAsistencia;
import java.sql.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author mycomputer
 */
public class ConsultaEmpleado extends javax.swing.JFrame {
    Modelo.Conexion cc= new Modelo.Conexion();
    Connection conn = cc.getConnection();
    private Modelo.Conexion db = new Modelo.Conexion();
    private Object[][] dtcliente;
    Statement sent;
        
    /**
     * Creates new form VentanaPrincipal
     */
    public ConsultaEmpleado() {
        
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Empleados");
        ActualizarTabla();
        TablaEmpleado.setRowHeight(1, 30);
        TablaEmpleado.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaEmpleado.getColumnModel().getColumn(0).setMinWidth(0);
        TablaEmpleado.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        TablaEmpleado.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        TablaEmpleado.getColumnModel().getColumn(1).setMaxWidth(200);
        TablaEmpleado.getColumnModel().getColumn(1).setMinWidth(200);
        TablaEmpleado.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(200);
        TablaEmpleado.getTableHeader().getColumnModel().getColumn(1).setMinWidth(200);
        TablaEmpleado.getColumnModel().getColumn(2).setMaxWidth(125);
        TablaEmpleado.getColumnModel().getColumn(2).setMinWidth(125);
        TablaEmpleado.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(125);
        TablaEmpleado.getTableHeader().getColumnModel().getColumn(2).setMinWidth(125);
        TablaEmpleado.getColumnModel().getColumn(3).setMaxWidth(50);
        TablaEmpleado.getColumnModel().getColumn(3).setMinWidth(50);
        TablaEmpleado.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(50);
        TablaEmpleado.getTableHeader().getColumnModel().getColumn(3).setMinWidth(50);
        TablaEmpleado.getColumnModel().getColumn(4).setMaxWidth(100);
        TablaEmpleado.getColumnModel().getColumn(4).setMinWidth(100);
        TablaEmpleado.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(100);
        TablaEmpleado.getTableHeader().getColumnModel().getColumn(4).setMinWidth(100);
        TablaEmpleado.getColumnModel().getColumn(5).setMaxWidth(80);
        TablaEmpleado.getColumnModel().getColumn(5).setMinWidth(80);
        TablaEmpleado.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(80);
        TablaEmpleado.getTableHeader().getColumnModel().getColumn(5).setMinWidth(80);
        TablaEmpleado.getColumnModel().getColumn(6).setMaxWidth(70);
        TablaEmpleado.getColumnModel().getColumn(6).setMinWidth(70);
        TablaEmpleado.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(70);
        TablaEmpleado.getTableHeader().getColumnModel().getColumn(6).setMinWidth(70);
        TablaEmpleado.getColumnModel().getColumn(7).setMaxWidth(70);
        TablaEmpleado.getColumnModel().getColumn(7).setMinWidth(70);
        TablaEmpleado.getTableHeader().getColumnModel().getColumn(8).setMaxWidth(70);
        TablaEmpleado.getTableHeader().getColumnModel().getColumn(8).setMinWidth(70);
        TablaEmpleado.getColumnModel().getColumn(8).setMaxWidth(50);
        TablaEmpleado.getColumnModel().getColumn(8).setMinWidth(50);
        TablaEmpleado.getTableHeader().getColumnModel().getColumn(8).setMaxWidth(50);
        TablaEmpleado.getTableHeader().getColumnModel().getColumn(8).setMinWidth(50);
        TablaEmpleado.getColumnModel().getColumn(9).setMaxWidth(100);
        TablaEmpleado.getColumnModel().getColumn(9).setMinWidth(100);
        TablaEmpleado.getTableHeader().getColumnModel().getColumn(9).setMaxWidth(100);
        TablaEmpleado.getTableHeader().getColumnModel().getColumn(9).setMinWidth(100);
        TablaEmpleado.getColumnModel().getColumn(11).setMaxWidth(50);
        TablaEmpleado.getColumnModel().getColumn(11).setMinWidth(50);
        TablaEmpleado.getTableHeader().getColumnModel().getColumn(11).setMaxWidth(50);
        TablaEmpleado.getTableHeader().getColumnModel().getColumn(11).setMinWidth(50);
        //editor de celdas
        TablaEmpleado.getColumnModel().getColumn( 1 ).setCellEditor(new MyTableCellEditor(db,"nombreEmpleado"));//Columna nombre
       
        TablaEmpleado.getColumnModel().getColumn( 2 ).setCellEditor(new MyTableCellEditor(db,"calleEmpleado"));//Columna calle
        TablaEmpleado.getColumnModel().getColumn( 3 ).setCellEditor(new MyTableCellEditor(db,"numeroEmpleado"));//Columna numero
        TablaEmpleado.getColumnModel().getColumn( 4 ).setCellEditor(new MyTableCellEditor(db,"coloniaEmpleado"));//Columna colonia
        TablaEmpleado.getColumnModel().getColumn( 5 ).setCellEditor(new MyTableCellEditor(db,"codigoPostal"));//Columna codigo postal
        TablaEmpleado.getColumnModel().getColumn( 6 ).setCellEditor(new MyTableCellEditor(db,"ciudadEmpleado"));//Columna ciudad
        TablaEmpleado.getColumnModel().getColumn( 7 ).setCellEditor(new MyTableCellEditor(db,"estadoEmpleado"));//Columna estado
        TablaEmpleado.getColumnModel().getColumn( 8 ).setCellEditor(new MyTableCellEditor(db,"edadEmpleado"));//Columna edad
        TablaEmpleado.getColumnModel().getColumn( 9 ).setCellEditor(new MyTableCellEditor(db,"puestoEmpleado"));//Columna puesto
        TablaEmpleado.getColumnModel().getColumn( 10 ).setCellEditor(new MyTableCellEditor(db,"fechaIngreso"));//Columna fecha
        TablaEmpleado.getColumnModel().getColumn( 11 ).setCellEditor(new MyTableCellEditor(db,"sueldoEmpleado"));//Columna sueldo
        
    }
    
    private void ActualizarTabla(){
        //actualiza los datos de la tabla realizando una consulta a la base de datos
        String[] columNames = {"ID","Nombre","Calle","No","Col","C.P","Ciudad","Edo","Edad","Puesto","Ingreso","Sueldo"};        
        dtcliente = db.SelectEmpleado();
        // se colocan los datos en la tabla
        DefaultTableModel datos = new DefaultTableModel(dtcliente,columNames);
        TablaEmpleado.setRowHeight(30);
        TablaEmpleado.setModel(datos);
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEmpleado = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        menuInicio = new javax.swing.JMenu();
        verPrincipal = new javax.swing.JMenuItem();
        menuEmpleado = new javax.swing.JMenu();
        verEmpleado = new javax.swing.JMenuItem();
        menuHora = new javax.swing.JMenu();
        menuHoraEntrada = new javax.swing.JMenuItem();
        menuHoraSalida = new javax.swing.JMenuItem();
        consultaDia = new javax.swing.JMenuItem();
        Nómina = new javax.swing.JMenu();
        GenerarNomina = new javax.swing.JMenuItem();
        Consultar = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        generaReporteEmpleado = new javax.swing.JMenuItem();
        generaReporteHoras = new javax.swing.JMenuItem();
        generaReporteNomina = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TablaEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaEmpleado.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TablaEmpleado);

        btnEliminar.setText("Eliminar empleado");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar empleado");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Para editar la información de un empleado de clic en el dato que quiera editar.");

        menuInicio.setText("Inicio");
        menuInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInicioActionPerformed(evt);
            }
        });

        verPrincipal.setText("Ir a ventana de inicio");
        verPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verPrincipalActionPerformed(evt);
            }
        });
        menuInicio.add(verPrincipal);

        Menu.add(menuInicio);

        menuEmpleado.setText("Empleado");

        verEmpleado.setText("Ir a ventana de empleados");
        verEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verEmpleadoActionPerformed(evt);
            }
        });
        menuEmpleado.add(verEmpleado);

        Menu.add(menuEmpleado);

        menuHora.setText("Hora");

        menuHoraEntrada.setText("Registrar hora de entrada");
        menuHoraEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHoraEntradaActionPerformed(evt);
            }
        });
        menuHora.add(menuHoraEntrada);

        menuHoraSalida.setText("Registrar hora de salida");
        menuHoraSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHoraSalidaActionPerformed(evt);
            }
        });
        menuHora.add(menuHoraSalida);

        consultaDia.setText("Consultar horas por día");
        consultaDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaDiaActionPerformed(evt);
            }
        });
        menuHora.add(consultaDia);

        Menu.add(menuHora);

        Nómina.setText("Nómina");

        GenerarNomina.setText("Generar nómina");
        GenerarNomina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarNominaActionPerformed(evt);
            }
        });
        Nómina.add(GenerarNomina);

        Consultar.setText("Consultar nómina por empleado");
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });
        Nómina.add(Consultar);

        Menu.add(Nómina);

        jMenu1.setText("Reportes");

        generaReporteEmpleado.setText("Generar reporte de los empleados");
        generaReporteEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generaReporteEmpleadoActionPerformed(evt);
            }
        });
        jMenu1.add(generaReporteEmpleado);

        generaReporteHoras.setText("Generar reporte de horas de entrada y salida");
        generaReporteHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generaReporteHorasActionPerformed(evt);
            }
        });
        jMenu1.add(generaReporteHoras);

        generaReporteNomina.setText("Generar reporte de nómina");
        generaReporteNomina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generaReporteNominaActionPerformed(evt);
            }
        });
        jMenu1.add(generaReporteNomina);

        Menu.add(jMenu1);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(103, 103, 103)
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar)
                        .addGap(50, 50, 50)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnRegistrar)
                    .addComponent(jLabel1))
                .addContainerGap(142, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        VentanaAsistencia.AltaEmpleado obj=new VentanaAsistencia.AltaEmpleado();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try{
            int fila = TablaEmpleado.getSelectedRow();
            String sql = "delete from empleado where idEmpleado = " + TablaEmpleado.getValueAt(fila, 0);
            sent = conn.createStatement();
            int n = sent.executeUpdate(sql);
            if (n>0){
                JOptionPane.showMessageDialog(null, "Datos eliminados correctamente");
                VentanaAsistencia.ConsultaEmpleado obj=new VentanaAsistencia.ConsultaEmpleado();
                obj.setVisible(true);
                dispose();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar los datos" + e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void verPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verPrincipalActionPerformed
        // TODO add your handling code here:
        VentanaAsistencia.Principal obj = new VentanaAsistencia.Principal();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_verPrincipalActionPerformed

    private void menuInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuInicioActionPerformed

    private void menuHoraEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHoraEntradaActionPerformed
        // TODO add your handling code here:
        VentanaAsistencia.AltaHoraEntrada obj = new VentanaAsistencia.AltaHoraEntrada();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuHoraEntradaActionPerformed

    private void menuHoraSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHoraSalidaActionPerformed
        // TODO add your handling code here:
        VentanaAsistencia.AltaHoraSalida obj = new VentanaAsistencia.AltaHoraSalida();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuHoraSalidaActionPerformed

    private void consultaDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaDiaActionPerformed
        // TODO add your handling code here:
        VentanaAsistencia.HoraPorDia obj = new VentanaAsistencia.HoraPorDia();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_consultaDiaActionPerformed

    private void GenerarNominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarNominaActionPerformed
        // TODO add your handling code here:
        VentanaAsistencia.GeneraNomina obj = new VentanaAsistencia.GeneraNomina();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_GenerarNominaActionPerformed

    private void verEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verEmpleadoActionPerformed
        // TODO add your handling code here:
        VentanaAsistencia.ConsultaEmpleado obj = new VentanaAsistencia.ConsultaEmpleado();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_verEmpleadoActionPerformed

    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarActionPerformed
        // TODO add your handling code here:
        VentanaAsistencia.ConsultaNomina obj = new VentanaAsistencia.ConsultaNomina();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_ConsultarActionPerformed

    private void generaReporteEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generaReporteEmpleadoActionPerformed
        // TODO add your handling code here:
        Modelo.Conexion cc = new Modelo.Conexion();
        String path = "C://Users/mycomputer/Documents/NetBeansProjects/Asistencias/src/Reportes/reporteEmpleado.jasper";
        JasperReport jr = null;
        try {
            jr = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, cc.getConnection());
            JasperViewer jv = new JasperViewer(jp,false);
            jv.setVisible(true);
            jv.setTitle("Reporte de empleados");

        } catch (JRException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_generaReporteEmpleadoActionPerformed

    private void generaReporteHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generaReporteHorasActionPerformed
        // TODO add your handling code here:
        VentanaAsistencia.BuscarNombre obj = new VentanaAsistencia.BuscarNombre();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_generaReporteHorasActionPerformed

    private void generaReporteNominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generaReporteNominaActionPerformed
        // TODO add your handling code here:
        VentanaAsistencia.BuscarNomina obj = new VentanaAsistencia.BuscarNomina();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_generaReporteNominaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Consultar;
    private javax.swing.JMenuItem GenerarNomina;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenu Nómina;
    private javax.swing.JTable TablaEmpleado;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JMenuItem consultaDia;
    private javax.swing.JMenuItem generaReporteEmpleado;
    private javax.swing.JMenuItem generaReporteHoras;
    private javax.swing.JMenuItem generaReporteNomina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuEmpleado;
    private javax.swing.JMenu menuHora;
    private javax.swing.JMenuItem menuHoraEntrada;
    private javax.swing.JMenuItem menuHoraSalida;
    private javax.swing.JMenu menuInicio;
    private javax.swing.JMenuItem verEmpleado;
    private javax.swing.JMenuItem verPrincipal;
    // End of variables declaration//GEN-END:variables
}

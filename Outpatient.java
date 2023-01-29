package hospital_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Outpatient extends javax.swing.JFrame {

    private int p_id = 0;
    private int d_id = 0;
    private int p_age = 0;
    private int p_room = 0;
    private static Statement st;
    private static ResultSet rs;
    private static Connection con;
    private String p_name = null;
    private String p_gender = null;
    private String p_number = null;
    private String p_address = null;
    private static PreparedStatement stmt;
    private String p_admitdate = null;
    private String p_dischargedate = null;
    private static String tableName = "patient";
    DatabaseConnection dbcon = new DatabaseConnection();

    public Outpatient() {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        jButton1.setEnabled(false);
        con = dbcon.returnConnectionObject();
        stmt = dbcon.returnPreparedStatementObject();
    }

    private void returnTextFieldValues() {
        p_name = jTextField2.getText();
        d_id = Integer.parseInt(jTextField3.getText());
        p_id = Integer.parseInt(jTextField1.getText());
    }

    private void setAllTextFieldsToNull() {
        jTextField1.setText(" ");
        jTextField2.setText(" ");
        jTextField3.setText(" ");
    }

    private void copyPatientDataMiddlePhase() {
        try {
            rs = stmt.executeQuery("SELECT * FROM patient");
            while (rs.next()) {
                if (rs.getInt(1) == Integer.parseInt(jTextField1.getText()) && rs.getInt(2) == Integer.parseInt(jTextField3.getText())) {
                    p_id = rs.getInt(1);
                    d_id = rs.getInt(2);
                    p_name = rs.getString(3);
                    p_gender = rs.getString(4);
                    p_age = rs.getInt(5);
                    p_number = rs.getString(6);
                    p_address = rs.getString(7);
                    p_room = rs.getInt(8);
                    p_admitdate = rs.getString(9);
                    p_dischargedate = rs.getString(10);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Outpatient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void copyPatientDataForHistoryOfPatients() {
        copyPatientDataMiddlePhase();
        try {
            stmt = con.prepareStatement("INSERT INTO patienthistory (p_id,d_id,p_name,p_gender,p_age,p_number,p_address,p_room,p_admitdate,p_dischargedate) " + " VALUES (?,?,?,?,?,?,?,?,?,?) ");
            stmt.setInt(1, p_id);
            stmt.setInt(2, d_id);
            stmt.setInt(5, p_age);
            stmt.setInt(8, p_room);
            stmt.setString(3, p_name);
            stmt.setString(4, p_gender);
            stmt.setString(6, p_number);
            stmt.setString(7, p_address);
            stmt.setString(9, p_admitdate);
            stmt.setString(10, p_dischargedate);
            stmt.executeUpdate();
            //stmt.close();
            //con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Outpatient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void deleteDichargedPatientRecord() {
        try {
            stmt = con.prepareStatement("DELETE FROM " + tableName + " WHERE p_id = " + p_id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Outpatient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nasir Abbas Mangrio\\Documents\\NetBeansProjects\\Hospital_Management_System\\src\\Images\\hospital13.png")); // NOI18N
        jLabel3.setText("jLabel3");

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nasir Abbas Mangrio\\Documents\\NetBeansProjects\\Hospital_Management_System\\src\\Images\\hospital13.png")); // NOI18N
        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Patient's name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 131, 45));

        jLabel2.setBackground(new java.awt.Color(222, 222, 240));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Discharge Date");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 131, 37));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Doctor's ID");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 131, 33));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Patient's ID");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 59, 112, 33));

        jButton1.setBackground(new java.awt.Color(222, 222, 240));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Outpatient");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, 110, 60));

        jTextField1.setBackground(new java.awt.Color(222, 222, 240));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 150, 40));

        jTextField2.setBackground(new java.awt.Color(222, 222, 240));
        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 110, 150, 40));

        jTextField3.setBackground(new java.awt.Color(222, 222, 240));
        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 150, 40));

        jButton2.setBackground(new java.awt.Color(222, 222, 240));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Generate Bill");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, -1, 60));

        jButton3.setBackground(new java.awt.Color(222, 222, 240));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 110, 60));

        jDateChooser1.setDateFormatString(" yyyy, MM, dd");
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 150, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nasir Abbas Mangrio\\Documents\\NetBeansProjects\\Hospital_Management_System\\src\\Images\\hospital13.png")); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JOptionPane.showMessageDialog(null, "Bill is generated !:");
        jButton1.setEnabled(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new PatientWindow().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        p_dischargedate = dateFormat.format(jDateChooser1.getDate());
        try {
            returnTextFieldValues();
            String sql = "UPDATE patient SET p_dischargedate= '" + p_dischargedate + "' WHERE p_id= '" + p_id + "' AND d_id= '" + d_id + "'";
            stmt = con.prepareStatement(sql);
            stmt.execute();
            copyPatientDataForHistoryOfPatients();
            deleteDichargedPatientRecord();
            setAllTextFieldsToNull();
            stmt.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Patient is successfully discharged !:");
        } catch (SQLException ex) {
            Logger.getLogger(Outpatient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Outpatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}

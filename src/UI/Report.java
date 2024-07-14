/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author User
 */
public class Report extends javax.swing.JFrame {
String Cuser=null;
    /**
     * Creates new form Report
     */
    public Report(String usr) {
        initComponents();
        Selectproduct();
        Cuser=usr;
        ViewCustomer();
        ViewSupplier();
    }
    
    
    
    Connection con =null;
        PreparedStatement pst =null;
        ResultSet rs=null;
        Statement stmt =null;
        String rsm;
        
        
        
        
        
         public  void ViewSupplier()
        {
        
     try{
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/markcomputerdb","root", "");
      
         Statement ps = con.createStatement();
      rs =ps.executeQuery("Select * from supplier");
      VSuppliertable.setModel(DbUtils.resultSetToTableModel(rs));
     }catch(SQLException e){
     
     
     e.printStackTrace();
     
     }   
    
    }   

    private Report() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public  void Selectproduct()
        {
        
     try{
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/markcomputerdb","root", "");
         Statement ps = con.createStatement();
      rs =ps.executeQuery("Select * from manageproducts");
      ptable.setModel(DbUtils.resultSetToTableModel(rs));
     }catch(SQLException e){
     
     
     e.printStackTrace();
     
     }  
     
    }   
    
     public  void ViewCustomer()
        {
        
     try{
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/markcomputerdb","root", "");
      
         Statement ps = con.createStatement();
      rs =ps.executeQuery("Select * from customer");
      CustomerTa.setModel(DbUtils.resultSetToTableModel(rs));
     }catch(SQLException e){
     
     
     e.printStackTrace();
     
     } 
        }
     
     
     
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ptable = new javax.swing.JTable();
        Btnupdate2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CustomerTa = new javax.swing.JTable();
        Btnupdate3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        VSuppliertable = new javax.swing.JTable();
        Btnupdate4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setkEndColor(new java.awt.Color(138, 4, 4));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 0, 0));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Products List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 24), new java.awt.Color(204, 0, 0))); // NOI18N

        ptable.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ptable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Company", "Product ID", "Product Name", "Product Category", "Quantity", "Entry Date", "Bying Price", "Selling price"
            }
        ));
        ptable.setRowHeight(25);
        ptable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ptableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ptable);

        Btnupdate2.setBackground(new java.awt.Color(242, 242, 242));
        Btnupdate2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Btnupdate2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_print_40px.png"))); // NOI18N
        Btnupdate2.setText("Print");
        Btnupdate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btnupdate2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(Btnupdate2)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Btnupdate2))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Report Generation");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24), new java.awt.Color(204, 0, 0))); // NOI18N

        CustomerTa.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        CustomerTa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Customer ID", "NAME", "GENDER", "Contact Number"
            }
        ));
        CustomerTa.setRowHeight(25);
        CustomerTa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomerTaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(CustomerTa);

        Btnupdate3.setBackground(new java.awt.Color(242, 242, 242));
        Btnupdate3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Btnupdate3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_print_40px.png"))); // NOI18N
        Btnupdate3.setText("Print ");
        Btnupdate3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btnupdate3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(347, 347, 347)
                .addComponent(Btnupdate3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btnupdate3)
                .addGap(5, 5, 5))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "View Supplier", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24), new java.awt.Color(204, 0, 0))); // NOI18N

        VSuppliertable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        VSuppliertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Supplier ID", "Supplier Name", "Contact Number", "Company"
            }
        ));
        VSuppliertable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VSuppliertableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(VSuppliertable);

        Btnupdate4.setBackground(new java.awt.Color(242, 242, 242));
        Btnupdate4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Btnupdate4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_print_40px.png"))); // NOI18N
        Btnupdate4.setText("Print ");
        Btnupdate4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btnupdate4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(357, 357, 357)
                .addComponent(Btnupdate4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btnupdate4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(320, 320, 320)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_back_arrow_48px_3.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 204, 0));
        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_close_window_40px_7.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ptableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ptableMouseClicked

//        DefaultTableModel model=(DefaultTableModel)ptable.getModel();
//        int myindex =ptable.getSelectedRow();
//        CCompany.setSelectedItem(model.getValueAt(myindex,0).toString());
//        txtpid.setText(model.getValueAt(myindex,1).toString());
//        txtpname.setText(model.getValueAt(myindex,2).toString());
//        CCategory.setSelectedItem(model.getValueAt(myindex,3).toString());
//        txtquan.setText(model.getValueAt(myindex,4).toString());
//
//        String birth = ((JTextField)txtEnDate.getDateEditor().getUiComponent()).getText();
//        String valueAtColumn6 = model.getValueAt(myindex, 5).toString();
//        String result = birth + valueAtColumn6;
//        //txtEnDate.setDateFormatString(model.getValueAt(myindex,5).toString());
//
//        txtBprice.setText(model.getValueAt(myindex,6).toString());
//        txtSprice.setText(model.getValueAt(myindex,7).toString());

    }//GEN-LAST:event_ptableMouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        Home h =new Home(Cuser);
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void Btnupdate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btnupdate2ActionPerformed
         try {
            
            ptable.print();
          
        } catch (Exception e) {
        }
    }//GEN-LAST:event_Btnupdate2ActionPerformed

    private void CustomerTaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerTaMouseClicked
//        DefaultTableModel model=(DefaultTableModel)CustomerTa.getModel();
//        int myindex =CustomerTa.getSelectedRow();
//        txtid.setText(model.getValueAt(myindex,0).toString());
//        txtname.setText(model.getValueAt(myindex,1).toString());
//        cogender .setSelectedItem(model.getValueAt(myindex, 2).toString());
//        txtnumber.setText(model.getValueAt(myindex,3).toString());

    }//GEN-LAST:event_CustomerTaMouseClicked

    private void Btnupdate3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btnupdate3ActionPerformed
         try {
            
            CustomerTa.print();
          
        } catch (Exception e) {
        }
         
    }//GEN-LAST:event_Btnupdate3ActionPerformed

    private void VSuppliertableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VSuppliertableMouseClicked

//        DefaultTableModel model=(DefaultTableModel)VSuppliertable.getModel();
//        int myindex =VSuppliertable.getSelectedRow();
//        txtsid.setText(model.getValueAt(myindex,0).toString());
//        txtsname.setText(model.getValueAt(myindex,1).toString());
//        txtsnum.setText(model.getValueAt(myindex,2).toString());
//        txtscomp.setText(model.getValueAt(myindex,3).toString());
    }//GEN-LAST:event_VSuppliertableMouseClicked

    private void Btnupdate4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btnupdate4ActionPerformed
        try {
            
            VSuppliertable.print();
          
        } catch (Exception e) {
        }
         
    }//GEN-LAST:event_Btnupdate4ActionPerformed

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
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btnupdate2;
    private javax.swing.JButton Btnupdate3;
    private javax.swing.JButton Btnupdate4;
    private javax.swing.JTable CustomerTa;
    private javax.swing.JTable VSuppliertable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTable ptable;
    // End of variables declaration//GEN-END:variables

}

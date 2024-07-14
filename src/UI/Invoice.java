/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author MARSH
 */
public class Invoice extends javax.swing.JFrame {
String Cuser=null;
    /**
     * Creates new form Invoive
     */
    DefaultTableModel model;
    public Invoice(String usr) {
        initComponents();
        Viewdetails();
        Cuser=usr;
        Connect();
        ViewCustomer();
        Selectproduct();
        Cocategory();
      //  billHead();
        
        
        
    }

     Connection con =null;
        PreparedStatement pst =null;
        ResultSet rs=null;
        Statement stmt =null;
        String rsm;
        
         int Pquantity,pid,newQu ,oldPquantity;
         double sum =0;
         double balance=0;

    private Invoice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
         public void Connect() {
           DBConnection db = new DBConnection();
            db.getConnection();
            
    
    
         }
    
         
         
         
       ///////////////////////////////////////////////////////////////////////////////// combo 
         
            public void Cocategory() {
             
             try {
                 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/markcomputerdb","root", "");
                 Statement ps = con.createStatement();
                // String Query ="Select * from supplier";
                  rs =ps.executeQuery("Select * from category");
                 //rs =stmt.executeQuery(Query);
                 while(rs.next()){
                   String mycom =rs.getString("Category_Name");
                   CCategory.addItem(mycom);
                 
                 
                 }
           
                 
             } catch (Exception e) {
                 e.printStackTrace();
             }
      
         }
     ///////////////////////////////////////////////////////////////////////////////////Table    
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
    
    
    
  ////////////////////////////////////////////////////////////////////////////////////////////Table  
    
    
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
    
   ////////////////////////////////////////////Search
    
    public void Search(String Cus){
    
    model =(DefaultTableModel)CustomerTa.getModel();
        TableRowSorter<DefaultTableModel>trs =new TableRowSorter<>(model);
        CustomerTa.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(Cus));
    
    
    }
    public  void Viewdetails()
        {
        
     try{
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/markcomputerdb","root", "");
         Statement ps = con.createStatement();
      rs =ps.executeQuery("Select * from bill");
      Invoiceta.setModel(DbUtils.resultSetToTableModel(rs));
     }catch(SQLException e){
     
     
     e.printStackTrace();
     
       
     
    }   
       
    }
    
    public void updateQ(){
        
        
        newQu =Pquantity-Integer.valueOf(txtquan.getText());
   try{ 
      // Class.forName("com.mysql.cj.jdbc.Driver");
       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/markcomputerdb","root", "");
      String Query="update manageproducts set Quantity="+newQu+""+" where Product_ID="+pid;
      Statement Add=con.createStatement();
      Add.executeUpdate(Query);
      //JOptionPane.showMessageDialog(this, "invoice Details updated successfully");
      Selectproduct();


} 
        catch (SQLException ex) {
        ex.printStackTrace();
}
    
    
    
    
    
    
    }
    
    public  void billHead(){
    
    Billtxt.setText(Billtxt.getText() +"------------------------------------------------------------------------------------------\n");
        Billtxt.setText(Billtxt.getText() +"                                           MARK Computer                \n");
        Billtxt.setText(Billtxt.getText() +"                                     190/02 Kandy Road Yakkala          \n");
        Billtxt.setText(Billtxt.getText() +"                                       Mobile- 077-436664459            \n");
        Billtxt.setText(Billtxt.getText() +"                                  Email- markcomputer@gmail.com         \n");
        Billtxt.setText(Billtxt.getText() +"------------------------------------------------------------------------------------------\n");
        Billtxt.setText(Billtxt.getText() +"                                                                        \n");
        Billtxt.setText(Billtxt.getText() +"------------------------------------------------------------------------------------------\n");
        Billtxt.setText(Billtxt.getText()+"Customer Name: "+txtcname.getText()+ "\n" );
        Billtxt.setText(Billtxt.getText() +"------------------------------------------------------------------------------------------\n");
       
       Billtxt.setText(Billtxt.getText() + "Product" + "\t"+"\t" + "Quantity" + "\t" + "Price" + "\n"  );
    
    
    
    }
    
    
    public void Balance(){
    
     Double total=Double.parseDouble(txttova.getText());
        Double  payment =Double.parseDouble(txtpayment.getText());
        Double balance= payment-total;
        
         txtbalance.setText(String.valueOf(balance));
          

    
    
    }
    
   
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CustomerTa = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        CCategory = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        ptable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Invoiceta = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        Btnupdate2 = new javax.swing.JButton();
        Btnupdate1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtpname = new javax.swing.JTextField();
        txtcname = new javax.swing.JTextField();
        txtuprice = new javax.swing.JTextField();
        txtquan = new javax.swing.JTextField();
        txttotal = new javax.swing.JLabel();
        Payment = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtbalance = new javax.swing.JLabel();
        txtpayment = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txttova = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtiid = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        Billtxt = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setkEndColor(new java.awt.Color(138, 4, 4));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 0, 0));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_back_arrow_48px_3.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 204, 0));
        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_close_window_40px_7.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("INVOICE");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(204, 0, 0))); // NOI18N

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
        jScrollPane1.setViewportView(CustomerTa);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Search Customer");

        txtsearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(242, 242, 242));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setText("Add New");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(250, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Products List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(204, 0, 0))); // NOI18N

        CCategory.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ptableMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(ptable);

        jButton1.setBackground(new java.awt.Color(242, 242, 242));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(242, 242, 242));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Choose");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(242, 242, 242));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setText("Add New");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(CCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Invoice List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(204, 0, 0))); // NOI18N

        Invoiceta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Invoiceta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Bill_ID", "Product_Name", "Unit_Price", "Quantity", "Value"
            }
        ));
        Invoiceta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InvoicetaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                InvoicetaMouseEntered(evt);
            }
        });
        jScrollPane4.setViewportView(Invoiceta);

        btnDelete.setBackground(new java.awt.Color(242, 242, 242));
        btnDelete.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_delete_view_40px.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        Btnupdate2.setBackground(new java.awt.Color(242, 242, 242));
        Btnupdate2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Btnupdate2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_update_left_rotation_40px_2.png"))); // NOI18N
        Btnupdate2.setText("Update");
        Btnupdate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btnupdate2ActionPerformed(evt);
            }
        });

        Btnupdate1.setBackground(new java.awt.Color(242, 242, 242));
        Btnupdate1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Btnupdate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_print_40px.png"))); // NOI18N
        Btnupdate1.setText("Print");
        Btnupdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btnupdate1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(Btnupdate1)
                        .addGap(82, 82, 82)
                        .addComponent(Btnupdate2)
                        .addGap(105, 105, 105)
                        .addComponent(btnDelete)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btnupdate2)
                    .addComponent(Btnupdate1))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Select Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Customer Name :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Product Name :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Quantity :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Unit Price :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Value :");

        txtpname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtcname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtuprice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtquan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txttotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        Payment.setBackground(new java.awt.Color(242, 242, 242));
        Payment.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Payment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_delete_history_40px.png"))); // NOI18N
        Payment.setText("Clear");
        Payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(242, 242, 242));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_payment_history_40px.png"))); // NOI18N
        jButton3.setText("ADD");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(242, 242, 242));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_bill_40px.png"))); // NOI18N
        jButton7.setText("Add Invoice");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Payment :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Balance :");

        txtbalance.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtpayment.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Total Value");

        txttova.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Invoice ID :");

        txtiid.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Payment))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtbalance, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtpayment, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtcname, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttova, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(424, 424, 424)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                            .addComponent(txtiid, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtpname, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(txtuprice)
                                .addComponent(txtquan)
                                .addComponent(txttotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtiid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtuprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtquan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addComponent(txttova, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtbalance, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Payment)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Billtxt.setColumns(20);
        Billtxt.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        Billtxt.setRows(5);
        jScrollPane3.setViewportView(Billtxt);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 377, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(608, 608, 608))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        Home h =new Home(Cuser);
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked

        System.exit(0);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void CustomerTaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerTaMouseClicked
  DefaultTableModel model=(DefaultTableModel)CustomerTa.getModel();
        int myindex =CustomerTa.getSelectedRow();
        
        txtcname.setText(model.getValueAt(myindex,1).toString());
       

    }//GEN-LAST:event_CustomerTaMouseClicked

    private void ptableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ptableMouseClicked
   
        
        
        DefaultTableModel model=(DefaultTableModel)ptable.getModel();
        int myindex =ptable.getSelectedRow();
        txtpname.setText(model.getValueAt(myindex,2).toString());
        txtuprice.setText(model.getValueAt(myindex,7).toString());
        Pquantity=Integer.valueOf(model.getValueAt(myindex,4).toString());
        pid=Integer.valueOf(model.getValueAt(myindex,1).toString());
        


    }//GEN-LAST:event_ptableMouseClicked

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
         String searchString =txtsearch.getText();
         Search(searchString);
    }//GEN-LAST:event_txtsearchKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        

        if(txtiid.getText().isEmpty()||txtpname.getText().isEmpty()||txtuprice.getText().isEmpty()||txtquan.getText().isEmpty())
        {

            System.out.println(" Missing Information");
            JOptionPane.showMessageDialog(this, " Missing Information ");
        }
       
        else if (Pquantity < Integer.valueOf(txtquan.getText()) ) {
            
            
            JOptionPane.showMessageDialog(this,"Not Enough In Stock");
            
        }  
         
        
        else  {
            
               String iid =txtiid.getText();
        String pname=txtpname.getText();
       // String cname =txtcname.getText();
       // String uprice =txtuprice.getText();
       // String Quantity  =txtquan.getText();
         double  uprice =Double.parseDouble(txtuprice.getText());
         int  Quantity =Integer.parseInt( txtquan.getText());
            double total = uprice * Quantity;
            sum=sum+total;
            txttotal.setText(String.valueOf(total));       
             txttova.setText(String.valueOf(sum));
//         float  payment =Float.parseFloat( txtpayment.getText());
//        float balance= payment-total;
        
       //  txtbalance.setText(String.valueOf(balance));
            
       
{

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/markcomputerdb","root", "");

    pst = con.prepareStatement("INSERT INTO bill (Bill_ID, Product_Name, Unit_Price,Quantity,Value) VALUES (?,?,?,?,?)");
    pst.setString(1, iid);
    pst.setString(2, pname);
    pst.setDouble(3, Double.valueOf(uprice));
    pst.setInt(4, Integer.valueOf(Quantity));
    pst.setDouble(5, Double.valueOf(total));

    pst.executeUpdate();
                updateQ();
                JOptionPane.showMessageDialog(this, " invoice Details Add successfully ");
                System.out.println(" invoice Details Add successfully");

            } catch (Exception e) {
                Logger.getLogger(Copy.Invoice.class.getName()).log(Level.SEVERE, null, e);
                e.printStackTrace();

                JOptionPane.showMessageDialog(this, " invoice Details Add Failed ");
                System.out.println(" invoice Details Add Failed");

            }
            updateQ();
       Viewdetails();
       
        }
       
        
         }
        
//        
//        int sum = 0;
//        for(int i=0; i<Invoiceta.getRowCount();i++)
//        {
//          sum =sum +Integer.parseInt(Invoiceta.getValueAt(i , 4).toString());
//          
//        }
        
//        
//        txttova.setText(Integer.toString(sum));
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void PaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentActionPerformed
       txtiid.setText("");
       txtpname.setText("");
       txtcname.setText("");
      txtuprice.setText("");
      txtquan.setText("");
      txttotal.setText("");
      txtpayment.setText("");
      txtbalance.setText("");
      //DefaultTableModel model = new DefaultTableModel();
      //   model = (DefaultTableModel)Invoiceta.getModel();
      //   Invoiceta.removeAll();

      
    double sum =0;
    
    //JOptionPane.showMessageDialog(this, " Payment is Successfully ");


    }//GEN-LAST:event_PaymentActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
    if (txtiid.getText().isEmpty())
        {
        
        
        JOptionPane.showMessageDialog(this, " Enter The Details To be Deleterd ");
        
        
        }
            
        else{
        
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/markcomputerdb","root", "");
                String pid = txtiid.getText();
                String Query ="Delete from bill where Bill_ID = "+pid;
                Statement ADD =con.createStatement();
               ADD.executeUpdate(Query);
               Selectproduct();
                JOptionPane.showMessageDialog(this, " invoice Details Deleted Successfully ");
        
            } catch (Exception e) {
                
                e.printStackTrace();
            }
        
        Viewdetails();
        
        }       
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void InvoicetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InvoicetaMouseClicked
      DefaultTableModel model=(DefaultTableModel)Invoiceta.getModel();
        int myindex =Invoiceta.getSelectedRow();
        txtiid.setText(model.getValueAt(myindex,0).toString());
        txtpname.setText(model.getValueAt(myindex,1).toString());
      //  txtcname.setText(model.getValueAt(myindex,1).toString());
         txtuprice.setText(model.getValueAt(myindex,2).toString());
          txtquan.setText(model.getValueAt(myindex,3).toString());
         // oldPquantity=Integer.valueOf(model.getValueAt(myindex,4).toString());
           txttotal.setText(model.getValueAt(myindex,4).toString());
       //     txtpayment.setText(model.getValueAt(myindex,6).toString());
        //     txtbalance.setText(model.getValueAt(myindex,7).toString());
        
    }//GEN-LAST:event_InvoicetaMouseClicked

    private void InvoicetaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InvoicetaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_InvoicetaMouseEntered

    private void ptableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ptableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ptableMouseEntered

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        PRODUCT p =new PRODUCT(Cuser);
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       Customer c =new Customer(Cuser);
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void Btnupdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btnupdate1ActionPerformed
        try {
            
            Billtxt.print();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_Btnupdate1ActionPerformed

    private void Btnupdate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btnupdate2ActionPerformed
        if(txtpname.getText().isEmpty() ||txtuprice.getText().toString().isEmpty() ||txtquan.getText().isEmpty()||txttotal.getText().isEmpty())
        
        {
        
        JOptionPane.showMessageDialog(this,"Missing Information");
        
        
        
        }
       
       
//       
//        else if (Pquantity <Quantity ) {
//            
//            
//            JOptionPane.showMessageDialog(this,"Not Enough In Stock");
//            
//        }  
       
        
        else{
         String iid =txtiid.getText();
        String pname=txtpname.getText();
      //  String cname =txtcname.getText();
       // String uprice =txtuprice.getText();
       // String Quantity  =txtquan.getText();
         double  uprice =Double.parseDouble(txtuprice.getText());
         int  Quantity =Integer.parseInt(txtquan.getText());
            Double total = uprice * Quantity;
           
            txttotal.setText(String.valueOf(total));       
                
         Double  payment =Double.parseDouble(txtpayment.getText());
        Double balance= payment-total;
        
         txtbalance.setText(String.valueOf(balance));
        

try {
                         
pst = con.prepareStatement("UPDATE bill SET Product_Name=?,Unit_Price=?, Quantity=?,  Value=? WHERE Bill_ID='" + iid  + "'");
 //pst.setString(1, iid);
// pst.setString(1, cname);
 pst.setString(1, pname);
 pst.setDouble(2,Double.valueOf(  uprice ));
 pst.setInt(3,Integer.valueOf( Quantity ));
 pst.setDouble(4,Double.valueOf( total ));
// pst.setFloat(6,Float.valueOf( payment ));
// pst.setFloat(7,Float.valueOf( balance ));

pst.executeUpdate();

JOptionPane.showMessageDialog(this, "invoice Details updated successfully");



} catch (SQLException ex) {
    Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
    JOptionPane.showMessageDialog(this, ex);
}








        
        }
      Viewdetails();
      
    }//GEN-LAST:event_Btnupdate2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
   
        Billtxt.setText("");
       Balance();
      //  int i =0;
        
//        i++;
//        if (i== 1)
//        {
      
      String Customer =txtcname.getText();
      
      String total=txttova.getText();
      String payment =txtpayment.getText();
      String balance=txtbalance.getText(); 
        double  uprice =Double.parseDouble(txtuprice.getText());
        int  Quantity =Integer.parseInt( txtquan.getText());
            double total1 = uprice * Quantity;
        String QU=txtquan.getText();
        String up=txtuprice.getText();
        String p=txtpname.getText();
         
//        Billtxt.setText(Billtxt.getText() +"------------------------------------------------------------------------------------------\n");
//        Billtxt.setText(Billtxt.getText() +"                          MARK Computer                \n");
//        Billtxt.setText(Billtxt.getText() +"                    190/02 Kandy Road Yakkala          \n");
//        Billtxt.setText(Billtxt.getText() +"                      Mobile- 077-436664459            \n");
//        Billtxt.setText(Billtxt.getText() +"                 Email- markcomputer@gmail.com         \n");
//        Billtxt.setText(Billtxt.getText() +"------------------------------------------------------------------------------------------\n");
//        Billtxt.setText(Billtxt.getText() +"                                                                        \n");
//        
//        Billtxt.setText(Billtxt.getText() +"------------------------------------------------------------------------------------------\n");
//        Billtxt.setText(Billtxt.getText()+"Customer Name: "+txtcname.getText()+ "\n" );
//        Billtxt.setText(Billtxt.getText() +"------------------------------------------------------------------------------------------\n");
//       
//        Billtxt.setText(Billtxt.getText() + "Product" + "\t"+"\t" +"\t"+"Unit Price"+"\t"+"\t"+"\t"+ "Quantity" + "\t" + "Value" + "\n"  );
//       // Billtxt.set
//        
//        Billtxt.setText(Billtxt.getText()+txtpname.getText()+ "\t"+ "\t" + "\t"   +       up      +           "\t"                   +QU+         "\t"+                       total1+"\n");
//                
//        Billtxt.setText(Billtxt.getText() +"\n");
//        
//        Billtxt.setText(Billtxt.getText() + "\n");     
//          
//        Billtxt.setText(Billtxt.getText() + "\t" + "\t" + "Total Amount :" + total + "\n");
//        Billtxt.setText(Billtxt.getText() + "\t" + "\t" + "Pay :" + payment + "\n");
//        Billtxt.setText(Billtxt.getText() + "\t" + "\t" + "Balance :" + balance + "\n");
//        Billtxt.setText(Billtxt.getText() + "\n");
//        Billtxt.setText(Billtxt.getText() +"------------------------------------------------------------------------------------------\n");
//        Billtxt.setText(Billtxt.getText() + "                             THANK YOU COME AGIN             \n"); 
//        Billtxt.setText(Billtxt.getText() +"------------------------------------------------------------------------------------------\n");
//    
        
         Billtxt.setText(Billtxt.getText() + "******************************************************\n");
         Billtxt.setText(Billtxt.getText() +"                          MARK Computer                \n");
         Billtxt.setText(Billtxt.getText() +"                    190/02 Kandy Road Yakkala          \n");
         Billtxt.setText(Billtxt.getText() +"                      Mobile- 077-436664459            \n");
         Billtxt.setText(Billtxt.getText() +"                 Email- markcomputer@gmail.com         \n");
         Billtxt.setText(Billtxt.getText() + "*******************************************************\n");
         Billtxt.setText(Billtxt.getText() +"*******************************************************\n");       
         Billtxt.setText(Billtxt.getText()+"Customer Name: "+txtcname.getText()+ "\n" );
       Billtxt.setText(Billtxt.getText() +"*******************************************************\n");
         //Heading
         Billtxt.setText(Billtxt.getText() + "Product" + "\t"+ "\t"+ "Price" + "\t" + "Amount" + "\n"  );
         Billtxt.setText(Billtxt.getText() + p + "\t" + up + "\t" + total1 + "\n"  );
        Billtxt.setText(Billtxt.getText() + "\n");     
//          
        Billtxt.setText(Billtxt.getText() + "\t" + "\t" + "Total Amount :" + total + "\n");
        Billtxt.setText(Billtxt.getText() + "\t" + "\t" + "Pay :" + payment + "\n");
        Billtxt.setText(Billtxt.getText() + "\t" + "\t" + "Balance :" + balance + "\n");
        Billtxt.setText(Billtxt.getText() + "\n");
        Billtxt.setText(Billtxt.getText() +"*******************************************************\n");
        Billtxt.setText(Billtxt.getText() + "                     THANK YOU COME AGIN              \n"); 
        Billtxt.setText(Billtxt.getText() +"*******************************************************\n");
//    
//      for(int i = 0; i < model.getRowCount(); i++)
//          {
//              
//              String pname = (String)model.getValueAt(i, 1);
//             // String price=(String)Invoiceta.getValueAt(i, 3);
//             double price = Double.parseDouble((String)Invoiceta.getValueAt(i, 3));
//               //String amount=(String)model.getValueAt(i, 4);
//              double amount = Double.parseDouble((String)Invoiceta.getValueAt(i, 4));
////              
//           Billtxt.setText(Billtxt.getText() + pname+ "\t"+"t" + price    );
//   // + "\t"+"t" + price + "\t" + amount  + "\n"
//          }
//model = (DefaultTableModel)Invoiceta.getModel();

//            DefaultTableModel model = new DefaultTableModel();
//        
//             
//             int rowCount=model.getRowCount();
//
//
//           for (int i = 0; i < rowCount; i++) {
//            String pName = (String) Invoiceta.getValueAt(i, 1);
//            String pPrice = (String) Invoiceta.getValueAt(i, 2);
//            String pQty = (String) Invoiceta.getValueAt(i, 3);
//            String pValue = (String) Invoiceta.getValueAt(i, 4);
//
//            Billtxt.setText(Billtxt.getText()+ pName + "\t" + pPrice + "\t" + pQty + "\t" + pValue + "\n");
//
//        }


         
        
        
        
        
        
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
       
              Selectproduct();
     
        
        
        
        
        
        
        
              
              
              
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      try{
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/markcomputerdb","root", "");
         Statement ps = con.createStatement();
      rs =ps.executeQuery("Select * from manageproducts where Product_Category='" +CCategory.getSelectedItem()+"'");
      ptable.setModel(DbUtils.resultSetToTableModel(rs));
     }catch(SQLException e){
     
     
     e.printStackTrace();
     
    }//GEN-LAST:event_jButton2ActionPerformed
    }
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
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Invoice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Billtxt;
    private javax.swing.JButton Btnupdate1;
    private javax.swing.JButton Btnupdate2;
    private javax.swing.JComboBox<String> CCategory;
    private javax.swing.JTable CustomerTa;
    private javax.swing.JTable Invoiceta;
    private javax.swing.JButton Payment;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTable ptable;
    private javax.swing.JLabel txtbalance;
    private javax.swing.JTextField txtcname;
    private javax.swing.JTextField txtiid;
    private javax.swing.JTextField txtpayment;
    private javax.swing.JTextField txtpname;
    private javax.swing.JTextField txtquan;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JLabel txttotal;
    private javax.swing.JLabel txttova;
    private javax.swing.JTextField txtuprice;
    // End of variables declaration//GEN-END:variables
}

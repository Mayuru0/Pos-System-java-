package UI;

import Copy.*;
import UI.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class Registration extends javax.swing.JFrame {

    //private Statement ps;
    String Cuser = "Admin";

    /**
     * Creates new form Registation
     */
    public Registration(String usr) {
        initComponents();
        Cuser = usr;
        //  setSize(1920,1080);
//            ViewRE();
        Selectusers();
        Connect();

    }

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Statement stmt = null;
    String rsm;

    private Registration() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void Connect() {
        DBConnection db = new DBConnection();
        db.getConnection();

    }

    public void Selectusers() {

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/markcomputerdb", "root", "");

            Statement ps = con.createStatement();
            rs = ps.executeQuery("Select * from registation");
            RegistateredTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    public boolean txtValidation(String txt) {
        String input = txt;
        boolean result = false;
        String regex = "^[a-zA-Z\\s]*$"; // Regular expression to match only letters and spaces
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public static boolean validateEmail(String email) {
        // Regular expression pattern for email validation
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        // Regular expression pattern for phone number validation
        
       
      
        // Regular expression pattern for phone number validation
        
        String number = phoneNumber;
        boolean rslt=false;
        
        if(number.length()!=10){
            rslt = false;
        }
        else{
            
            String phoneNumberPattern = "^(\\+\\d{1,3})?[-.\\s]?\\(?\\d{1,3}\\)?[-.\\s]?\\d{1,3}[-.\\s]?\\d{1,4}$";

        Pattern pattern = Pattern.compile(phoneNumberPattern);
        Matcher matcher = pattern.matcher(phoneNumber);

        rslt =  matcher.matches();
        }
       
            return rslt;
    }
    
    public static boolean validateNIC(String nicNumber) {
        if (nicNumber.matches("[0-9]+")) {
            return true;
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        RegistateredTable = new javax.swing.JTable();
        btnupdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Txtid = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtfname = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtemail = new javax.swing.JTextPane();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtlname = new javax.swing.JTextPane();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtname = new javax.swing.JTextPane();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtaddress = new javax.swing.JTextPane();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtnic = new javax.swing.JTextPane();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        txtnumber = new javax.swing.JTextPane();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        CoGender = new javax.swing.JComboBox<>();
        cotype = new javax.swing.JComboBox<>();
        txtpasword = new javax.swing.JPasswordField();
        jRadioShow = new javax.swing.JRadioButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setkEndColor(new java.awt.Color(138, 4, 4));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 0, 0));

        jLabel6.setBackground(new java.awt.Color(255, 204, 0));
        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_close_window_40px_7.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_back_arrow_48px_3.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registered View", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24), new java.awt.Color(204, 0, 0))); // NOI18N

        RegistateredTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "User Id", "User Name", "First Name", "Last Name", "NIC Number", "Gender", "Date Of Birth", "Address", "Contact Number", "Email", "Password", "Account Type"
            }
        ));
        RegistateredTable.setRowHeight(25);
        RegistateredTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegistateredTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(RegistateredTable);

        btnupdate.setBackground(new java.awt.Color(242, 242, 242));
        btnupdate.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_update_left_rotation_40px.png"))); // NOI18N
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(242, 242, 242));
        btnDelete.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_delete_view_40px.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(btnupdate)
                .addGap(90, 90, 90)
                .addComponent(btnDelete)
                .addContainerGap(274, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registration Form", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("User Id");

        Txtid.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jScrollPane1.setViewportView(Txtid);

        txtfname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jScrollPane2.setViewportView(txtfname);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Pasword");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Last Name");

        txtemail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jScrollPane4.setViewportView(txtemail);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Email");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("First Name");

        jButton1.setBackground(new java.awt.Color(242, 242, 242));
        jButton1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_delete_history_40px.png"))); // NOI18N
        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtlname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jScrollPane8.setViewportView(txtlname);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("User Name");

        txtname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jScrollPane3.setViewportView(txtname);

        jButton2.setBackground(new java.awt.Color(242, 242, 242));
        jButton2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_Add_Male_User_Group_50px_1.png"))); // NOI18N
        jButton2.setText("Registation");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Gender");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Address");

        txtaddress.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jScrollPane9.setViewportView(txtaddress);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Date Of Birth");

        txtnic.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jScrollPane10.setViewportView(txtnic);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Contact Number");

        txtnumber.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jScrollPane11.setViewportView(txtnumber);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("Account Type");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("NIC Number");

        CoGender.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        CoGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        cotype.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        cotype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User" }));

        txtpasword.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtpasword.setText("jPasswordField1");

        jRadioShow.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioShow.setText("Show Password");
        jRadioShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioShowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(203, 203, 203))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel13))
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CoGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(129, 129, 129)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel12)
                        .addComponent(jLabel7)
                        .addComponent(jLabel14)
                        .addComponent(jScrollPane11)
                        .addComponent(jLabel4)
                        .addComponent(jScrollPane4)
                        .addComponent(txtpasword)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addGap(46, 46, 46)
                            .addComponent(cotype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jRadioShow)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CoGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtpasword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioShow)
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(cotype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setBackground(new java.awt.Color(255, 204, 0));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel1.setText("Registration Form");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_user_80px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(519, 519, 519)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
      //  this.dispose();
    Home h = new Home(Cuser);
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Txtid.setText("");
        txtname.setText("");
        txtfname.setText("");
        txtlname.setText("");
        txtnic.setText("");
        CoGender.getSelectedItem();
        jDateChooser2.setDateFormatString("");
        txtaddress.setText("");
        txtnumber.setText("");
        txtemail.setText("");
        txtpasword.setText("");
        //txtcpasword.setText("");
        cotype.getSelectedItem();


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
if (Txtid.getText().isEmpty() || txtname.getText().isEmpty() || txtfname.getText().isEmpty() || txtlname.getText().isEmpty() || txtnic.getText().isEmpty() || CoGender.getSelectedItem().toString().isEmpty() || jDateChooser2.getDateFormatString().isEmpty() || txtaddress.getText().isEmpty() || txtnumber.getText().isEmpty() || txtemail.getText().isEmpty() || txtpasword.getText().isEmpty() || cotype.getSelectedItem().toString().isEmpty()) {

            System.out.println(" Missing Information");
            JOptionPane.showMessageDialog(this, " Missing Information ");
        
        

        
        } 
        String id = Txtid.getText();
        String name = txtname.getText();
        String fna = txtfname.getText();
        String lna = txtlname.getText();
        String nic = txtnic.getText();
        String gender = (String) CoGender.getSelectedItem();
        //   String birth =txtbirthday.getText();
        String Address = txtaddress.getText();
        String Number = txtnumber.getText();
        String email = txtemail.getText();
        String pasword = txtpasword.getText();
        String type = (String) cotype.getSelectedItem();

//        String birth = jDateChooser1.getDateFormatString();
        String birth = ((JTextField) jDateChooser2.getDateEditor().getUiComponent()).getText();
        
        
        
           boolean isFirstNameValid = txtValidation(fna);
            boolean isLastNameValid = txtValidation(lna);
            boolean isEmailValid = validateEmail(email);
            boolean isContactNoValid = validatePhoneNumber(Number);
            //boolean isEmContactNoValid = validatePhoneNumber(emContactNo);
            boolean isNICValid = validateNIC(nic);

            if (!isFirstNameValid) {
                JOptionPane.showMessageDialog(null, "First Name is Not Valid...", "error", JOptionPane.ERROR_MESSAGE);
            } else if (!isLastNameValid) {
                JOptionPane.showMessageDialog(null, "Last Name is Not Valid...", "error", JOptionPane.ERROR_MESSAGE);
            } else if (!isEmailValid) {
                JOptionPane.showMessageDialog(null, "Email is Not Valid...", "error", JOptionPane.ERROR_MESSAGE);
            } else if (!isContactNoValid) {
                JOptionPane.showMessageDialog(null, "Contact Number is Not Valid...", "error", JOptionPane.ERROR_MESSAGE);
            } else if (!isNICValid) {
                JOptionPane.showMessageDialog(null, "NIC is Not Valid...", "error", JOptionPane.ERROR_MESSAGE);
            } else {
            
            
                 
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/markcomputerdb", "root", "");

                pst = con.prepareStatement("INSERT INTO registation (UserId,UserName,FirstName,LastName,NIC,Gender,Birthday,Address,Number,Email,Password,AccountType) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
                pst.setString(1, id);
                pst.setString(2, name);
                pst.setString(3, fna);
                pst.setString(4, lna);
                pst.setString(5, nic);
                pst.setString(6, gender);
                pst.setString(7, birth);
                pst.setString(8, Address);
                pst.setString(9, Number);
                pst.setString(10, email);
                pst.setString(11, pasword);
                pst.setString(12, type);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(this, " User Registation successfully ");
                System.out.println(" User Registation successfully");

            } catch (Exception e) {
                Logger.getLogger(Copy.Registation1.class.getName()).log(Level.SEVERE, null, e);
                e.printStackTrace();

                JOptionPane.showMessageDialog(this, " User Registation Failed ");
                System.out.println(" User Registation Failed");

            }

        }
        Selectusers();
        //  ViewRE();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (Txtid.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, " Enter The User To be Deleterd ");

        } else {

            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/markcomputerdb", "root", "");
                String id = Txtid.getText();
                String Query = "Delete from registation where UserId = " + id;
                Statement ADD = con.createStatement();
                ADD.executeUpdate(Query);
                Selectusers();
                JOptionPane.showMessageDialog(this, " User Deleted Successfully ");

            } catch (Exception e) {

                e.printStackTrace();
            }

        }


    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed

        if (Txtid.getText().isEmpty() || txtname.getText().isEmpty() || txtfname.getText().isEmpty() || txtlname.getText().isEmpty() || txtnic.getText().isEmpty() || CoGender.getSelectedItem().toString().isEmpty() || jDateChooser2.getDateFormatString().isEmpty() || txtaddress.getText().isEmpty() || txtnumber.getText().isEmpty() || txtemail.getText().isEmpty() || txtpasword.getText().isEmpty() || cotype.getSelectedItem().toString().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Missing Information");

        } else {

            String id = Txtid.getText();
            String name = txtname.getText();
            String fna = txtfname.getText();
            String lna = txtlname.getText();
            String nic = txtnic.getText();
            String gender = (String) CoGender.getSelectedItem();
            //   String birth =txtbirthday.getText();
            String Address = txtaddress.getText();
            String Number = txtnumber.getText();
            String email = txtemail.getText();
            String pasword = txtpasword.getText();
            String type = (String) cotype.getSelectedItem();

            String birth = ((JTextField) jDateChooser2.getDateEditor().getUiComponent()).getText();

            boolean isFirstNameValid = txtValidation(fna);
            boolean isLastNameValid = txtValidation(lna);
            boolean isEmailValid = validateEmail(email);
            boolean isContactNoValid = validatePhoneNumber(Number);
            //boolean isEmContactNoValid = validatePhoneNumber(emContactNo);
            boolean isNICValid = validateNIC(nic);

            if (!isFirstNameValid) {
                JOptionPane.showMessageDialog(null, "First Name is Not Valid...", "error", JOptionPane.ERROR_MESSAGE);
            } else if (!isLastNameValid) {
                JOptionPane.showMessageDialog(null, "Last Name is Not Valid...", "error", JOptionPane.ERROR_MESSAGE);
            } else if (!isEmailValid) {
                JOptionPane.showMessageDialog(null, "Email is Not Valid...", "error", JOptionPane.ERROR_MESSAGE);
            } else if (!isContactNoValid) {
                JOptionPane.showMessageDialog(null, "Contact Number is Not Valid...", "error", JOptionPane.ERROR_MESSAGE);
            } else if (!isNICValid) {
                JOptionPane.showMessageDialog(null, "NIC is Not Valid...", "error", JOptionPane.ERROR_MESSAGE);
            } else {

                try {
                    pst = con.prepareStatement("UPDATE registation SET UserName=?, FirstName=?, LastName=?, NIC=?, Gender=?, Birthday=?, Address=?, Number=?, Email=?, Password=?, AccountType=? WHERE UserId='" + id + "'");
                    pst.setString(1, name);
                    pst.setString(2, fna);
                    pst.setString(3, lna);
                    pst.setString(4, nic);
                    pst.setString(5, gender);
                    pst.setString(6, birth);
                    pst.setString(7, Address);
                    pst.setString(8, Number);
                    pst.setString(9, email);
                    pst.setString(10, pasword);
                    pst.setString(11, type);
                    //pst.setString(4, dno);

                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(this, "User information updated successfully");
                    Selectusers();

                } catch (SQLException ex) {
                    Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex);
                }
            }

        }


    }//GEN-LAST:event_btnupdateActionPerformed

    private void RegistateredTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistateredTableMouseClicked

        //  String birth = ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
        DefaultTableModel model = (DefaultTableModel) RegistateredTable.getModel();
        int myindex = RegistateredTable.getSelectedRow();
        Txtid.setText(model.getValueAt(myindex, 0).toString());
        txtname.setText(model.getValueAt(myindex, 1).toString());
        txtfname.setText(model.getValueAt(myindex, 2).toString());
        txtlname.setText(model.getValueAt(myindex, 3).toString());
        txtnic.setText(model.getValueAt(myindex, 4).toString());
        CoGender.setSelectedItem(model.getValueAt(myindex, 5).toString());
        String birth = ((JTextField) jDateChooser2.getDateEditor().getUiComponent()).getText();
        String valueAtColumn6 = model.getValueAt(myindex, 6).toString();
        String result = birth + valueAtColumn6;

        jDateChooser2.setDateFormatString(model.getValueAt(myindex, 6).toString());
        txtaddress.setText(model.getValueAt(myindex, 7).toString());
        txtnumber.setText(model.getValueAt(myindex, 8).toString());
        txtemail.setText(model.getValueAt(myindex, 9).toString());
        txtpasword.setText(model.getValueAt(myindex, 10).toString());
        cotype.setSelectedItem(model.getValueAt(myindex, 11).toString());


    }//GEN-LAST:event_RegistateredTableMouseClicked

    private void jRadioShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioShowActionPerformed
        if (jRadioShow.isSelected()) {
            txtpasword.setEchoChar((char) 0);
        } else {
            txtpasword.setEchoChar('*');
        }
    }//GEN-LAST:event_jRadioShowActionPerformed

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
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Registration().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CoGender;
    private javax.swing.JTable RegistateredTable;
    private javax.swing.JTextPane Txtid;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnupdate;
    private javax.swing.JComboBox<String> cotype;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioShow;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTextPane txtaddress;
    private javax.swing.JTextPane txtemail;
    private javax.swing.JTextPane txtfname;
    private javax.swing.JTextPane txtlname;
    private javax.swing.JTextPane txtname;
    private javax.swing.JTextPane txtnic;
    private javax.swing.JTextPane txtnumber;
    private javax.swing.JPasswordField txtpasword;
    // End of variables declaration//GEN-END:variables

    private static class INTERFACE_RegistateredTable {

        private static void setModel(TableModel resultSetToTableModel) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public INTERFACE_RegistateredTable() {
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbanksystem;

import java.awt.Container;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author ABC
 */
public class checkmyrequest extends javax.swing.JInternalFrame {

    /**
     * Creates new form Home
     */
    public checkmyrequest() {
        initComponents();
        /* REMOVE THE DROP DOWN BUTTON FROM FRAME */
        Container pane = ((BasicInternalFrameUI) this.getUI()).getNorthPane();
        pane.remove(0);
        pane.getComponent(0).setVisible(false);
        volunteerList();
        commentList();
    }
    
    public void volunteerList() {
        DefaultListModel<volunteerObject> dlm = new DefaultListModel<volunteerObject>();
        
        dlm.addElement(new volunteerObject("No Volunteers yet"));
        jList1.setModel(dlm);
        jList1.setCellRenderer(new volunteerEmptylistmodel());
    }
    
    public void volunteerListPopulated() {
        DefaultListModel<volunteerObject> dlm = new DefaultListModel<volunteerObject>();
        
        int a=0;
        
        String r_id = id.getText();
        int intr_id = Integer.parseInt(r_id);
        
        int emptycount=0;
        
        DB_Connection ob = new DB_Connection();
        Connection conn = ob.get_connection();
        PreparedStatement ps = null;
        
        
        try {
            
            String qry = "SELECT count(*) From Volunteer";
            ps=conn.prepareStatement(qry);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                emptycount=rs.getInt("count(*)");
            }
             
            if (emptycount==0) {
                dlm.addElement(new volunteerObject("No Volunteers yet"));
                jList1.setModel(dlm);
                jList1.setCellRenderer(new volunteerEmptylistmodel());
            }
            
            
            else if (emptycount!=0) {
                
                String query="select * from Volunteer where req_id= "+intr_id;
                ps=conn.prepareStatement(query);
                ResultSet rs1=ps.executeQuery();
                
                String name,bg,unit,time;
                    
                while (rs1.next()) {
                    a=1;
                    name = rs1.getString("v_name");
                    bg = rs1.getString("v_bloodgroup");
                    unit = rs1.getString("v_units");
                    time = rs1.getString("v_time");
                
                    dlm.addElement(new volunteerObject("Name : "+name, "Blood Group : "+bg,"Units : "+unit,"Time : "+time));
                    jList1.setModel(dlm);
                    jList1.setCellRenderer(new volunteerlistmodel());
                }
                if (a==0) {
                    jList1.setModel(dlm);
                    jList1.setCellRenderer(new volunteerEmptylistmodel());
                }
                
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, ""+e);
        }
        
     
    }
    
     public void commentList() {
        DefaultListModel<commentObject> dlm1 = new DefaultListModel<commentObject>();
        
        dlm1.addElement(new commentObject("No Comments yet"));
        jList2.setModel(dlm1);
        jList2.setCellRenderer(new commentEmptyModel());
    }
     
    public void commentListPopulated() {
        DefaultListModel<commentObject> dlm1 = new DefaultListModel<commentObject>();
        
        int a=0;
        
        String r_id = id.getText();
        int intr_id = Integer.parseInt(r_id);
        
        int emptycount=0;
        
        DB_Connection ob = new DB_Connection();
        Connection conn = ob.get_connection();
        PreparedStatement ps = null;
        
        try {
            
            String qry = "SELECT count(*) From VolunteerComment";
            ps=conn.prepareStatement(qry);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                emptycount=rs.getInt("count(*)");
            }
             
            if (emptycount==0) {
                dlm1.addElement(new commentObject("No Comments yet"));
                jList2.setModel(dlm1);
                jList2.setCellRenderer(new commentEmptyModel());
            }
            
            else if (emptycount!=0) {
            
                String query="select * from VolunteerComment where req_id="+intr_id;
                ps=conn.prepareStatement(query);
                ResultSet rs1=ps.executeQuery();
                
                String name,comment;
                    
                while (rs1.next()) {
                    a=1;
                    name = rs1.getString("v_name");
                    comment = rs1.getString("v_comment");
                
                    dlm1.addElement(new commentObject("Name : "+name, "Comment : "+comment));
                    jList2.setModel(dlm1);
                    jList2.setCellRenderer(new commentModel());
                }
                
                if (a==0) {
                    jList2.setModel(dlm1);
                    jList2.setCellRenderer(new commentEmptyModel());
                }
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, ""+e);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        okBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        r_bloodgroup = new javax.swing.JLabel();
        r_contactno = new javax.swing.JLabel();
        r_location = new javax.swing.JLabel();
        r_name = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(539, 540));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel2.setText("Enter ID");

        okBtn.setText("OK");
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });

        r_bloodgroup.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        r_bloodgroup.setText("Blood Group : ");

        r_contactno.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        r_contactno.setText("Contact No : ");

        r_location.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        r_location.setText("Location : ");

        r_name.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        r_name.setText("Name : ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r_bloodgroup)
                    .addComponent(r_name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r_location)
                    .addComponent(r_contactno))
                .addGap(168, 168, 168))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r_name)
                    .addComponent(r_contactno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r_bloodgroup)
                    .addComponent(r_location))
                .addGap(29, 29, 29))
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel1.setText("Volunteers");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel3.setText("Comments");

        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(okBtn)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jLabel3)
                                .addGap(109, 109, 109))
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(okBtn)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
        String idd1 = id.getText();
        int intid = Integer.parseInt(idd1);
        
        int a = 0;
        
        int emptycount=0;
        
        DB_Connection ob = new DB_Connection();
        Connection conn = ob.get_connection();
        PreparedStatement ps = null;
        
        try {
            
                    String qry="Select count(*) from BloodRequirement";
                    ps=conn.prepareStatement(qry);
                    ResultSet rs=ps.executeQuery();
                    while(rs.next()){
                        
                        emptycount=rs.getInt("count(*)");
                        
                    }
                    
                    if(emptycount==0){
                        JOptionPane.showMessageDialog(null,"You have no blood requirements yet");
                    }
                    
                    
                    else{
                        
                         String query="Select * From BloodRequirement where req_id= "+intid;
                         ps=conn.prepareStatement(query);
                         rs=ps.executeQuery();
                    
                        while(rs.next()){
                            
                            
                        if(rs.getInt("req_id")==intid){ 
                            a=1;
                            r_name.setText("Name : "+rs.getString("p_name"));
                            r_bloodgroup.setText("Blood Group : "+rs.getString("p_bloodgroup"));
                            r_contactno.setText("Contact No : "+rs.getString("p_contactno"));
                            r_location.setText("Location : "+rs.getString("p_location"));
                            
                            volunteerListPopulated();
                            commentListPopulated();
                           
                        }
                        
                        else if (rs.getInt("req_id")!=intid) {
                            a=0;
                        }
                             
                        }
                        
                        
                        if (a==0) {
                           JOptionPane.showMessageDialog(null,"ID does't exists");
                      
                           r_name.setText("Name : ");
                           r_bloodgroup.setText("Blood Group : ");
                           r_contactno.setText("Contact No : ");
                           r_location.setText("Location : ");
                     
                        }
                        
                        
                        
                        
                    }
            
        } catch (Exception e ) {
            
        }
        
        
    }//GEN-LAST:event_okBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<volunteerObject> jList1;
    private javax.swing.JList<commentObject> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton okBtn;
    private javax.swing.JLabel r_bloodgroup;
    private javax.swing.JLabel r_contactno;
    private javax.swing.JLabel r_location;
    private javax.swing.JLabel r_name;
    // End of variables declaration//GEN-END:variables
}

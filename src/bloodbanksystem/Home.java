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
public class Home extends javax.swing.JInternalFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        /* REMOVE THE DROP DOWN BUTTON FROM FRAME */
        Container pane = ((BasicInternalFrameUI) this.getUI()).getNorthPane();
        pane.remove(0);
        pane.getComponent(0).setVisible(false);
        testList();
    }
    
    public void testList() {
        DefaultListModel<customListObject> dlm = new DefaultListModel<customListObject>();
        
        int emptycount=0;
        
        DB_Connection ob = new DB_Connection();
        Connection conn = ob.get_connection();
        PreparedStatement ps = null;
        
        try {
            
            String qry = "SELECT count(*) From BloodRequirement";
            ps=conn.prepareStatement(qry);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                emptycount=rs.getInt("count(*)");
            }
             
            if (emptycount==0) {
                dlm.addElement(new customListObject("There are no Blood Requirements yet."));
                jList1.setModel(dlm);
                jList1.setCellRenderer(new emptyTableModel());
            }
            
            else if (emptycount!=0) {
                
                String query="select * from BloodRequirement";
                ps=conn.prepareStatement(query);
                ResultSet rs1=ps.executeQuery();
                
                String id,name,bg,cno,loc,urgency,date;
                    
                while (rs1.next()) {
                    id = rs1.getString("req_id");
                    name = rs1.getString("p_name");
                    bg = rs1.getString("p_bloodgroup");
                    cno = rs1.getString("p_contactno");
                    loc = rs1.getString("p_location");
                    urgency = rs1.getString("p_urgency");
                    date = rs1.getString("p_date");
                
                    dlm.addElement(new customListObject("ID : "+id, "Name : "+name, "Blood Group : "+bg,"Contact No : "+cno,"Location : "+loc,"Urgency : "+urgency,"Date : "+date));
                        
                }
                
                jList1.setModel(dlm);
                jList1.setCellRenderer(new listModel());
                
            }
            conn.close();
            
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        refreshBtn = new javax.swing.JButton();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(539, 540));

        jList1.setFocusable(false);
        jScrollPane2.setViewportView(jList1);

        refreshBtn.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        refreshBtn.setText("Refresh");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(242, Short.MAX_VALUE)
                .addComponent(refreshBtn)
                .addGap(210, 210, 210))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(refreshBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        testList();
    }//GEN-LAST:event_refreshBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<customListObject> jList1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton refreshBtn;
    // End of variables declaration//GEN-END:variables
}
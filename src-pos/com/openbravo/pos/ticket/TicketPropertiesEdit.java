//    uniCenta oPOS  - Touch Friendly Point Of Sale
//    Copyright (c) 2009-2014 uniCenta & previous Openbravo POS works
//    http://www.unicenta.com
//
//    This file is part of uniCenta oPOS
//
//    uniCenta oPOS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//   uniCenta oPOS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with uniCenta oPOS.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.pos.ticket;


import com.openbravo.pos.forms.AppLocal;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.Properties;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.openbravo.beans.JCalendarDialog;
import com.openbravo.format.Formats;
/**
 *
 * @author JG uniCenta
 */
public class TicketPropertiesEdit extends javax.swing.JDialog {
    Properties ticketProperties;
    public static final String DOCTYPE = "DOCTYPE";
    public static final String CASHDATE = "CASHDATE";
    public static final String SERVICEDATE = "SERVICEDATE";
    public static final String DELIVERYDATE = "DELIVERYDATE";
    public static final String REFERENCE = "REFERENCE";
    public static final String REVERSETAX = "REVERSETAX";
    public static final String PERSON = "person";
    public static final String TAX_22 = "DDV 22 %";
    public static final String TAX_9_5 = "DDV 9,5 %";
    
    /** Creates new form JTicketsBagSharedList */
    private TicketPropertiesEdit(java.awt.Frame parent, boolean modal,Properties prop) {
        super(parent, modal);
        ticketProperties = prop;
        initComponents();
        init();
    }
    /** Creates new form JTicketsBagSharedList */
    private TicketPropertiesEdit(java.awt.Dialog parent, boolean modal,Properties prop) {
        super(parent, modal);
        ticketProperties = prop;
        initComponents();
        init();
    }
    
    private void init()
    {
        if(ticketProperties.containsKey(DOCTYPE)){
            for(int i=0; i<jComboBox1.getItemCount(); i++){
                if(ticketProperties.getProperty(DOCTYPE).equals((String)jComboBox1.getItemAt(i)))
                    jComboBox1.setSelectedIndex(i);
            }
        }
        
        if(ticketProperties.containsKey(SERVICEDATE))
            jTextField1.setText(ticketProperties.getProperty(SERVICEDATE));
        
        if(ticketProperties.containsKey(DELIVERYDATE))
            jTextField2.setText(ticketProperties.getProperty(DELIVERYDATE));
        
        if(ticketProperties.containsKey(CASHDATE))
            jTextField3.setText(ticketProperties.getProperty(CASHDATE));
        
        if(ticketProperties.containsKey(REFERENCE))
            jTextField4.setText(ticketProperties.getProperty(REFERENCE));
        
        if(ticketProperties.containsKey(PERSON))
            jTextField5.setText(ticketProperties.getProperty(PERSON));
        
        
        if(ticketProperties.containsKey(REVERSETAX)){
            jCheckBox1.setSelected(true);
            
            if(ticketProperties.getProperty(REVERSETAX).equals(TAX_22)){
                jSlider1.setValue(1);
                jLabel1.setText(TAX_22);
                jSlider1StateChanged(null);
                jSlider1.setEnabled(true);
            }else if(ticketProperties.getProperty(REVERSETAX).equals(TAX_9_5)){
                jSlider1.setValue(0);
                jLabel1.setText(TAX_9_5);
                jSlider1StateChanged(null);
                jSlider1.setEnabled(true);
            }
            else{
                jCheckBox1.setSelected(false);
                jSlider1.setEnabled(false);
                jLabel1.setText("");
            }
        }else{
                jCheckBox1.setSelected(false);
                jSlider1.setEnabled(false);
                jLabel1.setText("");
        }       
    }     
            
           
    
    /**
     *
     * @param parent
     * @param prop
     * @return
     */
    public static TicketPropertiesEdit newJDialog(Window parent, Properties prop) {
        
        Window window = getWindow(parent);
        TicketPropertiesEdit mydialog;
        if (window instanceof Frame) { 
            mydialog = new TicketPropertiesEdit((Frame) window, true, prop);
            mydialog.setResizable(false);
        } else {
            mydialog = new TicketPropertiesEdit((Dialog) window, true, prop);
            mydialog.setResizable(false);
        } 
        return mydialog;
    }
    
    private static Window getWindow(Component parent) {
        if (parent == null) {
            return new JFrame();
        } else if (parent instanceof Frame || parent instanceof Dialog) {
            return (Window) parent;
        } else {
            return getWindow(parent.getParent());
        }
    }  


    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        m_jButtonCancel = new javax.swing.JButton();
        m_jButtonReset = new javax.swing.JButton();
        m_jButtonOk = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel12 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jSlider1 = new javax.swing.JSlider();
        jPanel14 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();

        setTitle(AppLocal.getIntString("caption.ticketproperties")); // NOI18N

        m_jButtonCancel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jButtonCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/cancel.png"))); // NOI18N
        m_jButtonCancel.setText(AppLocal.getIntString("Button.Cancel")); // NOI18N
        m_jButtonCancel.setFocusPainted(false);
        m_jButtonCancel.setFocusable(false);
        m_jButtonCancel.setMargin(new java.awt.Insets(8, 16, 8, 16));
        m_jButtonCancel.setRequestFocusEnabled(false);
        m_jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jButtonCancelActionPerformed(evt);
            }
        });
        jPanel3.add(m_jButtonCancel);

        m_jButtonReset.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jButtonReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/reload.png"))); // NOI18N
        m_jButtonReset.setText(AppLocal.getIntString("Button.Reset")); // NOI18N
        m_jButtonReset.setFocusPainted(false);
        m_jButtonReset.setFocusable(false);
        m_jButtonReset.setMargin(new java.awt.Insets(8, 16, 8, 16));
        m_jButtonReset.setRequestFocusEnabled(false);
        m_jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jButtonResetActionPerformed(evt);
            }
        });
        jPanel3.add(m_jButtonReset);

        m_jButtonOk.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jButtonOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/ok.png"))); // NOI18N
        m_jButtonOk.setText(AppLocal.getIntString("Button.OK")); // NOI18N
        m_jButtonOk.setFocusPainted(false);
        m_jButtonOk.setFocusable(false);
        m_jButtonOk.setMargin(new java.awt.Insets(8, 16, 8, 16));
        m_jButtonOk.setRequestFocusEnabled(false);
        m_jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jButtonOkActionPerformed(evt);
            }
        });
        jPanel3.add(m_jButtonOk);

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        jPanel1.setMinimumSize(new java.awt.Dimension(350, 34));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Račun", "Informativni predračun", "Predračun" }));
        jComboBox1.setSelectedItem("");
        jComboBox1.setPreferredSize(new java.awt.Dimension(189, 30));
        jPanel1.add(jComboBox1);

        jPanel6.add(jPanel1);

        jPanel2.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jLabel2.setText("Datum storitve");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel2.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel2.add(jLabel2);

        jTextField1.setEditable(false);
        jTextField1.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel2.add(jTextField1);

        jButton4.setToolTipText("");
        jButton4.setPreferredSize(new java.awt.Dimension(20, 20));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/date.png"))); // NOI18N
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jPanel6.add(jPanel2);

        jPanel7.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        jLabel3.setText("Datum dobave");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel3.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel7.add(jLabel3);

        jTextField2.setEditable(false);
        jTextField2.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel7.add(jTextField2);

        jButton5.setToolTipText("");
        jButton5.setPreferredSize(new java.awt.Dimension(20, 20));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton5);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/date.png"))); // NOI18N
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton2.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton2);

        jPanel6.add(jPanel7);

        jPanel8.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));

        jLabel4.setText("Datum valute");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel4.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel8.add(jLabel4);

        jTextField3.setEditable(false);
        jTextField3.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel8.add(jTextField3);

        jButton6.setToolTipText("");
        jButton6.setPreferredSize(new java.awt.Dimension(20, 20));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton6);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/date.png"))); // NOI18N
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton3.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton3);

        jPanel6.add(jPanel8);

        jPanel9.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        jLabel5.setText("Referenca");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel5.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel9.add(jLabel5);

        jTextField4.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel9.add(jTextField4);

        jPanel6.add(jPanel9);

        jPanel11.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.LINE_AXIS));

        jCheckBox1.setText("76.a člen");
        jCheckBox1.setPreferredSize(new java.awt.Dimension(120, 23));
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel11.add(jCheckBox1);

        jPanel12.setPreferredSize(new java.awt.Dimension(0, 10));
        jPanel11.add(jPanel12);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("DDV 22 %");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel1.setMaximumSize(new java.awt.Dimension(70, 15));
        jLabel1.setMinimumSize(new java.awt.Dimension(70, 15));
        jLabel1.setPreferredSize(new java.awt.Dimension(70, 15));
        jPanel11.add(jLabel1);

        jPanel13.setPreferredSize(new java.awt.Dimension(0, 10));
        jPanel11.add(jPanel13);

        jSlider1.setMaximum(1);
        jSlider1.setPreferredSize(new java.awt.Dimension(70, 30));
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        jPanel11.add(jSlider1);

        jPanel6.add(jPanel11);

        jPanel14.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel14.setLayout(new javax.swing.BoxLayout(jPanel14, javax.swing.BoxLayout.LINE_AXIS));

        jLabel6.setText("Oznaka");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel6.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel14.add(jLabel6);

        jTextField5.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel14.add(jTextField5);

        jPanel6.add(jPanel14);

        getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(368, 406));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void m_jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jButtonOkActionPerformed

        
        /*
        
        
        
        
        */
        ticketProperties.setProperty(DOCTYPE, (String)jComboBox1.getSelectedItem());
        
        if(jTextField1.getText().length()>2)
            ticketProperties.setProperty(SERVICEDATE, jTextField1.getText());
        else
            ticketProperties.remove(SERVICEDATE);
        
        
        if(jTextField2.getText().length()>2)
            ticketProperties.setProperty(DELIVERYDATE, jTextField2.getText());
        else
            ticketProperties.remove(DELIVERYDATE);
        
        
        if(jTextField3.getText().length()>2)
            ticketProperties.setProperty(CASHDATE, jTextField3.getText());
        else
            ticketProperties.remove(CASHDATE);
        
        
        if(jTextField4.getText().length()>2)
            ticketProperties.setProperty(REFERENCE, jTextField4.getText());
        else
            ticketProperties.remove(REFERENCE);
        
        
        if(jCheckBox1.isSelected()){
            ticketProperties.setProperty(REVERSETAX, jLabel1.getText());
            jSlider1StateChanged(null);
        }
        else{
            ticketProperties.remove(REVERSETAX);
            jSlider1.setEnabled(false);
            jCheckBox1.setSelected(false);
            jSlider1StateChanged(null);
        }
          
        if(!jTextField5.getText().isEmpty())
            ticketProperties.setProperty(PERSON, jTextField5.getText());
        else
            ticketProperties.remove(PERSON);
            
            
        
        
        
        
        dispose();
        
    }//GEN-LAST:event_m_jButtonOkActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Date d = new Date();
        JCalendarDialog.showCalendar(jButton1, d);
 
        SimpleDateFormat formatd = new SimpleDateFormat ("d.M.yyyy");

        jTextField1.setText(formatd.format(d));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jTextField1.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jTextField2.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jTextField3.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Date d = new Date();
        JCalendarDialog.showCalendar(jButton2, d);
        SimpleDateFormat formatd = new SimpleDateFormat ("d.M.yyyy");
        
        jTextField2.setText(formatd.format(d));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Date d = new Date();
        JCalendarDialog.showCalendar(jButton3, d);
        SimpleDateFormat formatd = new SimpleDateFormat ("d.M.yyyy");
        
        jTextField3.setText(formatd.format(d));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        if(jSlider1.isEnabled()){
            if( jSlider1.getValue() == 0)
                jLabel1.setText(TAX_9_5);
            else if(jSlider1.getValue() == 1)
                jLabel1.setText(TAX_22);
        }
        else{
            jLabel1.setText("");
        }
    }//GEN-LAST:event_jSlider1StateChanged

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        jSlider1.setEnabled( !jSlider1.isEnabled());
        jSlider1StateChanged(null);
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void m_jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jButtonCancelActionPerformed
        dispose();
    }//GEN-LAST:event_m_jButtonCancelActionPerformed

    private void m_jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jButtonResetActionPerformed
        jLabel1.setText("");
        jComboBox1.setSelectedItem("Račun");
        jSlider1.setEnabled(false);
        jCheckBox1.setSelected(false);
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
    }//GEN-LAST:event_m_jButtonResetActionPerformed
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JButton m_jButtonCancel;
    private javax.swing.JButton m_jButtonOk;
    private javax.swing.JButton m_jButtonReset;
    // End of variables declaration//GEN-END:variables
    
}

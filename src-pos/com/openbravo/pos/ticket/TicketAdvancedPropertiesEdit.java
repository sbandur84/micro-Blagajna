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
public class TicketAdvancedPropertiesEdit extends javax.swing.JDialog {
    Properties ticketProperties;
    public static final String DOCTYPE = "DOCTYPE";
    public static final String BINDINGDOC = "BINDINGDOC";
    public static final String CASHDATE = "CASHDATE";
    public static final String SERVICEDATE = "SERVICEDATE";
    public static final String DELIVERYDATE = "DELIVERYDATE";
    public static final String REFERENCE = "REFERENCE";
    public static final String REVERSETAX = "REVERSETAX";
    public static final String SPECIALTAX = "SPECIALTAX";
    public static final String REVERSETAXEU = "REVERSETAXEU";
    public static final String TAG = "person";
    public static final String TAX_22 = "DDV 22 %";
    public static final String TAX_9_5 = "DDV 9,5 %";
    public static final String ZDDV46 = "1. točka 46. člena";
    public static final String ZDDV76 = "76.a člen";
    public static final String ZDDV110 = "110. člen";
    public static final String ZDDV4A44 = "4.a točka 44.člena";
    
    /** Creates new form JTicketsBagSharedList */
    private TicketAdvancedPropertiesEdit(java.awt.Frame parent, boolean modal,Properties prop) {
        super(parent, modal);
        ticketProperties = prop;
        initComponents();
        init();
    }
    /** Creates new form JTicketsBagSharedList */
    private TicketAdvancedPropertiesEdit(java.awt.Dialog parent, boolean modal,Properties prop) {
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
            jFormattedTextField1.setText(ticketProperties.getProperty(SERVICEDATE));
        
        if(ticketProperties.containsKey(DELIVERYDATE))
            jFormattedTextField2.setText(ticketProperties.getProperty(DELIVERYDATE));
        
        if(ticketProperties.containsKey(CASHDATE))
            jFormattedTextField3.setText(ticketProperties.getProperty(CASHDATE));
        
        if(ticketProperties.containsKey(REFERENCE))
            jTextField4.setText(ticketProperties.getProperty(REFERENCE));
        
        if(ticketProperties.containsKey(TAG))
            jTextField5.setText(ticketProperties.getProperty(TAG));
        
         if(ticketProperties.containsKey(BINDINGDOC))
            jTextField6.setText(ticketProperties.getProperty(BINDINGDOC));
        else
            ticketProperties.remove(BINDINGDOC);
        if (ticketProperties.containsKey(SPECIALTAX)){
            jCheckBox1.setSelected(true);
            jComboBox2.setEnabled(false);
            jComboBox3.setEnabled(true);
            jComboBox3.setSelectedItem(ticketProperties.getProperty(SPECIALTAX));
            
        }
        else if(ticketProperties.containsKey(REVERSETAX)){
            jCheckBox1.setSelected(true);
            jComboBox2.setEnabled(true);
            jComboBox3.setEnabled(true);
            jComboBox3.setSelectedItem(ZDDV76);
            
            if(ticketProperties.getProperty(REVERSETAX).equals(TAX_22)){
                for(int i=0; i<jComboBox2.getItemCount(); i++){
                    if(ticketProperties.getProperty(REVERSETAX).equals((String)jComboBox2.getItemAt(i)))
                        jComboBox2.setSelectedIndex(i);
                }
            }else if(ticketProperties.getProperty(REVERSETAX).equals(TAX_9_5)){
                for(int i=0; i<jComboBox2.getItemCount(); i++){
                    if(ticketProperties.getProperty(REVERSETAX).equals((String)jComboBox2.getItemAt(i)))
                        jComboBox2.setSelectedIndex(i);
                }
            }
        }
        else if(ticketProperties.containsKey(REVERSETAXEU)){
            jCheckBox1.setSelected(true);
            jComboBox2.setEnabled(true);
            jComboBox3.setEnabled(true);
            jComboBox3.setSelectedItem(ZDDV46);
            
            
            if(ticketProperties.getProperty(REVERSETAXEU).equals(TAX_22)){
                for(int i=0; i<jComboBox2.getItemCount(); i++){
                    if(ticketProperties.getProperty(REVERSETAXEU).equals((String)jComboBox2.getItemAt(i)))
                        jComboBox2.setSelectedIndex(i);
                }
            }else if(ticketProperties.getProperty(REVERSETAXEU).equals(TAX_9_5)){
                for(int i=0; i<jComboBox2.getItemCount(); i++){
                    if(ticketProperties.getProperty(REVERSETAXEU).equals((String)jComboBox2.getItemAt(i)))
                        jComboBox2.setSelectedIndex(i);
                }
            }
        }
        else{
                jCheckBox1.setSelected(false);
                jComboBox2.setEnabled(false);
                jComboBox3.setEnabled(false);
        }       
    }     
            
           
    
    /**
     *
     * @param parent
     * @param prop
     * @return
     */
    public static TicketAdvancedPropertiesEdit newJDialog(Window parent, Properties prop) {
        
        Window window = getWindow(parent);
        TicketAdvancedPropertiesEdit mydialog;
        if (window instanceof Frame) { 
            mydialog = new TicketAdvancedPropertiesEdit((Frame) window, true, prop);
            mydialog.setResizable(false);
        } else {
            mydialog = new TicketAdvancedPropertiesEdit((Dialog) window, true, prop);
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
        jPanel14 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jPanel11 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jComboBox3 = new javax.swing.JComboBox();
        jPanel12 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox();
        jPanel15 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();

        setTitle(AppLocal.getIntString("caption.ticketproperties")); // NOI18N

        jPanel3.setMinimumSize(new java.awt.Dimension(300, 50));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 60));

        m_jButtonCancel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jButtonCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/cancel.png"))); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("pos_messages"); // NOI18N
        m_jButtonCancel.setToolTipText(bundle.getString("Button.Cancel")); // NOI18N
        m_jButtonCancel.setFocusPainted(false);
        m_jButtonCancel.setFocusable(false);
        m_jButtonCancel.setMargin(new java.awt.Insets(8, 16, 8, 16));
        m_jButtonCancel.setPreferredSize(new java.awt.Dimension(80, 50));
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
        m_jButtonReset.setToolTipText(bundle.getString("Button.Reset")); // NOI18N
        m_jButtonReset.setFocusPainted(false);
        m_jButtonReset.setFocusable(false);
        m_jButtonReset.setMargin(new java.awt.Insets(8, 16, 8, 16));
        m_jButtonReset.setPreferredSize(new java.awt.Dimension(80, 50));
        m_jButtonReset.setRequestFocusEnabled(false);
        m_jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jButtonResetActionPerformed(evt);
            }
        });
        jPanel3.add(m_jButtonReset);

        m_jButtonOk.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jButtonOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/ok.png"))); // NOI18N
        m_jButtonOk.setToolTipText(bundle.getString("Button.OK")); // NOI18N
        m_jButtonOk.setFocusPainted(false);
        m_jButtonOk.setFocusable(false);
        m_jButtonOk.setMargin(new java.awt.Insets(8, 16, 8, 16));
        m_jButtonOk.setPreferredSize(new java.awt.Dimension(80, 50));
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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Račun", "Predračun" }));
        jComboBox1.setSelectedItem("");
        jComboBox1.setPreferredSize(new java.awt.Dimension(189, 30));
        jPanel1.add(jComboBox1);

        jPanel6.add(jPanel1);

        jPanel14.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel14.setLayout(new javax.swing.BoxLayout(jPanel14, javax.swing.BoxLayout.LINE_AXIS));

        jLabel6.setText("Oznaka");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel6.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel14.add(jLabel6);

        jTextField5.setPreferredSize(new java.awt.Dimension(20, 10));
        jPanel14.add(jTextField5);

        jPanel6.add(jPanel14);

        jPanel9.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        jLabel5.setText("Referenca");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel5.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel9.add(jLabel5);

        jTextField4.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel9.add(jTextField4);

        jPanel6.add(jPanel9);

        jPanel2.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jLabel2.setText("Datum storitve");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel2.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel2.add(jLabel2);

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM))));
        jFormattedTextField1.setPreferredSize(new java.awt.Dimension(60, 20));
        jPanel2.add(jFormattedTextField1);

        jPanel6.add(jPanel2);

        jPanel7.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        jLabel3.setText("Datum dobave");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel3.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel7.add(jLabel3);

        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM))));
        jFormattedTextField2.setPreferredSize(new java.awt.Dimension(60, 20));
        jPanel7.add(jFormattedTextField2);

        jPanel6.add(jPanel7);

        jPanel8.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));

        jLabel4.setText("Datum valute");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel4.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel8.add(jLabel4);

        jFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM))));
        jFormattedTextField3.setPreferredSize(new java.awt.Dimension(60, 20));
        jPanel8.add(jFormattedTextField3);

        jPanel6.add(jPanel8);

        jPanel11.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.LINE_AXIS));

        jCheckBox1.setPreferredSize(new java.awt.Dimension(30, 23));
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel11.add(jCheckBox1);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "110. člen", "4.a točka 44.člena" }));
        jPanel11.add(jComboBox3);

        jPanel12.setPreferredSize(new java.awt.Dimension(0, 10));
        jPanel11.add(jPanel12);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DDV 22 %", "DDV 9,5 %" }));
        jPanel11.add(jComboBox2);

        jPanel6.add(jPanel11);

        jPanel15.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel15.setLayout(new javax.swing.BoxLayout(jPanel15, javax.swing.BoxLayout.LINE_AXIS));

        jLabel7.setText("Vezni dokument");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel7.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel15.add(jLabel7);

        jTextField6.setPreferredSize(new java.awt.Dimension(20, 10));
        jPanel15.add(jTextField6);

        jPanel6.add(jPanel15);

        getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(341, 454));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void m_jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jButtonOkActionPerformed

        ticketProperties.setProperty(DOCTYPE, (String)jComboBox1.getSelectedItem());
        
        if(jFormattedTextField1.getText().length()>2)
            ticketProperties.setProperty(SERVICEDATE, jFormattedTextField1.getText());
        else
            ticketProperties.remove(SERVICEDATE);
        
        
        if(jFormattedTextField2.getText().length()>2)
            ticketProperties.setProperty(DELIVERYDATE, jFormattedTextField2.getText());
        else
            ticketProperties.remove(DELIVERYDATE);
        
        
        if(jFormattedTextField3.getText().length()>2)
            ticketProperties.setProperty(CASHDATE, jFormattedTextField3.getText());
        else
            ticketProperties.remove(CASHDATE);
        
        
        if(jTextField4.getText().length()>2)
            ticketProperties.setProperty(REFERENCE, jTextField4.getText());
        else
            ticketProperties.remove(REFERENCE);
        
        
        if(jCheckBox1.isSelected()){
            if(jComboBox3.getSelectedItem().equals(ZDDV4A44) || jComboBox3.getSelectedItem().equals(ZDDV110)){
                ticketProperties.setProperty(SPECIALTAX, jComboBox3.getSelectedItem().toString());
            }
            else if (jComboBox3.getSelectedItem().equals(ZDDV76)){
                ticketProperties.setProperty(REVERSETAX, jComboBox2.getSelectedItem().toString());
                ticketProperties.remove(REVERSETAXEU);
            }
            else{
                ticketProperties.setProperty(REVERSETAXEU, jComboBox2.getSelectedItem().toString());
                ticketProperties.remove(REVERSETAX);
            }
        }
        else{
            ticketProperties.remove(REVERSETAX);
            ticketProperties.remove(SPECIALTAX);
            ticketProperties.remove(REVERSETAXEU);
            jCheckBox1.setSelected(false);
            jComboBox2.setEnabled(false);
            jComboBox3.setEnabled(false);
        }
          
        
        
        if(!jTextField5.getText().isEmpty())
            ticketProperties.setProperty(TAG, jTextField5.getText());
        else
            ticketProperties.remove(TAG);
        
        
        if(!jTextField6.getText().isEmpty())
            ticketProperties.setProperty(BINDINGDOC, jTextField6.getText());
        else
            ticketProperties.remove(BINDINGDOC);
            
            
        
        
        
        
        dispose();
        
    }//GEN-LAST:event_m_jButtonOkActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jComboBox3.getSelectedItem().toString().equals(ZDDV110) 
                || jComboBox3.getSelectedItem().toString().equals(ZDDV4A44)){
            jComboBox2.setEnabled(false);
        }
        else{
            jComboBox2.setEnabled( !jComboBox2.isEnabled());
        }
        
        jComboBox3.setEnabled( !jComboBox3.isEnabled());
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void m_jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jButtonCancelActionPerformed
        dispose();
    }//GEN-LAST:event_m_jButtonCancelActionPerformed

    private void m_jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jButtonResetActionPerformed
        jComboBox1.setSelectedItem("Račun");
        jCheckBox1.setSelected(false);
        jFormattedTextField1.setText("");
        jFormattedTextField2.setText("");
        jFormattedTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
    }//GEN-LAST:event_m_jButtonResetActionPerformed
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JButton m_jButtonCancel;
    private javax.swing.JButton m_jButtonOk;
    private javax.swing.JButton m_jButtonReset;
    // End of variables declaration//GEN-END:variables
    
}

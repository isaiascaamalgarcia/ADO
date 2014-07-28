/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facturador;

import com.sun.glass.events.KeyEvent;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.Date;

/**
 *
 * @author Alejandro
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
        public String[] service = new String[15];
        public String[] precio = new String[15];
        public String nombre;
        public String rfc;
        public String direc;
        public String cp;
        public String email;
        public String nacionaldad;
        public String servicio;
        public String folio = "2";
        public String cantidad;
        public String costo;
        public String subt;
        public String total;
        public String comen;
        
        
    
    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
        jPanel1.setVisible(false);
        HideError1();
        RefreshService();
        FieldCost.setEditable(false);
        FieldStotal.setEditable(false);
        FieldTotal.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LblImage = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        LblFolio = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        FieldCant = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        FieldCost = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        FieldStotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        FieldTotal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        FieldNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        FieldDirecion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Fieldpostal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        Fieldmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        FieldRFC = new javax.swing.JTextField();
        ErrorName = new javax.swing.JLabel();
        ErrorDirect = new javax.swing.JLabel();
        ErrorCP = new javax.swing.JLabel();
        ErrorEmail = new javax.swing.JLabel();
        ErrorRFC = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();
        Image3 = new javax.swing.JLabel();
        AlertMessage = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LblImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LblImageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LblImageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LblImageMouseExited(evt);
            }
        });
        getContentPane().add(LblImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 110, 80));
        ImageIcon image3 = new ImageIcon(getClass().getResource("/img/cliente.png"));
        Image imgEscalada3 = image3.getImage().getScaledInstance(110, 80, Image.SCALE_SMOOTH);
        Icon iconoScalado3 = new ImageIcon(imgEscalada3);
        LblImage.setIcon(iconoScalado3);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LblFolio.setText("Folio");
        jPanel1.add(LblFolio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel7.setText("Servicio");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione un servicio" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 140, -1));

        jLabel8.setText("Cantidad");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        FieldCant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldCantActionPerformed(evt);
            }
        });
        FieldCant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FieldCantKeyTyped(evt);
            }
        });
        jPanel1.add(FieldCant, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 140, -1));

        jLabel9.setText("Costo");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        FieldCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FieldCostKeyTyped(evt);
            }
        });
        jPanel1.add(FieldCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 140, -1));

        jLabel10.setText("Subtotal");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        FieldStotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FieldStotalKeyTyped(evt);
            }
        });
        jPanel1.add(FieldStotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 140, -1));

        jLabel11.setText("Total");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        FieldTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FieldTotalKeyTyped(evt);
            }
        });
        jPanel1.add(FieldTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 140, -1));

        jLabel12.setText("Comentario");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 210, 220));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 430, 310));

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 20));

        FieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FieldNombreKeyTyped(evt);
            }
        });
        jPanel2.add(FieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 160, -1));

        jLabel3.setText("Dirección");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 20));
        jPanel2.add(FieldDirecion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 160, -1));

        jLabel5.setText("Codigo postal");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 20));

        Fieldpostal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FieldpostalKeyTyped(evt);
            }
        });
        jPanel2.add(Fieldpostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 160, -1));

        jLabel6.setText("Nacionalidad");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, 20));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mexicana", "Extranjero" }));
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 160, -1));

        jLabel4.setText("e-mail");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 20));
        jPanel2.add(Fieldmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 160, -1));

        jLabel2.setText("RFC");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, 20));

        FieldRFC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FieldRFCKeyTyped(evt);
            }
        });
        jPanel2.add(FieldRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 160, 30));

        ErrorName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ErrorName.setForeground(new java.awt.Color(204, 0, 0));
        ErrorName.setText("*");
        jPanel2.add(ErrorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 10, 20));

        ErrorDirect.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ErrorDirect.setForeground(new java.awt.Color(204, 0, 0));
        ErrorDirect.setText("*");
        jPanel2.add(ErrorDirect, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 10, 20));

        ErrorCP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ErrorCP.setForeground(new java.awt.Color(204, 0, 0));
        ErrorCP.setText("*");
        jPanel2.add(ErrorCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 10, 20));

        ErrorEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ErrorEmail.setForeground(new java.awt.Color(204, 0, 0));
        ErrorEmail.setText("*");
        jPanel2.add(ErrorEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 10, 20));

        ErrorRFC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ErrorRFC.setForeground(new java.awt.Color(204, 0, 0));
        ErrorRFC.setText("*");
        jPanel2.add(ErrorRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 10, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 430, 310));

        Logo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LogoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LogoMouseExited(evt);
            }
        });
        getContentPane().add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 110, 80));
        ImageIcon image = new ImageIcon(getClass().getResource("/img/producto.png"));
        Image imgEscalada = image.getImage().getScaledInstance(110, 80, Image.SCALE_SMOOTH);
        Icon iconoScalado = new ImageIcon(imgEscalada);
        Logo.setIcon(iconoScalado);

        Image3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Image3MouseClicked(evt);
            }
        });
        getContentPane().add(Image3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, 110, 80));
        ImageIcon image2 = new ImageIcon(getClass().getResource("/img/enviar.png"));
        Image imgEscalada2 = image2.getImage().getScaledInstance(110,80, Image.SCALE_SMOOTH);
        Icon iconoScalado2 = new ImageIcon(imgEscalada2);
        Image3.setIcon(iconoScalado2);

        AlertMessage.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        AlertMessage.setForeground(new java.awt.Color(255, 255, 255));
        AlertMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(AlertMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 750, 20));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bgmenu.PNG"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FieldNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FieldNombreKeyTyped
        char c = evt.getKeyChar();
        if(Character.isDigit(c)){
            evt.consume();
        }
            
        
    }//GEN-LAST:event_FieldNombreKeyTyped

    private void FieldpostalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FieldpostalKeyTyped
        char c= evt.getKeyChar();
        String cadena = Fieldpostal.getText();
        if(!Character.isDigit(c) || cadena.length() > 4 || c == KeyEvent.VK_DELETE){
            evt.consume();
        }
    }//GEN-LAST:event_FieldpostalKeyTyped

    private void FieldRFCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FieldRFCKeyTyped
        // TODO add your handling code here:
        String cadena = FieldRFC.getText();
        if(cadena.length() > 12){
            evt.consume();
        }
    }//GEN-LAST:event_FieldRFCKeyTyped
    
    public void RefreshService(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carwash","root","g4rs14");
            Statement st = cn.createStatement();
            ResultSet row = st.executeQuery("Select * from servicio;");
            int cont = 0;
            while(row.next()){
                jComboBox2.addItem(row.getObject("descripcion"));
                precio[cont] = String.valueOf(row.getObject("precio"));
            }
        }catch(Exception e){
            System.out.println();
        }
    }
    
    private void LogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoMouseClicked
        // TODO add your handling code here:
        ConexDBase model = new ConexDBase();
        folio = model.getFolio();
        LblFolio.setText("Folio: "+folio);
        nombre = FieldNombre.getText();
        rfc = FieldRFC.getText();
        direc = FieldDirecion.getText();
        cp = Fieldpostal.getText();
        email = Fieldmail.getText();
        nacionaldad = String.valueOf(jComboBox1.getSelectedItem());
        if(nombre.length() * rfc.length() * direc.length() * cp.length() * cp.length() * email.length() * nacionaldad.length() == 0){
            AlertMessage.setText("Complete todos lo campos");
        }
        else{
            boolean mail = CheckEmail(email);
            boolean name = CheckNombre(nombre);
            boolean rc = CheckRFC(rfc);
            boolean cpostal = CheckCp(cp);
            boolean drecion = CheckDirec(direc);
            if(mail && name && rc && cpostal && drecion){
                jPanel1.setVisible(true);
                jPanel2.setVisible(false);
                AlertMessage.setText("Datos correctos");
            }
            else{
                AlertMessage.setText("Hay campos que son erroneos");
            }
        }
            
    }//GEN-LAST:event_LogoMouseClicked

    private void LogoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoMouseEntered
        // TODO add your handling code here:
        setCursor(HAND_CURSOR);
    }//GEN-LAST:event_LogoMouseEntered

    private void LogoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoMouseExited
        // TODO add your handling code here:
        setCursor(DEFAULT_CURSOR);
    }//GEN-LAST:event_LogoMouseExited

    private void LblImageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblImageMouseEntered
        // TODO add your handling code here:
        setCursor(HAND_CURSOR);
    }//GEN-LAST:event_LblImageMouseEntered

    private void LblImageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblImageMouseExited
        // TODO add your handling code here:
        setCursor(DEFAULT_CURSOR);
    }//GEN-LAST:event_LblImageMouseExited

    private void LblImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblImageMouseClicked
        // TODO add your handling code here:
        jPanel1.setVisible(false);
        jPanel2.setVisible(true);
    }//GEN-LAST:event_LblImageMouseClicked

    private void Image3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Image3MouseClicked
        // TODO add your handling code here:
        
        Date fecha = new Date();
        String fechaactual = String.valueOf(fecha.getDate())+"/"+String.valueOf(fecha.getMonth()+1)+"/"+String.valueOf(fecha.getYear()+1900);
        
        servicio = String.valueOf(jComboBox2.getSelectedItem());
        
        cantidad = FieldCant.getText();
        costo = FieldCost.getText();
        subt = FieldStotal.getText();
        total = FieldTotal.getText();
        comen = jTextArea1.getText();
        if(comen.equals("")){
            comen = "sin comentario";
        }
        if(servicio.equals("") || cantidad.equals("") || costo.equals("") || subt.equals("") || total.equals("")){
            AlertMessage.setText("Llene todos los campos");
        }else{
            ConexDBase model = new ConexDBase();
            model.InsertFactura(folio, rfc, nombre, direc, email, cp, nacionaldad, servicio, cantidad, costo, subt, total, comen, "Realizada");
            
            Data.setCANTIDAD(cantidad);
            Data.setCODIGO_POSTAL(cp);
            Data.setCOMENTARIO(comen);
            Data.setCOSTO(costo);
            Data.setDIRECCION(direc);
            Data.setEMAIL(email);
            Data.setFOLIO(folio);
            Data.setNACIONALIDAD(nacionaldad);
            Data.setNOMBRE(nombre);
            Data.setRFC(rfc);
            Data.setSERVICIO(servicio);
            Data.setSUBTOTAL(subt);
            Data.setTOTAL(total);
            Data.setFECHA(fechaactual);
            Factura mostrar = new Factura();
            mostrar.setVisible(true);
        }
        
    }//GEN-LAST:event_Image3MouseClicked

    private void FieldCantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FieldCantKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)) 
            evt.consume();
        else{
        }
    }//GEN-LAST:event_FieldCantKeyTyped

    private void FieldCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FieldCostKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!Character.isDigit(c))
            evt.consume();
    }//GEN-LAST:event_FieldCostKeyTyped

    private void FieldStotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FieldStotalKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!Character.isDigit(c))
            evt.consume();
    }//GEN-LAST:event_FieldStotalKeyTyped

    private void FieldTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FieldTotalKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!Character.isDigit(c))
            evt.consume();
    }//GEN-LAST:event_FieldTotalKeyTyped

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        // TODO add your handling code here:
        int serv = jComboBox2.getSelectedIndex();
        if(serv == 0){
            FieldCost.setText("0");
        }else{
            String cost = precio[serv-1];
            FieldCost.setText(cost);
        }
        System.out.println(serv);
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void FieldCantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldCantActionPerformed
        // TODO add your handling code here:
        
        if(FieldCant.getText().equals("") || FieldCost.getText().equals("")){
            if(FieldCost.getText().equals("")){
                AlertMessage.setText("Selecione un servicio");
            }else{
                AlertMessage.setText("Complete los campos requeridos");
            }
        }else{
            double cant = Double.valueOf(FieldCant.getText());
            double cost = Double.valueOf(FieldCost.getText());
            double stot = cant * cost;
            DecimalFormat dosDecimas = new DecimalFormat("0.00");
            FieldStotal.setText(dosDecimas.format(stot));
            FieldTotal.setText(dosDecimas.format(stot));
        }
    }//GEN-LAST:event_FieldCantActionPerformed
    public boolean CheckRFC(String rfc){
        if(rfc.length() == 13){
            ErrorRFC.setVisible(false);
            return true;
        }else{
            ErrorRFC.setVisible(true);
        }        
        return false;
    }
    public boolean CheckNombre(String nombre){
        if(nombre.length() > 1)
        {
            ErrorName.setVisible(false);
            return true;
        }else{
            ErrorName.setVisible(true);
        }
        return false;
    }
    public boolean CheckCp(String cp){
        if(cp.length() > 4){
            ErrorCP.setVisible(false);
            return true;
        }else
            ErrorCP.setVisible(true);
        return false;
    }
    public boolean CheckDirec(String direct){
        if(direct.length() > 10){
            ErrorDirect.setVisible(false);
            return true;
        }else
            ErrorDirect.setVisible(true);
        return false;
    }
    public boolean CheckEmail(String email){
        int tama = email.length();
        String arroba;
        if(email.length() > 12){
             arroba = email.substring(tama-10, tama);
             if(arroba.equals("@gmail.com")){
                 System.out.println("Email true");
                 ErrorEmail.setVisible(false);
                 return true;
             }
             else{
                 ErrorEmail.setVisible(true);
                 return false;
             }
                 
        }
        else{
            ErrorEmail.setVisible(true);
        }
        return false;
    }
    public void HideError1(){
        ErrorCP.setVisible(false);
        ErrorDirect.setVisible(false);
        ErrorEmail.setVisible(false);
        ErrorName.setVisible(false);
        ErrorRFC.setVisible(false);
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AlertMessage;
    private javax.swing.JLabel Background;
    private javax.swing.JLabel ErrorCP;
    private javax.swing.JLabel ErrorDirect;
    private javax.swing.JLabel ErrorEmail;
    private javax.swing.JLabel ErrorName;
    private javax.swing.JLabel ErrorRFC;
    private javax.swing.JTextField FieldCant;
    private javax.swing.JTextField FieldCost;
    private javax.swing.JTextField FieldDirecion;
    private javax.swing.JTextField FieldNombre;
    private javax.swing.JTextField FieldRFC;
    private javax.swing.JTextField FieldStotal;
    private javax.swing.JTextField FieldTotal;
    private javax.swing.JTextField Fieldmail;
    private javax.swing.JTextField Fieldpostal;
    private javax.swing.JLabel Image3;
    private javax.swing.JLabel LblFolio;
    private javax.swing.JLabel LblImage;
    private javax.swing.JLabel Logo;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}

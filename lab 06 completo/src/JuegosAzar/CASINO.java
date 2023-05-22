
package JuegosAzar;


import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class CASINO extends javax.swing.JFrame {
    int tra=0;
    int s1,s2,s3;
    int total;
    boolean detener= false;
    public void detenerHilos(){
        detener=true;
    }
    public synchronized void activarHilos(){
        detener=false;
        notifyAll();
        
    }
    Thread t;
    Thread t1;
    Thread t2;
    
    public CASINO() {
        this.t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    while (detener) {
                        synchronized (CASINO.this) {
                            try {
                                CASINO.this.wait();
                            }catch (InterruptedException e) {
                                // Manejar interrupción si es necesario
                            }
                        }
                    }
                    for (int k= 0; k<20; k++) {
                        int num= (int)(Math.random()*100+1);
                        stock3.setIcon(new ImageIcon(CASINO.this.getClass().getResource("/tragamonedas/obj/"+num%16+".jpg")));
                        
                        try{
                            Thread.sleep(100);
                        } catch(InterruptedException e){
                        }
                        if(k==19){
                            detenerHilos();
                        }
                        try {
                            Thread.sleep(120);
                        } catch (InterruptedException e) {
                            // Manejar interrupción si es necesario
                        }
                        
                        s3=(num%16)+1;
                        
                    }
                    if(s1==s2 || s1==s3 || s2==s3){
                        total=total+(total/2);
                        saldo.setText(String.valueOf(total));
                    } else if(s1==s2 && s1==s3 ){
                        total=total*2;
                        saldo.setText(String.valueOf(total));
                    } else{
                        total=total-10;
                        saldo.setText(String.valueOf(total));
                    }
                    
                    
                }
            }
        });
        this.t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    while (detener) {
                        synchronized (CASINO.this) {
                            try {
                                CASINO.this.wait();
                            }catch (InterruptedException e) {
                                // Manejar interrupción si es necesario
                            }
                        }
                    }
                    for (int k= 0; k<20; k++) {
                        int num= (int)(Math.random()*100+1);
                        stock2.setIcon(new ImageIcon(CASINO.this.getClass().getResource("/tragamonedas/obj/"+num%16+".jpg")));
                        
                        try{
                            Thread.sleep(100);
                        } catch(InterruptedException e){
                        }
                        if(k==19){
                            detenerHilos();
                        }
                        try {
                            Thread.sleep(110);
                        } catch (InterruptedException e) {
                            // Manejar interrupción si es necesario
                        }
                        
                        
                        s2=(num%16)+1;
                    }
                    
                    
                }
            }
        });
        this.t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    while (detener) {
                        synchronized (CASINO.this) {
                            try {
                                CASINO.this.wait();
                            }catch (InterruptedException e) {
                                // Manejar interrupción si es necesario
                            }
                        }
                    }
                    for (int k = 0; k<20; k++) {
                        int num= (int)(Math.random()*100+1);
                        stock1.setIcon(new ImageIcon(CASINO.this.getClass().getResource("/tragamonedas/obj/"+num%16+".jpg")));
                        
                        try{
                            Thread.sleep(100);
                        } catch(InterruptedException e){
                        }
                        if(k==19){
                            detenerHilos();
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            // Manejar interrupción si es necesario
                        }
                        s1=(num%16)+1;
                    }
                }
            }
        });
        initComponents();
       
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
        stock2 = new javax.swing.JLabel();
        stock3 = new javax.swing.JLabel();
        stock1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        saldo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(stock2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 110, 170));
        jPanel1.add(stock3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 110, 150));
        jPanel1.add(stock1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 110, 170));

        jButton1.setBackground(new java.awt.Color(198, 130, 63));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 20, 20));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 3, 36)); // NOI18N
        jLabel2.setText("............... COINS .................");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, -1, -1));

        saldo.setFont(new java.awt.Font("STZhongsong", 3, 48)); // NOI18N
        saldo.setText("XXX");
        jPanel1.add(saldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 520, 250, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JuegosAzar/fondito.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 440));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 3, 48)); // NOI18N
        jLabel3.setText("$$");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 520, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tra++;
        
        if(total<=0){
            saldo.setText("0");
            total= Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa cual es tu dinero inicial"));
            saldo.setText(String.valueOf(total));
        }
        if(tra==1){
            t.start();
            t1.start();
            t2.start();
        } else{
          activarHilos(); 
          
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(CASINO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CASINO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CASINO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CASINO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CASINO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel saldo;
    private javax.swing.JLabel stock1;
    private javax.swing.JLabel stock2;
    private javax.swing.JLabel stock3;
    // End of variables declaration//GEN-END:variables
}

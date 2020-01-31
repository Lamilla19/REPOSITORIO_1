/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class InterfazdelJuego extends javax.swing.JFrame {

    /**
     * Creates new form Window
     */
    
    public InterfazdelJuego() {
        super("Batalla de acorazados 1.0");
        initComponents();
        stickers=new JLabel[10][10];
        setLocationRelativeTo(null);
        llenarMapa();
        cajaDeTexto.setBackground(Color.BLACK);
        cajaDeTexto.setForeground(Color.CYAN);
        
      
    }

   JLabel[][] stickers;

     public void MuestraMar(){
    MarcoMar.removeAll();
    MarcoMar.setVisible(false);
    for(int i=0;i<10;i++){
         for(int j=0;j<10;j++){
            stickers[i][j]=new JLabel();
            if(proyectofinal.barc[i][j]==0 || proyectofinal.barc[i][j]==5 ){
            stickers[i][j].setIcon(new ImageIcon("src//widgets//fondomar1.jpg"));
                }
                 if(proyectofinal.barc[i][j]==1){
                  stickers[i][j].setIcon(new ImageIcon("src//widgets//barco2sano.jpg"));
                   }
                      if(proyectofinal.barc[i][j]==2){
                       stickers[i][j].setIcon(new ImageIcon("src//widgets//barco1sano.jpg"));
                       }
                         if(proyectofinal.barc[i][j]==3){
                        stickers[i][j].setIcon(new ImageIcon("src//widgets//fuego_1.jpg"));
                          }
                           if(proyectofinal.barc[i][j]==4){
                           stickers[i][j].setIcon(new ImageIcon("src//widgets//fuego.jpg"));
                            }
                             MarcoMar.add(stickers[i][j]);
         }
    }
    MarcoMar.setVisible(true);
    }
         public void llenarMapa(){
          MarcoMar.setLayout(new GridLayout(10,10));
        MarcoMar.removeAll();
         otrapartida.setEnabled(false);
         botonjugar.setEnabled(false);
         botoneditar.setEnabled(false);
        MarcoMar.setVisible(false);
            proyectofinal.barcosJ=0;
            proyectofinal.barcosC=0;
    for(int i=0;i<10;i++){
         for(int j=0;j<10;j++){
            stickers[i][j]=new JLabel();
            stickers[i][j].setIcon(new ImageIcon("src//widgets//fondomar1.jpg"));
            MarcoMar.add(stickers[i][j]);
            asignamos(i,j);
          
         }
    }
    proyectofinal.llenarCeros();
    MarcoMar.setVisible(true);
    }
   
    public void asignamos(int x,int y){
    stickers[x][y].addMouseListener(new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent me) {
         if(proyectofinal.barc[x][y]==0 && proyectofinal.barcosJ < 5)
         {
         proyectofinal.barc[x][y]=2;
         proyectofinal.barcosJ ++ ;
         stickers[x][y].setIcon(new ImageIcon("src//widgets//barco1sano.jpg"));
            if(proyectofinal.barcosJ >=5){
              colocarCompu();
              botoneditar.setEnabled(true);
              botonjugar.setEnabled(true);
           }
         }
         
        }

        @Override
        public void mousePressed(MouseEvent me) {
        
        }
       //no sirve
        @Override
        public void mouseReleased(MouseEvent me) {
            
        }
        @Override
        public void mouseEntered(MouseEvent me) {
            
            
        }
        @Override
        public void mouseExited(MouseEvent me) {
            
            
            
        }
    });
    }
    public void EnJuego(){
        MarcoMar.removeAll();
        MarcoMar.setVisible(false);
    for(int i=0;i<10;i++){
         for(int j=0;j<10;j++){
            stickers[i][j]=new JLabel();
            stickers[i][j].setIcon(new ImageIcon("src//widgets//fondomar1.jpg"));
            Ataques(i,j);
            MarcoMar.add(stickers[i][j]);
         }
    }
    MarcoMar.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MarcoMar = new javax.swing.JPanel();
        botonjugar = new javax.swing.JButton();
        botoneditar = new javax.swing.JButton();
        otrapartida = new javax.swing.JButton();
        instuccionesTxt = new javax.swing.JScrollPane();
        datos = new javax.swing.JTextArea();
        avisos = new javax.swing.JScrollPane();
        cajaDeTexto = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Batalla de acorazados 1.0");
        setBackground(new java.awt.Color(51, 153, 255));
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

        javax.swing.GroupLayout MarcoMarLayout = new javax.swing.GroupLayout(MarcoMar);
        MarcoMar.setLayout(MarcoMarLayout);
        MarcoMarLayout.setHorizontalGroup(
            MarcoMarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        MarcoMarLayout.setVerticalGroup(
            MarcoMarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        botonjugar.setBackground(new java.awt.Color(51, 153, 255));
        botonjugar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        botonjugar.setText("JUGAR  <▓>");
        botonjugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonjugarActionPerformed(evt);
            }
        });

        botoneditar.setBackground(new java.awt.Color(51, 204, 255));
        botoneditar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        botoneditar.setText("Editar <▒>");
        botoneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoneditarActionPerformed(evt);
            }
        });

        otrapartida.setBackground(new java.awt.Color(0, 204, 255));
        otrapartida.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        otrapartida.setText("Otra partida?");
        otrapartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otrapartidaActionPerformed(evt);
            }
        });

        datos.setEditable(false);
        datos.setBackground(new java.awt.Color(204, 204, 204));
        datos.setColumns(20);
        datos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        datos.setRows(5);
        datos.setText("Antes de jugar:\nColoca tus 5 barcos a tu antojo\npuedes editar si quieres cambiar\nsus localizaciones.");
        datos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        instuccionesTxt.setViewportView(datos);

        cajaDeTexto.setEditable(false);
        cajaDeTexto.setColumns(20);
        cajaDeTexto.setRows(5);
        avisos.setViewportView(cajaDeTexto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MarcoMar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(otrapartida, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonjugar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botoneditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(avisos, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(instuccionesTxt)
                        .addGap(4, 4, 4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MarcoMar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonjugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(botoneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(otrapartida, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(avisos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(instuccionesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botoneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoneditarActionPerformed
    llenarMapa();
        botonjugar.setEnabled(false);
        botoneditar.setEnabled(false);
    }//GEN-LAST:event_botoneditarActionPerformed

    private void botonjugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonjugarActionPerformed
    EnJuego();
        botonjugar.setEnabled(false);
        botoneditar.setEnabled(false);
    }//GEN-LAST:event_botonjugarActionPerformed

    private void otrapartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otrapartidaActionPerformed
    llenarMapa();
    cajaDeTexto.setText("");
    otrapartida.setEnabled(false);
    }//GEN-LAST:event_otrapartidaActionPerformed
    public void Ataques(int n1,int n2){
        stickers[n1][n2].addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent me) {
            if(proyectofinal.barc[n1][n2]== 1 || proyectofinal.barc[n1][n2]== 2 || proyectofinal.barc[n1][n2]== 0)
            {
            if(proyectofinal.barc[n1][n2]== 1){
              cajaDeTexto.setText("  Hundimos un barco de la flota enemiga.\n");
              proyectofinal.barc[n1][n2]= 3;
             proyectofinal.barcosC -- ;
              stickers[n1][n2].setIcon(new ImageIcon("src//widgets//fuego_1.jpg"));
              }
                if(proyectofinal.barc[n1][n2]== 2){
                cajaDeTexto.setText("  Acabamos de hundir un barco de los nuestros.\n");
                proyectofinal.barc[n1][n2]= 4;
                proyectofinal.barcosJ -- ;
                 stickers[n1][n2].setIcon(new ImageIcon("src//widgets//fuego.jpg"));
                }
                  if(proyectofinal.barc[n1][n2]== 0){
                  cajaDeTexto.setText("  La artillería falló.\n");
                 proyectofinal.barc[n1][n2]= 5;
                  stickers[n1][n2].setIcon(new ImageIcon("src//widgets//mar.jpg"));
                  }
                      if(proyectofinal.barcosJ>0 && proyectofinal.barcosC>0){
                     CompuAtaque();
                       }else{
                        otrapartida.setEnabled(true);
                         MuestraMar();
                          if(proyectofinal.barcosJ==0){
                          cajaDeTexto.setText("\n\n   Toda nuestra flota fué hundida ");
                          }else{
                          cajaDeTexto.setText("\n\n   Salimos victoriosos ");
                          }
                          } 
                     }
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }
            @Override
            public void mouseReleased(MouseEvent me) {
            }
            @Override
            public void mouseEntered(MouseEvent me) {
            }
            @Override
            public void mouseExited(MouseEvent me) {
            }
        
        });
    }
    public void CompuAtaque(){
     int r1=0;
     int r2=0;
        do{
            r1=(int)(Math.random()*10);
            r2=(int)(Math.random()*10);
          }while(proyectofinal.barc[r1][r2] >=3);
          if(proyectofinal.barc[r1][r2]== 1){
               cajaDeTexto.setText(cajaDeTexto.getText()+"  Hundieron un barco de su propia flota.\n");
              proyectofinal.barc[r1][r2]= 3;
               proyectofinal.barcosC -- ;
                stickers[r1][r2].setIcon(new ImageIcon("src//widgets//fuego_1.jpg"));
                }
                 if(proyectofinal.barc[r1][r2]== 2){
                      cajaDeTexto.setText(cajaDeTexto.getText()+"  Hundieron uno de nuestros mejores barcos.\n");
                      proyectofinal.barc[r1][r2]= 4;
                      proyectofinal.barcosJ -- ;
                   stickers[r1][r2].setIcon(new ImageIcon("src//widgets//fuego.jpg"));
            }
          if(proyectofinal.barc[r1][r2]== 0){
            cajaDeTexto.setText(cajaDeTexto.getText()+"  Tienen mala puntería , fallaron.\n");
            proyectofinal.barc[r1][r2]= 5;
            stickers[r1][r2].setIcon(new ImageIcon("src//widgets//mar.jpg"));
            }
                 cajaDeTexto.setText(cajaDeTexto.getText()+"\n  Jugador : "+proyectofinal.barcosJ);
                 cajaDeTexto.setText(cajaDeTexto.getText()+"\n  Computadora : "+proyectofinal.barcosC);
                  if(proyectofinal.barcosJ==0||proyectofinal.barcosC==0){
                   MuestraMar();
                        otrapartida.setEnabled(true);
                   if(proyectofinal.barcosJ==0){
                      cajaDeTexto.setText("\n\n   Toda nuestra flota fué hundida ");
                     }else{
                       cajaDeTexto.setText("\n\n   Salimos victoriosos ");
                         }
            }
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
            java.util.logging.Logger.getLogger(InterfazdelJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazdelJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazdelJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazdelJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazdelJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MarcoMar;
    private javax.swing.JScrollPane avisos;
    private javax.swing.JButton botoneditar;
    private javax.swing.JButton botonjugar;
    private javax.swing.JTextArea cajaDeTexto;
    private javax.swing.JTextArea datos;
    private javax.swing.JScrollPane instuccionesTxt;
    private javax.swing.JButton otrapartida;
    // End of variables declaration//GEN-END:variables
 public void colocarCompu(){
        int aux1;
        int aux2;
        
      for(int sub=0;sub<5;sub++){
           do{
            aux1=(int)(Math.random()*10);
            aux2=(int)(Math.random()*10);
               }while(proyectofinal.barc[aux1][aux2]!=0);
           
           
           proyectofinal.barc[aux1][aux2]=1;
           proyectofinal.barcosC ++ ;
           }
    }
}

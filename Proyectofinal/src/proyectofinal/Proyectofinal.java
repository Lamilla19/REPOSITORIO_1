/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

  
public class proyectofinal {
  
    /**
     * @param args the command line arguments
     */
    public static int[][] barc;
    static int barcosJ;
    static int barcosC;
    public static void main(String[] args) {
    llenarCeros();
    new InterfazdelJuego().setVisible(true);
    }
    static void llenarCeros(){
      barc=new int[10][10];
     for(int i=0;i<10;i++){
         for(int j=0;j<10;j++){
                barc[i][j]=0;
                }
    }
    }
    
}

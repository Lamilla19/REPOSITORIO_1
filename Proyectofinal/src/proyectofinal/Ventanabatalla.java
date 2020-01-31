package proyectofinal;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Ventanabatalla extends Thread {

Navalbatalla batallaNaval = new Navalbatalla();
JFrame frame;
JButton [][] botones = new JButton[10][10];
JButton vaciar = new JButton("REINICIAR");
JButton salir = new JButton("SALIR DEL JUEGO ");
JButton completar = new JButton();
JButton cambiarJ = new JButton("CAMBIAR JUGADORES");
JButton maquina = new JButton("1 JUGADOR ");

JLabel mensajeVentana1 = new JLabel("--S E L E C C I O N E C A N T I D A D -- ");// mensaje que sale por pantalla en la mitad 
JLabel mensajeVentana2 = new JLabel("--D E J U G A D O R E S --");
JLabel mensajeVentana3 = new JLabel();
JLabel mensajeVentana4 = new JLabel();
JLabel jugador1 = new JLabel();
JLabel jugador2 = new JLabel();
JLabel j1 = new JLabel();
Timer timer = new Timer();
final JLabel imagenPre = new JLabel();
JLabel j2 = new JLabel();
JButton turno1 = new JButton("TURNO DE JUGADOR 1 ");
JButton turno2 = new JButton("TURNO DE JUGADOR 2 ");
Navalbatalla batallaNaval2 = new Navalbatalla();
private int uno;
private int dos;
public void crearGUI() {
                frame = new JFrame("--BATALLA NAVAL-- ");
                frame.setLayout(null);
		frame.setBounds(0, 0,1550,800);
		JLabel imagen = new JLabel();
                imagenPre.setBounds(600, 0, 600,500);//UBICACION DE LA IMAGEN ANTES DE JUGAR 
                imagenPre.setIcon(new ImageIcon(getClass(). getResource("fondo2.jpg")));
                imagen.setIcon(new ImageIcon(getClass(). getResource("fondobarco1.jpg"))); // iamgen de fondo de la ventana 
	        imagen.setBounds(0,0,1550,800);
                mensajeVentana1.setForeground(Color.black);//colores de los textos 
		mensajeVentana2.setForeground(Color.black);
		mensajeVentana3.setForeground(Color.black);
		mensajeVentana4.setForeground(Color.white);
		jugador1.setForeground(Color.white);
		jugador2.setForeground(Color.black);
                 mensajeVentana1.setBounds(650, 10, 300, 20);
		mensajeVentana2.setBounds(650,30, 300, 20);
		mensajeVentana3.setBounds(1000, 700, 300, 10);
		mensajeVentana4.setBounds(200, 700, 300, 10);
		jugador1.setBounds(200, 680, 300, 20);
		jugador2.setBounds(1000, 680, 300, 20);
		turno1.setBounds(100, 540, 300,25);
		turno2.setBounds(600,540, 300,25);
                turno1.setForeground(Color.white);
		turno2.setForeground(Color.white);
		turno1.setEnabled(false);
		turno2.setEnabled(false);
                frame.getContentPane().add(imagenPre);//es la imagen que va sobrepuesta antes de jugar 
                frame.getContentPane().add(mensajeVentana2);
		frame.getContentPane().add(mensajeVentana1);
		frame.getContentPane().add(mensajeVentana2);
		frame.getContentPane().add(mensajeVentana4);
		frame.getContentPane().add(jugador1);
		frame.getContentPane().add(jugador2);
		frame.getContentPane().add(turno1);
		frame.getContentPane().add(turno2);
                char[] s = new char[10];
                for (int i = 0; i < 10; i++) {
                    s[i] = (char) ('A' + i );
                    JLabel letras1 = new JLabel();//son las letras que aparecen alado de la matriz 
                    JLabel numeros1 = new JLabel();
                    numeros1.setForeground(Color.white);
                    letras1.setForeground(Color.white);
                    numeros1.setBounds(22+(50*i),510,50,10);//360
                    letras1.setBounds(510, 10 + (50 * i), 50, 50);//ubicacion de letra cuadro 1 
                    String s1 = String.valueOf(i);
                    numeros1.setText(s1);
                    s1 = String.valueOf(s[i]);
                    letras1.setText(s1);
                    frame.getContentPane().add(numeros1);
                    frame.getContentPane().add(letras1);
                    for(int j = 0; j < 10; j++) {
                        JButton tmp1 = new JButton();
                        tmp1.setBounds(50*j,50*i,50, 50);//CORREGIR 
                        botones[i][j] = tmp1;
                        frame.getContentPane().add(botones[i][j]);
                        botones[i][j].setIcon(new ImageIcon(getClass(). getResource("fondomar1.jpg")));
                        final int aux = i;
			final int aux2 = j;
                        botones[i][j].addActionListener(new java.awt.event.ActionListener(){
					public void actionPerformed (java.awt.event.ActionEvent  evt) {
						if (batallaNaval.marc(aux, aux2) == false && batallaNaval.probar(aux, aux2)) {	
                                                    botones[aux][aux2].setIcon(new ImageIcon(getClass(). getResource("fuego.jpg")));
						}
						else if (batallaNaval.marc(aux, aux2) == false)
							botones[aux][aux2].setEnabled(false);
						int cant = batallaNaval.getBarcos();
						String s = String.valueOf(cant);
                                                
                                                
                                                mensajeVentana4.setText("LE QUEDAN " + s + " BARCOS.");
						if (batallaNaval.getBarcos() == 0) {
							final Gano g = new Gano();
		 					g.start();
		 					g.frame.setTitle("Gan�!!!");
		 					g.label.setText("Felicitaciones!!! "+j1.getText()+" ha ganado.");
		 					g.aceptar.addActionListener(new java.awt.event.ActionListener(){
		 						public void actionPerformed (java.awt.event.ActionEvent  evt) {
		 							g.frame.dispose();
		 						}
		 					});
                                                        for (int p = 0; p < 10; p++) {
		 						for(int r = 0; r < 10; r++) {
		 							if(!batallaNaval.marc(p, r))
		 								botones[p][r].setEnabled(false);//la parte de abajo de donde se hace click
		 							if(!batallaNaval2.marc(p, r))
		 								botones[p][r].setEnabled(false);
		 						}
		 					}
		 				}
                                                else {
							if (batallaNaval.marc(aux, aux2) && !turno2.isEnabled()) {
								turno1.setEnabled(true);
								turno1.setBackground(Color.red);
								turno2.setEnabled(false);
								turno2.setBackground(null);
							}
							else {
								if(batallaNaval.marc2(aux, aux2)) {
									turno2.setEnabled(true);
									turno2.setBackground(Color.red);
									turno1.setEnabled(false);
									turno1.setBackground(null);
                                                                 }
                                                                
                                                                if(!maquina.isEnabled()) {//turno de maquina 
									boolean bandera = true;
									do {
										Random gen = new Random();//cambiar aqui para que envie aleatorio 
										Random gen2 = new Random();//cambiar aqui para que envie aleatorio 
										int num1 = gen.nextInt(10);
										int num2 = gen2.nextInt(10);
										uno = num1;
										dos = num2;
										if (batallaNaval2.marc2(num1, num2)==false) {
											timer.schedule(new RemindTask(), 1500);
											bandera = false;
											if (batallaNaval2.marc(num1, num2)) {
												bandera = true;
											}
										}	
									}while (bandera == true);
								}
                                                                
								else{ 	
									for (int p = 0; p < 10; p++) {
				 						for(int r = 0; r < 10; r++) {
				 							if (!batallaNaval.marc(p, r))
				 								botones[p][r].setEnabled(false);
				 							if (batallaNaval2.marc2(p, r) && !batallaNaval2.marc(p, r))
				 								botones[p][r].setEnabled(false);
				 							else
				 								botones[p][r].setEnabled(true);
				 						}
				 					}
								}
							}
						}
					}
				});

                        botones[i][j].addActionListener(new java.awt.event.ActionListener(){
					public void actionPerformed (java.awt.event.ActionEvent  evt) {
						if (batallaNaval2.marc(aux, aux2)== false && batallaNaval2.probar(aux, aux2)) {
							botones[aux][aux2].setIcon(new ImageIcon(getClass(). getResource("fuego.jpg")));
						}
						else if (batallaNaval2.marc(aux, aux2) == false)
							botones[aux][aux2].setEnabled(false);
						int cant = batallaNaval2.getBarcos();
						String s = String.valueOf(cant);
						
						mensajeVentana3.setText("LE QUEDAN " + s + " BARCOS.");
						if (batallaNaval2.getBarcos() == 0) {
							final Gano g = new Gano();
		 					g.start();
		 					if (maquina.isEnabled()) {
		 						g.frame.setTitle("Gano!!!");
		 						g.label.setText("Felicitaciones!!! "+ j2.getText()+ " ha ganado.");
		 					}
		 					else {
		 						g.frame.setTitle("Perdiste");
		 						g.label.setText("Has Perdido, intenta de nuevo.");
		 					}
		 					g.aceptar.addActionListener(new java.awt.event.ActionListener(){
		 						public void actionPerformed (java.awt.event.ActionEvent  evt) {
		 							g.frame.dispose();
		 						}
		 					});
		 					for (int p = 0; p < 10; p++) {
		 						for(int r = 0; r < 10; r++) {
		 							if(!batallaNaval.marc(p, r))
		 								botones[p][r].setEnabled(false);
		 							if(!batallaNaval2.marc(p, r))
		 								botones[p][r].setEnabled(false);
		 						}
		 					}
		 				}
						else {
							
							if (batallaNaval2.marc(aux, aux2) && !turno1.isEnabled()) {
								turno2.setEnabled(true);
								turno2.setBackground(Color.red);
								turno1.setEnabled(false);
								turno1.setBackground(null);
							}
							else {
								if(batallaNaval2.marc2(aux, aux2)) {
									turno1.setEnabled(true);
									turno1.setBackground(Color.red);
									turno2.setEnabled(false);
									turno2.setBackground(null);
								}
								if (maquina.isEnabled()) {
									for (int p = 0; p < 10; p++) {
				 						for(int r = 0; r < 10; r++) {
				 							if (!batallaNaval2.marc(p, r))
				 								botones[p][r].setEnabled(false);
				 							if (batallaNaval.marc2(p, r) && !batallaNaval.marc(p, r))
				 								botones[p][r].setEnabled(false);
				 							else
				 								botones[p][r].setEnabled(true);
				 						}
				 					}
								}
							}
						}
						
					}
				});
                                botones[i][j].setEnabled(false);
				frame.getContentPane().add(botones[i][j]);
				botones[i][j].setVisible(true);
 				botones[i][j].setEnabled(false);
				frame.getContentPane().add(botones[i][j]);
				botones[i][j].setVisible(true);
			}
		}           
                
                salir.setBounds(600, 340, 200, 30);//UBICACION DEL BOTON SALIR 
		salir.setForeground(Color.white);
		salir.setBackground(Color.black);
		completar.setBounds(650, 150, 100, 100);
		
		maquina.setBounds(600, 70, 200, 30);
		completar.setIcon(new ImageIcon(getClass(). getResource("jugar.jpg")));
		completar.setPressedIcon(new ImageIcon(getClass(). getResource("jugar2.jpg")));
		completar.setEnabled(false);
		frame.getContentPane().add(completar);
		frame.getContentPane().add(maquina);
		
		vaciar.setBounds(600, 260, 200, 30);
		vaciar.setForeground(Color.white);
		vaciar.setBackground(Color.black);
		
		maquina.setForeground(Color.white);
		maquina.setBackground(Color.black);
		cambiarJ.setBounds(600, 300, 200, 30);
		cambiarJ.setForeground(Color.white);
		cambiarJ.setBackground(Color.black);
		cambiarJ.setEnabled(false);
		frame.getContentPane().add(salir);
		frame.getContentPane().add(cambiarJ);
		frame.getContentPane().add(vaciar);
		maquina.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed (java.awt.event.ActionEvent  evt) {
				maquina.setEnabled(false);
				cambiarJ.setEnabled(true);
				jugador2.setText("JUGADOR 2 :  COMPUTADORA " );
				mensajeVentana1.setText("P R E S I O N E 'PLAY'");
				mensajeVentana2.setText("PARA COMENZAR LA BATALLA DE BARCOS .");
			}
		});
                
                completar.addActionListener(new java.awt.event.ActionListener(){//completar barcos 
			public void actionPerformed (java.awt.event.ActionEvent  evt) {
				if(!maquina.isEnabled()) {
					turno1.setEnabled(true);
					turno1.setBackground(Color.red);
					turno2.setEnabled(false);
					turno2.setBackground(null);
				}
				else {
					Random gen = new Random();
					int num1 = gen.nextInt(2)+1;
					if (num1 == 1) {
						turno1.setEnabled(true);
						turno1.setBackground(Color.red);
						turno2.setEnabled(false);
						turno2.setBackground(null);
					}
					else {
						turno2.setEnabled(true);
						turno2.setBackground(Color.red);
						turno1.setEnabled(false);
						turno1.setBackground(null);
					}
				}
                          
                        imagenPre.setBounds(0, 0, 0, 0);
				
			imagenPre.removeAll();
                        for (int i = 0; i < 10; i++) {
					for(int j = 0; j < 10; j++) {
						botones[i][j].setVisible(true);
                                                botones[i][j].setVisible(true);
						if (turno2.isEnabled()) {
							botones[i][j].setEnabled(true);
							botones[i][j].setEnabled(false);
						}
						if (turno1.isEnabled()) {
							botones[i][j].setEnabled(true);
							if (!maquina.isEnabled())
								botones[i][j].setEnabled(true);
							else
								botones[i][j].setEnabled(false);
						}
						botones[i][j].setIcon(new ImageIcon(getClass(). getResource("fondomar1.jpg")));//
						botones[i][j].setIcon(new ImageIcon(getClass(). getResource("fondomar1.jpg")));
					}
				}
				batallaNaval.completar();
				batallaNaval2.completar();
				int cant = batallaNaval.getBarcos();
				int cant2 = batallaNaval2.getBarcos();
				String s = String.valueOf(cant);
				String s2 = String.valueOf(cant2);
				mensajeVentana1.setText(null);
				mensajeVentana2.setText(null);
				mensajeVentana3.setText("LE QUEDAN " + s + " BARCOS.");
				mensajeVentana4.setText("LE QUEDAN " + s2 + " BARCOS.");
			}
		});
		vaciar.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed (java.awt.event.ActionEvent  evt) {
				for (int i = 0; i < 10; i++) {
					for(int j = 0; j < 10; j++) {
						botones[i][j].setVisible(false);
						botones[i][j].setEnabled(false);
						botones[i][j].setIcon(new ImageIcon(getClass(). getResource("fondomar1.jpg")));
						
						
					}
				}
				
				imagenPre.setIcon(new ImageIcon(getClass(). getResource("fondo2.jpg")));
				imagenPre.setBounds(0, 0, 600,500);
				
				completar.setEnabled(false);
				maquina.setEnabled(true);
				
				maquina.setVisible(true);
				
				batallaNaval.vaciar();
				batallaNaval2.vaciar();
				jugador2.setText(null);
				jugador1.setText(null);
				turno1.setEnabled(false);
				turno2.setEnabled(false);
				turno2.setBackground(null);
				turno1.setBackground(null);
				mensajeVentana1.setText("S E L E C C I O N E   C A N T I D A D ");
				mensajeVentana2.setText("D E J UG A D O R E S");
				mensajeVentana3.setText(null);
				mensajeVentana4.setText(null);
			}
		});
		frame.add(imagen); 
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public class RemindTask extends TimerTask {
	    public void run() {
	    	botones[uno][dos].doClick();
	    }
	}
	public void run() {
		this.crearGUI();
		
	}
}


                



                